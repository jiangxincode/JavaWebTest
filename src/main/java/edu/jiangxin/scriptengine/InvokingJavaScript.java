package edu.jiangxin.scriptengine;

import java.io.File;
import java.io.FileReader;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

import edu.jiangxin.path.GetPath;

public class InvokingJavaScript {
	public static void main(String[] args) throws Exception {
		ScriptEngineManager manager = new ScriptEngineManager();

		List<ScriptEngineFactory> list = manager.getEngineFactories();

		System.out.println(list.get(0).getNames());
		System.out.println(list.get(0).getMimeTypes());
		System.out.println(list.get(0).getEngineName());

		ScriptEngine engine = manager.getEngineByName("javascript");
		File file = new File(GetPath.getTestResourcePathWithPackage(new InvokingJavaScript()) + "demo.js");
		FileReader reader = new FileReader(file.getAbsolutePath().replaceAll("\\\\", "/"));
		engine.eval(reader);
		if (engine instanceof Invocable) {
			Invocable invoke = (Invocable) engine;
			Double sum = (Double) invoke.invokeFunction("addFun", 2, 3);
			System.out.println(sum);
		}
		reader.close();
	}
}