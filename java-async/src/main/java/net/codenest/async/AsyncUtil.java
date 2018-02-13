package net.codenest.async;

public class AsyncUtil {
	
	public static void sleepInSeconds(final int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
