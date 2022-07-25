package me.study.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class _04_Future_invokeAll {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Callable<String> hello = () -> {
			Thread.sleep(2000L);
			return "Hello";
		};

		Callable<String> java = () -> {
			Thread.sleep(2000L);
			return "java";
		};

		Callable<String> jinSeok = () -> {
			Thread.sleep(2000L);
			return "jinSeok";
		};

		List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, jinSeok));

		for (Future<String> f : futures) {
			System.out.println(f.get());
		}

		executorService.shutdown();
	}
}
