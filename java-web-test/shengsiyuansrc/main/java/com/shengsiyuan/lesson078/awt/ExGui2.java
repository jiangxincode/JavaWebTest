package com.shengsiyuan.lesson078.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class ExGui2 {
	private Frame frame;

	private Button bn, bs, bw, be, bc;

	public void go() {
		frame = new Frame("Border Layout");

		bn = new Button("B1");
		bs = new Button("B2");
		bw = new Button("B3");
		be = new Button("B4");
		bc = new Button("B5");

		frame.add(bn, BorderLayout.NORTH);
		frame.add(bs, BorderLayout.SOUTH);
		frame.add(bw, BorderLayout.WEST);
		frame.add(be, BorderLayout.EAST);
		frame.add(bc, BorderLayout.CENTER);

		frame.setSize(200, 200);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		ExGui2 gui = new ExGui2();

		gui.go();
	}

}