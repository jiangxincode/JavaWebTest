package com.shengsiyuan.lesson078.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class GridEx {
	private Frame frame;

	private Button b1, b2, b3, b4, b5, b6;

	public void go() {
		frame = new Frame("Grid Layout");

		frame.setLayout(new GridLayout(3, 2));

		b1 = new Button("1");
		b2 = new Button("2");
		b3 = new Button("3");
		b4 = new Button("4");
		b5 = new Button("5");
		b6 = new Button("6");

		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.add(b4);
		frame.add(b5);
		frame.add(b6);

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		GridEx grid = new GridEx();

		grid.go();
	}

}
