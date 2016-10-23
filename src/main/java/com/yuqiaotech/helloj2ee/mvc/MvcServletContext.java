package com.yuqiaotech.helloj2ee.mvc;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 为方便存取request和response写的一个简单的类。
 *
 */
public class MvcServletContext {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private Map sessionMap;
	private Object handler;

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Object getHandler() {
		return handler;
	}

	public void setHandler(Object handler) {
		this.handler = handler;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSessionMap(Map sessionMap) {
		this.sessionMap = sessionMap;
	}

	public Map getSessionMap() {
		if (sessionMap == null) {
			sessionMap = new Map<String, Object>() {

				public int size() {
					return 0;
				}

				public boolean isEmpty() {
					return false;
				}

				public boolean containsKey(Object key) {
					return false;
				}

				public boolean containsValue(Object value) {
					return false;
				}

				public Object get(Object key) {
					return session.getAttribute((String) key);
				}

				public Object put(String key, Object value) {
					session.setAttribute((String) key, value);
					return value;
				}

				public Object remove(Object key) {
					session.removeAttribute((String) key);
					return null;
				}

				public void putAll(Map m) {
				}

				public void clear() {
				}

				public Set keySet() {
					return null;
				}

				public Collection values() {
					return null;
				}

				public Set entrySet() {
					return null;
				}
			};
		}
		return sessionMap;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}
}
