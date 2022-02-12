package com.thread.test;

//locking. object level, class level. 

// non static method , synch  object level

class Bank implements Runnable {

	public void run() {
		for (int i = 1; i <= 5; i++)
			withdraw();
	}												///
	                                           //
	private static synchronized void withdraw() {/// lock > Bank.class lock
		System.out.println("current : " + Thread.currentThread().getName());
		try {
			Thread.sleep(10*1000);//holds the lock
		} catch (Exception ex) {
		}
	}
}

public class Demo3 {
	public static void main(String[] args) {

		Bank bank1 = new Bank();
		Bank bank2 = new Bank();

		Thread t1 = new Thread(bank1,"T1");
		Thread t2 = new Thread(bank2,"T2");

		t1.start();
		t2.start();

	}
}
