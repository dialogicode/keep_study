package me.study.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

public class _05_CompletableFuture_thenCompose {
	public static void main(String[] args) throws ExecutionException, InterruptedException {

		// thenCompose()
		// 두 작업이 서로 이어서 실행하도록 조합
		// 두 작업이 연관관계가 있을 때

		CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hello " + Thread.currentThread().getName());
			return "Hello";
		});

		CompletableFuture<String> future = hello.thenCompose(s -> getWorld("안녕하세요"));

		System.out.println(future.get());
	}

	private static CompletionStage<String> getWorld(String message) {
		return CompletableFuture.supplyAsync(() -> {
			System.out.println(message + " " + Thread.currentThread().getName());
			return message + " World";
		});
	}
}
