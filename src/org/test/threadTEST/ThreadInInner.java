package org.test.threadTEST;

//52.	设计4 个线程，其中两个线程每次对j 增加1，另两个线程对j 每次减少1；写出程序。【中等难度】
//答：以下程序使用内部类实现线程，对j 增减的时候没有考虑顺序问题：
public class ThreadInInner {
	private int j;

	public ThreadInInner(int j) {
		this.j = j;
	}

	private synchronized void inc() {
		j++;
		System.out.println(j + "--Inc--" + Thread.currentThread().getName());
	}

	private synchronized void dec() {
		j--;
		System.out.println(j + "--Dec--" + Thread.currentThread().getName());
	}

	public void run() {
		(new Dec()).start();
		new Thread(new Inc()).start();
		(new Dec()).start();
		new Thread(new Inc()).start();
	}

	class Dec extends Thread {
		public void run() {
			for (int i = 0; i < 100; i++) {
				dec();
			}
		}
	}

	class Inc implements Runnable {
		public void run() {
			for (int i = 0; i < 100; i++) {
				inc();
			}
		}
	}

	public static void main(String[] args) {
		(new ThreadInInner(5)).run();
	}
}
