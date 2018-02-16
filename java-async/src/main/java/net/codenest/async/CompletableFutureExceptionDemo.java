package net.codenest.async;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExceptionDemo {

	public static void main(String[] args) throws Exception {
		withWhenComplete();
		AsyncUtil.sleepInSeconds(2);
	}

	public static void withWhenComplete() {
		CompletableFuture<Long> cf = new CompletableFuture<Long>();
		CompletableFutureE<Long> cfe = new CompletableFutureE<Long>();

		cfe.runAsyncE(() -> {
			//throw new RuntimeException("A RuntimeException occurs!");
		}).whenComplete((r, e) -> {
			cf.complete(7L);
		});

		System.out.println("cf = " + cf.join());
		System.out.println("exit with error?: " + cfe.withError());
	}

	public static void withExceptionally() {
		CompletableFutureE<Long> cfe = new CompletableFutureE<Long>(ex -> {
			System.out.println(ex.getMessage());
			return null;
		});
		
		cfe.runAsyncE(() -> {
			throw new RuntimeException("A RuntimeException occuurs!");
		}).join();
	}
}
