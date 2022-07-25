package me.study.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class _05_CompletableFuture_thenRun {
	public static void main(String[] args) throws ExecutionException, InterruptedException {

		// 리턴 타입이 있는 경우 (thenRun 사용)

		CompletableFuture<Void> futureThenRun = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hi thenRun " + Thread.currentThread().getName());
			return "Hi ThenRun";
		}).thenRun(() -> {
			System.out.println(Thread.currentThread().getName());
		});

		futureThenRun.get();
	}
}
