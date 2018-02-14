package net.codenest.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static net.codenest.async.AsyncUtil.*;

public class APWorkflowProblemDemo {
	private static ExecutorService executor = Executors.newFixedThreadPool(1); // Executors.newFixedThreadPool(2);

	public static void main(String[] args) throws Exception {
		runWorkflow();
		sleepInSeconds(3); // sleep 3 seconds to observe threads behavior
		executor.shutdown();
	}

	public static void runWorkflow() {
		System.out.println("runWorkflow: thread name = " + Thread.currentThread().getName());
		CompletableFuture.runAsync(() -> interpreterExecute(), executor);
	}

	public static void interpreterExecute() {
		System.out.println("interpreterExecute: thread name = " + Thread.currentThread().getName());

		// simulate the behavior of set value command
		CompletableFuture.runAsync(() -> {
			System.out.println("interpreterExecute runAsync: thread name = " + Thread.currentThread().getName());
			sleepInSeconds(2);
		}, executor).join();
	}
}
