package com.shengsiyuan.lesson080.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Date;

public class MyFrame2 {
	public static void main(String[] args) {
		Frame frame = new Frame("My Frame2");

		Button button = new Button("click me");

		button.addActionListener(new MyListener());

		frame.addWindowListener(new MyWindowListener());

		frame.add(button);

		frame.setSize(500, 500);

		frame.setVisible(true);

	}
}

class MyListener implements ActionListener {
	@Override
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		long milliSeconds = e.getWhen();

		Date date = new Date(milliSeconds);

		System.out.println(date.toLocaleString());
	}
}

class MyWindowListener implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("关闭窗口");
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}

}
