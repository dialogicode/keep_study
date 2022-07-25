package me.study.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _05_CompletableFuture {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		CompletableFuture<Void> futureThenRun = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hi ThenRun " + Thread.currentThread().getName());
			return "Hi ThenRun";
		}, executorService).thenRun(() -> {
			System.out.println(Thread.currentThread().getName());
		});

		futureThenRun.get();
		executorService.shutdown();

		System.out.println("===== ===== ===== ===== ===== ===== =====");

		// 리턴 타입이 없는 경우
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			System.out.println("Hello " + Thread.currentThread().getName());
		});
		future.get();

		System.out.println("===== ===== ===== ===== ===== ===== =====");

		// 리턴 타입이 있는 경우
		CompletableFuture<String> returnFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hello returnCheck " + Thread.currentThread().getName());
			return "Hi returnCheck";
		});
		System.out.println(returnFuture.get());
	}
}
