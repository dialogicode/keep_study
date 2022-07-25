package me.study.concurrency;

public class _02_UseThread_interrupt {
	public static void main(String[] args) throws InterruptedException {
		/* 쓰레드 주요 기능 */
		// 2. 다른 쓰레드 깨우기 (interrupt)
		Thread thread = new Thread(() -> {
			while (true) {
				System.out.println("Thread: " + Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("interrupted");
					return;
				}
			}
		});

		thread.start();
		System.out.println("hello: " + Thread.currentThread().getName());

		Thread.sleep(3000);
		thread.interrupt();
	}
}
