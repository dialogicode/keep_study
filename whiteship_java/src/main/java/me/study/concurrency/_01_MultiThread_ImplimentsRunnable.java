package me.study.concurrency;

public class _01_MultiThread_ImplimentsRunnable {
	public static void main(String[] args) {
		/* 자바 멀티 쓰레드 프로그래밍 */

		// 2. Runnable 구현 또는 람다
		Thread thread = new Thread(() -> System.out.println("world: " + Thread.currentThread().getName()));
		thread.start();

		System.out.println("hello: " + Thread.currentThread().getName());
	}
}
