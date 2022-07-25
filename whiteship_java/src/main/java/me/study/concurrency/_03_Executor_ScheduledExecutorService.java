package me.study.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class _03_Executor_ScheduledExecutorService {
	public static void main(String[] args) {
		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

		// 3초 딜레이후 실행
		scheduledExecutorService.schedule(getRunnable("Hello"), 3, TimeUnit.SECONDS);

		// 반복 실행 - shutdown 주석처리 후 실행
		scheduledExecutorService.scheduleAtFixedRate(getRunnable("Repeat"), 1, 2, TimeUnit.SECONDS);

		//scheduledExecutorService.shutdown(); // 실행 시엔 주석처리 하고 실행
	}

	private static Runnable getRunnable(String message) {
		return () -> System.out.println(message + " " + Thread.currentThread().getName());
	}
}
