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

		/* Callabe & Future */

		// Callable : Runnable 과 유사하지만 작업의 결과를 받을 수 있다.
		// Future : 비동기적인 작업의 현재 상태를 조회하거나 결과를 가져올 수 있다

		// get() : 결과를 가져오기
		// 블록킹 콜 : 결과를 가져올 때까지 기다린다.
		// 타임아웃 (최대한으로 기다릴 시간)을 설정 가능

		// isDone() : 작업 상태 확인
		// 작업을 완료했으면 true 아니면 false 를 리턴

		// cancel() : 작업 취소
		// 취소했으면 true 못했으면 false 리턴
		// parameter 로 true를 전달하면 현재 진행중인 쓰레드를 interrupt, 그렇지 않으면 진행중 작업이 끝날때까지 기다린다

		// invokeAll() : 여러 작업 동시에 실행하기
		// 동시에 실행한 작업 중에 제일 오래 걸리는 작업만큼 시간이 걸린다.
		// 모든 결과가 나올 때까지 기다린다.

		// invokeAny() : 여러 작업 중에 하나라도 먼저 응답이 오면 끝내기
		// 동시에 실행한 작업 중에 제일 짧게 걸리는 작업만큼 시간이 걸린다
		// 블록킹 콜이다
		// 단, 싱글 쓰레드로 할 경우 먼저 들어간 순서대로 나오게 된다
	}
}

