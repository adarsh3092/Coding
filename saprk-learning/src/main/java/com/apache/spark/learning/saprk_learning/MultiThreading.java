package com.apache.spark.learning.saprk_learning;

import java.util.LinkedList;
import java.util.Queue;


class MyThreaed extends Thread{
	Queue<Integer>list;
	MyThreaed(Queue<Integer>list){
		this.list=list;
	}
	public void run() {
	System.out.println(list.remove());
  }
}
public class MultiThreading {

	public static void main(String[] args)  {
		Queue q=new LinkedList();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.add(6);
		q.add(7);

		MyThreaed th1=new MyThreaed(q);
		MyThreaed th2=new MyThreaed(q);
		MyThreaed th3=new MyThreaed(q);
		while(!q.isEmpty()) {
		
		try {
			th1.start();
			//th1.join();
			th2.start();
			//th2.join();
			th3.start();
			//th3.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	}

}
