package net.codenest.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CFThreadDemo {

	public static void main(String[] args) throws Exception {
		CompletableFuture.runAsync(() -> {
			sleepSeconds(1);
			System.out.println("Process");
		}).join();
		System.out.println("End");
		sleepSeconds(2);
	}

	private static void sleepSeconds(final int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	private static void test2() {
		CompletableFuture.runAsync(() -> {
			System.out.println("Thread name = " + Thread.currentThread().getName());
			System.out.println("Process");
		});
		sleepSeconds(1);
		System.out.println("Thread name = " + Thread.currentThread().getName());
		System.out.println("End");
	}
	
	private static void test1() throws Exception {
		ExecutorService pool = Executors.newFixedThreadPool(10);

		System.out.println("Thread name = " + Thread.currentThread().getName());

		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			sleepSeconds(2);
			System.out.println("Thread name = " + Thread.currentThread().getName());
			return "ABC";
		}, pool);

		future.thenApply(s -> {
			System.out.println("First transformation");
			System.out.println("Thread name = " + Thread.currentThread().getName());
			return s.length();
		});

		future.get();
		pool.shutdownNow();
		pool.awaitTermination(1, TimeUnit.MINUTES);

		future.thenApply(s -> {
			System.out.println("Second transformation");
			System.out.println("Thread name = " + Thread.currentThread().getName());
			return s.length();
		});
	}
}
