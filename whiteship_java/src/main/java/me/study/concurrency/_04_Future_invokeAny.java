package me.study.concurrency;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _04_Future_invokeAny {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(4);

		Callable<String> hello = () -> {
			Thread.sleep(2000L);
			return "Hello";
		};

		Callable<String> java = () -> {
			Thread.sleep(3000L);
			return "java";
		};

		Callable<String> jinSeok = () -> {
			Thread.sleep(1000L);
			return "jinSeok";
		};

		String s = executorService.invokeAny(Arrays.asList(hello, java, jinSeok));
		System.out.println(s);

		executorService.shutdown();
	}
}
