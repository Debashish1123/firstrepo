package com.thread.test;

public class Demo4 {
	public static void main(String[] args) {
		
		Bank lock1 = new Bank();
		String lock2 = new String();		
		
		Runnable r1 = ()->{
			System.out.println(Thread.currentThread().getName()+" is trying for lock1");
			synchronized (lock1) {
				System.out.println(Thread.currentThread().getName()+" is acquired lock1 and trying for lock 2");
				for(long i = 1;i<=9999999L;i++);//BL
				synchronized (lock2) {
					System.out.println(Thread.currentThread().getName()+" is acquired lock2 ");
				}
			}
		};		
		
		Runnable r2 = ()->{
			System.out.println(Thread.currentThread().getName()+" is trying for lock2");
			synchronized (lock1) {
				System.out.println(Thread.currentThread().getName()+" is acquired lock2 and trying for lock 1");
				for(long i = 1;i<=9999999L;i++);//BL
				synchronized (lock2) {
					System.out.println(Thread.currentThread().getName()+" is acquired lock1 ");
				}
			}
		};
		
		new Thread(r1,"T1").start();;
		new Thread(r2,"T2").start();
		
		
	}
}
