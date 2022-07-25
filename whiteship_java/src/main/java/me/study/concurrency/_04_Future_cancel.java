package me.study.concurrency;

import java.util.concurrent.*;

public class _04_Future_cancel {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executorService  = Executors.newSingleThreadExecutor();

		Callable<String> hello = () -> {
			Thread.sleep(2000L);
			return "Hello";
		};

		Future<String> helloFuture = executorService.submit(hello);
		System.out.println(helloFuture.isDone());
		System.out.println("Start!");

		helloFuture.cancel(false);

		// 아래의 isDone 은 위에서 cancel 했기 때문에 값을 가져오는 것
		System.out.println(helloFuture.isDone());
		System.out.println("End!");

		// helloFuture.get(); - 작업 취소 이후에 값을 가져오려 하면 CancellationException 예외 발생

		executorService.shutdown();
	}
}
