package com.shengsiyuan.pattern.defaultadapter;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AwtApp {
	public static void main(String[] args) {
		Frame frame = new Frame("title");

		frame.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				System.out.println("x: " + e.getX() + " y: " + e.getY());
			}
		});

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("关闭窗口");

				System.exit(0);
			}
		});

		frame.setSize(new Dimension(50, 100));

		frame.setVisible(true);

	}
}
