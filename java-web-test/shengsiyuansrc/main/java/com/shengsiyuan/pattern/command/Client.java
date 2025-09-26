package com.shengsiyuan.pattern.command;

public class Client {
	public static void main(String[] args) {
		Receiver receiver = new Receiver();

		Command command = new ConcreteCommand(receiver);

		Invoker invoker = new Invoker(command);

		invoker.doInvokerAction();
	}
}
