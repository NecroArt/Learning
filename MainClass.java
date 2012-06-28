import java.util.concurrent.TimeUnit;
import java.util.*;
import java.lang.InterruptedException;
import java.util.concurrent.TimeUnit;

public class MainClass {
	private static class RunnableClass implements Runnable {
        public void run() {
            while (true) {
                try {
                    System.out.println("qqq");
                    TimeUnit.SECONDS.sleep(10);
                }
                catch (InterruptedException ex) {}
            }
        }
    }
    private static boolean cacheUpdaterThreadRun;
    public static void main(String ar[]) {
        if (!cacheUpdaterThreadRun) {
			    //running of cache updating
			    Thread cacheUpdaterThread = new Thread(new RunnableClass());
			    cacheUpdaterThread.setDaemon(true);
			    cacheUpdaterThreadRun = true;
			    cacheUpdaterThread.start();
        }
    }
}
