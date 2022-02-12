package com.thread.test;

class Add implements Runnable{
	
	int count = 0;
	
	public void run() {
		for(int i=1;i<=1000;i++) {
			increment();
		}		
	}
	
	private synchronized void increment() {
		System.out.println("current : "+Thread.currentThread().getName());
		
		count = count+1;
	}	
}

// to spped up , max process activitiy 
// overlap 
// sync
// deadlock solve
// interthread communication

public class Demo2 {
	public static void main(String[] args) throws Exception{
		Add add = new Add();
		Thread t1 = new Thread(add,"T1");
		Thread t2 = new Thread(add,"T2");
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Total : "+add.count);
	}
}
