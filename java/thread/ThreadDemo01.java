//package org.thread.demo;  
public class ThreadDemo01 {  
	public static void main(String[] args) {  
	MyThread mt1=new MyThread("线程a");  
	MyThread mt2=new MyThread("线程b");  
	mt1.start(); //run();  
	mt2.start(); //run();  
	}  
} 