package net.codenest.async;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
 
public class FutureDemo {
	static ExecutorService executor = Executors.newFixedThreadPool(10);
 
	public static void main(String[] args) throws Exception {
 
		Future<String> future = createFuture("running Future");
 
		System.out.println("Calculation running in the thread " + Thread.currentThread().getName());

		System.out.println(future.get());
	}
 
	static Future<String> createFuture(String inString) throws Exception {
		return executor.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				AsyncUtil.sleepInSeconds(3);
				System.out.println("Calculation running in Future within the thread " + Thread.currentThread().getName());
				return "Done";
			}
		});
	}
}