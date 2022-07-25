package me.study.concurrency;

import java.util.concurrent.*;

public class _04_Future_isDone {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Callable<String> hello = () -> {
			Thread.sleep(2000L);
			return "Hello";
		};

		Future<String> helloFuture = executorService.submit(hello);
		System.out.println(helloFuture.isDone());
		System.out.println("Start!");

		helloFuture.get(); // 블록킹 콜

		System.out.println(helloFuture.isDone());
		System.out.println("End!");

		executorService.shutdown();
	}
}
