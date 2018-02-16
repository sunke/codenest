package net.codenest.async;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureChainIfElse {
	private static int count = 7;

	public static void main(String[] args) throws Exception {
	
		getCondition().thenCompose(c -> {
			if (c) return getCF1();
			else return getCF2();
		}).join();
	}

	private static CompletableFuture<Boolean> getCondition() {
		return CompletableFuture.supplyAsync(() -> {
			boolean condition = false;
			AsyncUtil.sleepInSeconds(2);
			System.out.println("condition = " + condition);
			return condition;
		});
		
	}

	
	private static CompletableFuture<Void> getCF1() {
		return CompletableFuture.runAsync(() -> {
			AsyncUtil.sleepInSeconds(2);
			System.out.println("cf1: count = " + count++);
		});
	}

	private static CompletableFuture<Void> getCF2() {
		return CompletableFuture.runAsync(() -> {
			AsyncUtil.sleepInSeconds(2);
			System.out.println("cf2: count = " + count++);
		});
	}
}
