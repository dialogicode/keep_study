package me.study.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _03_Executor_ExecutorService {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

		executorService.submit(() -> {
			System.out.println("Thread: " + Thread.currentThread().getName());
		});

		executorService.shutdown();
		//executorService.shutdownNow(); // 당장 종료
	}
}
