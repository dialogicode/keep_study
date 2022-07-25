package me.study.concurrency;

public class HelloThread extends Thread {
	@Override
	public void run() {
		System.out.println("world: " + Thread.currentThread().getName());
	}
}