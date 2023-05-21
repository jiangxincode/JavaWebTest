package edu.jiangxin.crawler;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class UrlUtility {

	private static String m_urlPatternString = "(?i)(?s)<\\s*?a.*?href=\"(.*?)\".*?>";
	private static Pattern m_urlPattern = Pattern.compile(m_urlPatternString);

	private static Logger m_debug = LogManager.getLogger(UrlUtility.class);

	public static void ExtractURL(String baseUrl, String content) {
		Matcher matcher = m_urlPattern.matcher(content);
		while (matcher.find()) {
			String anchor = matcher.group();

			String url = Utility.GetSubString(anchor, "href=\"", "\"");
			if ((url = UrlUtility.Refine(baseUrl, url)) != null) {
				Queue.Add(url);
			}
		}
	}

	// 将"url"变为编码为合法的URL
	public static String Encode(String url) {
		String res = "";
		for (char c : url.toCharArray()) {
			if (!":/.?&#=".contains("" + c)) {
				try {
					res += URLEncoder.encode("" + c, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					m_debug.debug("This JVM has no UTF-8 charset. It's strange");
				}
			} else {
				res += c;
			}
		}

		return res;
	}

	public static String Normalizer(String url) {
		url = url.replaceAll("&amp;", "&");
		if (url.endsWith("/")) {
			url = url.substring(0, url.length() - 1);
		}

		return url;
	}

	// 拼接URL
	public static String Refine(String baseUrl, String relative) {
		if (baseUrl == null || relative == null) {
			return null;
		}

		final Url base = Parse(baseUrl), url = Parse(relative);
		if (base == null || url == null) {
			return null;
		}

		if (url.scheme == null) {
			url.scheme = base.scheme;
			if (url.host == null) {
				url.host = base.host;
			}
		}

		if (url.path.startsWith("../")) {
			String prefix = "";
			int idx = base.path.lastIndexOf('/');
			if ((idx = base.path.lastIndexOf('/', idx - 1)) > 0)
				prefix = base.path.substring(0, idx);
			url.path = prefix + url.path.substring(3);
		}

		return Normalizer(url.ToUrl());
	}

	// 拆分URL成scheme, host, path
	private static Url Parse(String link) {
		int idx, endIndex;
		final Url url = new Url();

		if ((idx = link.indexOf("#")) >= 0) { // ignore fragment
			if (idx == 0)
				return null;
			else
				link = link.substring(0, idx - 1);
		}

		// if( (idx = link.indexOf("?")) > 0 ) { //ignore query information
		// link = link.substring(0, idx);
		// }

		if ((idx = link.indexOf(":")) > 0) {
			url.scheme = link.substring(0, idx).trim();
			if (IsLegalScheme(url.scheme)) {
				link = link.substring(idx + 1);
			} else {
				return null;
			}
		}

		if (link.startsWith("//")) {
			if ((endIndex = link.indexOf('/', 2)) > 0) {
				url.host = link.substring(2, endIndex).trim();
				link = link.substring(endIndex + 1);
			} else {
				url.host = link.substring(2).trim();
				link = null;
			}
		}

		if (link != null)
			url.path = link.trim();
		else
			url.path = "";

		return url;
	}

	// 判断scheme是否合法（要处理的scheme类型）
	private static boolean IsLegalScheme(String scheme) {
		if (scheme.equals("http") || scheme.equals("https")
				|| scheme.equals("ftp"))
			return true;
		else
			return false;
	}

	private static class Url {
		public Url() {
		}

		public String ToUrl() {
			String prefix = null;
			if (path.startsWith("/"))
				prefix = scheme + "://" + host;
			else
				prefix = scheme + "://" + host + "/";

			return prefix + path;
		}

		public String scheme;
		public String host;
		public String path;
	}
}
