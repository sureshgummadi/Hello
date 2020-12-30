package com.app.model;
class MyThread extends Thread{
	MyThread(){
		
	}
	public MyThread(MyRunnable myRunnable) {
		super(myRunnable);
	}
	public void run() {
		System.out.println("MyThread");
	}
}
class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("Runabale");
	}
	
}
public class TestA {

	public static void main(String[] args) {
	new MyThread().start();
	new MyThread(new MyRunnable()).start();

	}

}
