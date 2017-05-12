package edu.jiangxin.office;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class ExcelDispatchTest {

	public static void main(String[] args) {
		// put "jacob-${JACOB_VERSION}-x64/x32.dll" in the ${java.library.path}
		System.out.println(System.getProperty("java.library.path"));

		ComThread.InitSTA();

		ActiveXComponent activeXComponent = new ActiveXComponent("Excel.Application");
		try {
			System.out.println("version=" + activeXComponent.getProperty("Version"));
			System.out.println("version=" + Dispatch.get(activeXComponent, "Version"));
			Dispatch.put(activeXComponent, "Visible", new Variant(true));
			Dispatch workbooks = activeXComponent.getProperty("Workbooks").toDispatch();
			Dispatch workbook = Dispatch.get(workbooks, "Add").toDispatch();
			Dispatch sheet = Dispatch.get(workbook, "ActiveSheet").toDispatch();
			Dispatch a1 = Dispatch.invoke(sheet, "Range", Dispatch.Get, new Object[] { "A1" }, new int[1]).toDispatch();
			Dispatch a2 = Dispatch.invoke(sheet, "Range", Dispatch.Get, new Object[] { "A2" }, new int[1]).toDispatch();
			Dispatch.put(a1, "Value", "123.456");
			Dispatch.put(a2, "Formula", "=A1*2");
			System.out.println("a1 from excel:" + Dispatch.get(a1, "Value"));
			System.out.println("a2 from excel:" + Dispatch.get(a2, "Value"));
			Variant variant = new Variant(false);
			Dispatch.call(workbook, "Close", variant);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			activeXComponent.invoke("Quit", new Variant[] {});
			ComThread.Release();
		}
	}
}