import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class App implements Runnable{
	
	
	public void run() {
		for(int i=1;i<=5;i++) {
			System.out.println(i+"  "+ Thread.currentThread().getName());
		}
		
	}
}


public class Demo1 {

	public static void main(String[] args) {
		
		// thread :   object
		
		App app = new App();
		Thread th1 = new Thread(app,"Th1");
		Thread th2 = new Thread(app,"Th2");
		
		/*
		 * th1.start(); th2.start();
		 */
		
		// separate path of execution
		
		ExecutorService tp = Executors.newFixedThreadPool(2);
		tp.execute(app);
		tp.execute(app);
		tp.execute(app);
		tp.execute(app);
	

	}

}


/*App : normal class
 * Runnable type: Thread accessible 
 *
 * 
 * 
 *
 * 1. multithreading / parallel programming :  speed up the work and resource utilization
 * 2. synchronized:   only one thread should execute the block  :  locking  object level, class level, syn block( this  / A.class)
 * 3. deadlock
 * 4. inter
 * 5. locking
 * 
 * 
 * 
 * Executors
 * 
 */