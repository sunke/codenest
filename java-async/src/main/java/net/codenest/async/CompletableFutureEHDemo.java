package net.codenest.async;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureEHDemo {

	public static void main(String[] args) throws Exception {
		withExceptionally();
	}

	public static void withWhenComplete() {
		CompletableFuture<Long> cf = new CompletableFuture<Long>();
		CompletableFutureEH<Long> cfe = new CompletableFutureEH<Long>(ex -> {
			System.out.println(ex.getMessage());
			return null;
		});

		cfe.runAsyncEH(() -> {
			throw new RuntimeException("A RuntimeException occuurs!");
		}).whenComplete((r, e) -> {
			cf.complete(7L);
		});

		System.out.println("cf = " + cf.join());
	}

	public static void withExceptionally() {
		CompletableFutureEH<Long> cfe = new CompletableFutureEH<Long>(ex -> {
			System.out.println(ex.getMessage());
			return null;
		});
		
		cfe.runAsyncEH(() -> {
			throw new RuntimeException("A RuntimeException occuurs!");
		}).join();
	}
}
