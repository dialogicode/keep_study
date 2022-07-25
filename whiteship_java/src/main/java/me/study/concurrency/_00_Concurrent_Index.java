package me.study.concurrency;

public class _00_Concurrent_Index {
	public static void main(String[] args) {
		/* Concurrent 소프트웨어 : 동시에 여러 작업을 할 수 있는 소프트웨어 */
		// 자바에서 지원하는 동시성 프로그래밍
		// 1. 멀티 프로세싱 (ProcessBuilder)
		// 2. 멀티 쓰레드

		/* 자바 멀티 쓰레드 프로그래밍 */
		// 1. Thread 상속
		// 2. Runnable 구현 또는 람다

		/* 쓰레드 주요 기능 */
		// 1. 현재 쓰레드 멈춰두기 (sleep)
		// 2. 다른 쓰레드 깨우기 (interrupt)
		// 3. 다른 쓰레드 기다리기 (join)

		/* Executors : 고수준 Concurrency 프로그래밍 */
		// 쓰레드를 만들고 관리하는 작업을 애프리케이션에서 분리
		// Executors 기능 1 : 쓰레드 만들기 : 애플리케이션이 사용할 쓰레드 풀을 만들어 관리
		// Executors 기능 2 : 쓰레드 관리 : 쓰레드 생명 주기를 관리
		// Executors 기능 3 : 작업 처리 및 실행 : 쓰레드로 실행할 작업을 제공할 수 있는 API 제공

		// 주요 인터페이스

		// Executor
		// execute(Runnable)

		// ExecutorService
		// Executor 상속받은 인터페이스로, Callable 실행할 수 있으며, Executor 를 종료시키거나, 여러 Callable 을 동시에 실행하는 기능 제공

		// ScheduledExecutorService
		// ExecutorService 상속받은 인터페이스로 특정 시간 이후에 주기적으로 작업을 실행할 수 있다
	}
}

