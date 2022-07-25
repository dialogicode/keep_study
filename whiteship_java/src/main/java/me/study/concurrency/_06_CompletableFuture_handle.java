package me.study.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class _06_CompletableFuture_handle {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		boolean throwError = true;

		CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
			if (throwError) {
				throw new IllegalArgumentException();
			}
			System.out.println("Hello " + Thread.currentThread().getName());
			return "Hello";
		}).handle((result, ex) -> {
			if (ex != null) {
				System.out.println(ex);
				System.out.println("Error handle");
			}
			return result;
		});

		System.out.println(hello.get());
	}
}
