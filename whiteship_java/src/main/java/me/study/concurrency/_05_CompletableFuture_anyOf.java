package me.study.concurrency;

import java.util.concurrent.CompletableFuture;

public class _05_CompletableFuture_anyOf {
	public static void main(String[] args) throws InterruptedException {

		// anyOf()
		// 여러 작업 중에 가장 빨리 끝난 하나의 결과에 콜백 실행

		CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hello " + Thread.currentThread().getName());
			return "Hello";
		});

		CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
			System.out.println("World " + Thread.currentThread().getName());
			return "World";
		});

		CompletableFuture.anyOf(hello, world).thenAccept(System.out::println);

		Thread.sleep(1000L); // 메인 쓰레드가 먼저 종료되면 콜백이 안나타날 수도 있다
	}
}
