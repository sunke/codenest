package net.codenest.async;

import java.util.concurrent.CompletableFuture;

public class ExceptionHandleDemo {

	public static void main(String[] args) throws Exception {
		withWhenComplete();
	}

	public static void withWhenComplete() {
		CompletableFuture<Long> cf = new CompletableFuture<Long>();

		CompletableFuture.runAsync(() -> {
			throw new RuntimeException("A RuntimeException occuurs!");
		}).whenComplete((r, e) -> {
			//System.out.println(e.getMessage());
			cf.complete(7L);
		});
		
		cf.join();

		System.out.println("cf = " + cf.join());
	}

	public static void withExceptionally() {
		CompletableFuture.runAsync(() -> {
			throw new RuntimeException("A RuntimeException occuurs!");
		}).exceptionally(ex -> {
			System.out.println(ex.getMessage());
			return null;
		});
	}

	public static void withHandle() {
		CompletableFuture.runAsync(() -> {
			throw new RuntimeException("A RuntimeException occuurs!");
		}).handle((r, e) -> {
			System.out.println(e.getMessage());
			return null;
		});
	}
}
