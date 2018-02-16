package net.codenest.async;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class CompletableFutureE<T> extends CompletableFuture<T> {
	private boolean withError = false;
	private Function<Throwable, ? extends Void> exceptionHandler;
	
	public CompletableFutureE(Function<Throwable, ? extends Void> exceptionHandler) {
		super();
		this.exceptionHandler = exceptionHandler;
	}
	
	public CompletableFutureE() {
		super();
		this.exceptionHandler = ex -> {
			System.out.println(ex.getMessage());
			withError = true;
			return null;
		};
	}
	
	public boolean withError() {
		return this.withError;
	}
	
	public CompletableFuture<Void> runAsyncE(Runnable runnable) {
		return CompletableFuture.runAsync(runnable).exceptionally(exceptionHandler);
    }
	
	public <U> CompletableFuture<U> thenApplyE(Function<? super T,? extends U> fn) {
		//return super.thenApply(fn).exceptionally(exceptionHandler);
		return super.thenApply(fn);
	}

}
