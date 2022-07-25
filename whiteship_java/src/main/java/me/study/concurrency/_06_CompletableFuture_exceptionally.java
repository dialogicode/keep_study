package me.study.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class _06_CompletableFuture_exceptionally {
	public static void main(String[] args) throws ExecutionException, InterruptedException {

		// 예외 처리 exceptionally

		boolean throwError = true;

		CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
			if (throwError) {
				throw new IllegalArgumentException();
			}
			System.out.println("Hello " + Thread.currentThread().getName());
			return "Hello";
		}).exceptionally(ex -> {
			System.out.println(ex);
			return "Error!";
		});

		System.out.println(hello.get());
	}
}
