package com.creationalDesignPatterns;

public class SingletonMultiThreadingExample {
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		Thread3 t3 = new Thread3();
		t1.start();
		t2.start();
		t3.start();
	}
	
	
}

class SingletonExample {
	private static volatile SingletonExample instance = null;
	private SingletonExample() {}
	public static SingletonExample getInstance() {
		if(instance == null) {
			System.out.println("1 "+Thread.currentThread().getName());
			synchronized (SingletonExample.class) {
				System.out.println("2 "+Thread.currentThread().getName());
				if(instance == null) {
					instance = new SingletonExample();
				}
			}
		}
		return instance;
	}
}

class Thread1 extends Thread {
	@Override
	public void run() {
		SingletonExample.getInstance();
	}
}

class Thread2 extends Thread {
	@Override
	public void run() {
		SingletonExample.getInstance();
	}
}

class Thread3 extends Thread {
	@Override
	public void run() {
		SingletonExample.getInstance();
	}
}
