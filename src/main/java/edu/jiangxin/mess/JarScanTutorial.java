package edu.jiangxin.mess;

import de.dixti.jarscan.JarScan;
import de.dixti.jarscan.Options;
import de.dixti.jarscan.Result;
import java.io.File;

public class JarScanTutorial {

	public static void main(String[] args) {
		Options options = new Options("text");
		options.setDir(new File("."));
		options.setClassVersionString(">1.5");
		options.setVerbose(true);
		JarScan jarScan = new JarScan(options);
		jarScan.setPrinter(null);
		Result rootResult = jarScan.scan();
		for (Result result : rootResult.getResultList()) {
			System.out.println(result.getPath());
			for (Result subResult : result.getResultList()) {
				System.out.println(subResult.getPath());
			}
		}
	}
}
