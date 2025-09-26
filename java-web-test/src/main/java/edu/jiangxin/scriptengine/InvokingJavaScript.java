package edu.jiangxin.scriptengine;

import java.io.FileReader;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

public class InvokingJavaScript {
	public static void main(String[] args) throws Exception {
		ScriptEngineManager manager = new ScriptEngineManager();

		List<ScriptEngineFactory> factories = manager.getEngineFactories();

		for (ScriptEngineFactory factory : factories) {
			System.out.println("name: " + factory.getNames());
			System.out.println("mimeType: " + factory.getMimeTypes());
			System.out.println("engineName: " + factory.getEngineName());
			System.out.println("----------------");
		}

		ScriptEngine engine = manager.getEngineByName("javascript");
		FileReader reader = new FileReader(InvokingJavaScript.class.getResource("demo.js").getPath());
		engine.eval(reader);
		if (engine instanceof Invocable) {
			Invocable invoke = (Invocable) engine;
			Double sum = (Double) invoke.invokeFunction("addFun", 2, 3);
			System.out.println(sum);
		}
		reader.close();
	}
}