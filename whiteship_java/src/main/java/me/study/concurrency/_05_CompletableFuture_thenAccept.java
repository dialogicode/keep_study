package me.study.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class _05_CompletableFuture_thenAccept {
	public static void main(String[] args) throws ExecutionException, InterruptedException {

		// 리턴 값 받아서 다른 값으로 바꾸는 콜백 (thenAccept 사용)

		CompletableFuture<Void> futureThenAccept = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hi thenAccept " + Thread.currentThread().getName());
			return "Hi ThenAccept";
		}).thenAccept((s) -> {
			System.out.println(Thread.currentThread().getName());
			System.out.println(s.toUpperCase());
		});

		futureThenAccept.get();
	}
}
