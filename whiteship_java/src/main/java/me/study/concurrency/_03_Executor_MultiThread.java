package me.study.concurrency;

import java.io.ObjectInputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _03_Executor_MultiThread {
	public static void main(String[] args) {
		// 쓰레드 2개 생성
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		executorService.submit(getRunnable("Hello"));
		executorService.submit(getRunnable("JinSeok"));
		executorService.submit(getRunnable("The"));
		executorService.submit(getRunnable("Java"));
		executorService.submit(getRunnable("Thread"));

		executorService.shutdown();
	}

	private static Runnable getRunnable(String message) {
		return () -> System.out.println(message + " " + Thread.currentThread().getName());
	}
}
