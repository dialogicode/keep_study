package me.study.concurrency;

public class _02_UseThread_join {
	public static void main(String[] args) throws InterruptedException {
		/* 쓰레드 주요 기능 */
		// 3. 다른 쓰레드 기다리기 (join)
		Thread thread = new Thread(() -> {
			System.out.println("Thread: " + Thread.currentThread().getName());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
		});

		thread.start();

		System.out.println("hello: " + Thread.currentThread().getName());
		thread.join(); // 해당 쓰레드를 기다린 후
		System.out.println(thread + " is finished");
	}
}
