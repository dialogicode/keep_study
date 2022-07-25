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

		/* CompletableFuture */
		// 자바에서 비동기(Asynchronous) 프로그래밍을 가능케하는 인터페이스
		// Future 를 사용해도 어느정도 가능했지만 하기 힘든 일들이 많았다

		// Future 로는 하기 어렵던 작업들
		// - Future를 외부에서 완료 시킬 수 없다. 취소하거나, get() 에 타임아웃을 설정할 수는 있다.
		// - 블로킹 코드 (get()) 를 사용하지 않고서는 작업이 끝났을 때 콜백을 실행할 수 없다
		// - 여러 Future 를 조합할 수 없다
		// - 예외 처리용 API 를 제공하지 않는다

		// 리턴 값이 없는 경우: runAsync()
		// 리턴 값이 있는 경우: supplyAsync()
		// 원하는 Executor(쓰레드풀) 를 사용해서 실행할 수도 있다 (기본은 ForkJoinPool.commonPool())

		/* CompletableFuture - Callback 제공하기 */
		// thenApply(Function) : 리턴 값을 받아서 다른 값으로 바꾸는 콜백
		// thenAccept(Consumer) : 리턴 값을 또 다른 작업을 처리하는 콜백 (리턴 없이)
		// thenRun(Runnable) : 리턴값 받지 않고 다른 작업을 처리하는 콜백
		// 콜백 자체를 또 다른 쓰레드에서 실행할 수 있다

		/* CompletableFuture - 조합하기 */
		// thenCompose()
		// 두 작업이 서로 이어서 실행하도록 조합
		// 두 작업이 연관관계가 있을 때

		// thenCombine()
		// 두 작업을 독립적으로 실행하고 둘 다 종료했을 때 콜백 실행

		// allOf()
		// 여러 작업을 모두 실행하고 모든 작업 결과에 콜백 실행
		// 각각의 결과가 오류 발생 및 리턴 타입이 다를 수 있으므로 List 로 받아서 해야한다.
		// return type 이 void 인 경우 null 발생 (리턴을 받을 수 없으므로)

		// anyOf()
		// 여러 작업 중에 가장 빨리 끝난 하나의 결과에 콜백 실행

		/* CompletableFuture 예외처리 */
		// exceptionally() 내부에서 예외 처리

	}
}

