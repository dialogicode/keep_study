package me.study.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class _05_CompletableFuture_thenApply {
	public static void main(String[] args) throws ExecutionException, InterruptedException {

		// 리턴 타입이 있는 경우 (thenApply 사용)

		CompletableFuture<String> futureThenApply = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hi ThenApply " + Thread.currentThread().getName());
			return "Hi ThenApply";
		}).thenApply((s) -> {
			System.out.println(Thread.currentThread().getName());
			return s.toUpperCase();
		});

		System.out.println(futureThenApply.get());
	}
}
