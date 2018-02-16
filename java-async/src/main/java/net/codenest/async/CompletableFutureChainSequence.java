package net.codenest.async;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureChainSequence {
	private static int count = 7;

	public static void main(String[] args) throws Exception {
		CompletableFuture<Void> result = CompletableFuture.completedFuture(null);
		System.out.println("main: thread name = " + Thread.currentThread().getName());
		
		result.thenCompose(c -> {
			return getCF1();
		});
		
		result.thenCompose(c -> {
			return getCF2();
		});
		
		result.join();
		AsyncUtil.sleepInSeconds(5);
	}

	private static CompletableFuture<Void> getCF1() {
		return CompletableFuture.runAsync(() -> {
			AsyncUtil.sleepInSeconds(2);
			System.out.println("cf1: count = " + count++);
			System.out.println("getCF1: thread name = " + Thread.currentThread().getName());
		});
	}

	private static CompletableFuture<Void> getCF2() {
		return CompletableFuture.runAsync(() -> {
			AsyncUtil.sleepInSeconds(2);
			System.out.println("cf2: count = " + count++);
			System.out.println("getCF2: thread name = " + Thread.currentThread().getName());
		});
	}
}
