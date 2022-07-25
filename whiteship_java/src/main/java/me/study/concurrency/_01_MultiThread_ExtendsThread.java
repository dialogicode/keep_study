package me.study.concurrency;

public class _01_MultiThread_ExtendsThread {
	public static void main(String[] args) {
		/* 자바 멀티 쓰레드 프로그래밍 */
		// 1. Thread 상속
		HelloThread helloThread = new HelloThread();
		helloThread.start();
		System.out.println("hello: " + Thread.currentThread().getName());
	}
}