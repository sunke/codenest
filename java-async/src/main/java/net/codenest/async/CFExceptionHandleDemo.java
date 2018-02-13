package net.codenest.async;

import java.util.concurrent.CompletableFuture;

public class CFExceptionHandleDemo {

	public static void main(String[] args) throws Exception {
		withoutExceptionHandling();
	}

	/**
	 * This demo shows that an exception is silently ignored if there is no
	 * exception handling attached to the CF.
	 */
	public static void withoutExceptionHandling() {
		CompletableFuture<Long> cf = new CompletableFuture();

		CompletableFuture.runAsync(() -> {
			System.out.println("Begin execution.");
			throw new RuntimeException("A RuntimeException occuurs!");
		}).whenComplete((r, e) -> {
			System.out.println("End execution");
			cf.complete(7L);
		});

		System.out.println("cf = " + cf.join());
	}

	public static void withExceptionally() {
		CompletableFuture.runAsync(() -> {
			throw new RuntimeException("A RuntimeException occuurs!");
		}).exceptionally(ex -> {
			System.out.println("Error: " + ex.getMessage());
			return null;
		});
	}
}
