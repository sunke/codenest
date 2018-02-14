package net.codenest.async;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class CompletableFutureEH<T> extends CompletableFuture<T> {
	private Function<Throwable, ? extends Void> exceptionHandler;
	
	public CompletableFutureEH(Function<Throwable, ? extends Void> exceptionHandler) {
		this.exceptionHandler = exceptionHandler;
	}
	
	public CompletableFuture<Void> runAsyncEH(Runnable runnable) {
		return CompletableFuture.runAsync(runnable).exceptionally(exceptionHandler);
    }
	
	public <U> CompletableFuture<U> thenApplyEH(Function<? super T,? extends U> fn) {
		return null;
		//return super.thenApply(fn).exceptionally(exceptionHandler);
	}

}
