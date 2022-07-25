package me.study.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class _05_CompletableFuture_allOf {
	public static void main(String[] args) throws ExecutionException, InterruptedException {

		// allOf()
		// 여러 작업을 모두 실행하고 모든 작업 결과에 콜백 실행
		// 각각의 결과가 오류 발생 및 리턴 타입이 다를 수 있으므로 List 로 받아서 해야한다.
		// return type 이 void 인 경우 null 발생 (리턴을 받을 수 없으므로)

		CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hello " + Thread.currentThread().getName());
			return "Hello";
		});

		CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
			System.out.println("World " + Thread.currentThread().getName());
			//return 1000;
			return "World";
		});

		//CompletableFuture<Void> future = CompletableFuture.allOf(hello, world).thenAccept(System.out::println);
		//System.out.println(future.get());
		// null 발생 - 해결하기 위해 아래처럼 리스트에 담아줘야 한다

		List<CompletableFuture<String>> futures = Arrays.asList(hello, world); // Future 의 리스트
		CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]); // 리스트 -> 배열

		CompletableFuture<List<Object>> results = CompletableFuture.allOf(futuresArray).thenApply(v -> {
			return futures.stream().map(f -> f.join()).collect(Collectors.toList());
		});

		results.get().forEach(System.out::println);
	}
}
