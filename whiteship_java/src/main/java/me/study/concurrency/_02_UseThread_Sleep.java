package me.study.concurrency;

public class _02_UseThread_Sleep {
	public static void main(String[] args) {
		/* 쓰레드 주요 기능 */
		// 1. 현재 쓰레드 멈춰두기 (sleep)
		Thread thread = new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("world: " + Thread.currentThread().getName());
		});

		thread.start();
		System.out.println("hello: " + Thread.currentThread().getName());
	}
}
