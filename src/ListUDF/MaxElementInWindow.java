package ListUDF;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaxElementInWindow {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int t=sc.nextInt();
		int rst[]=new int[t];
		while(--t>=0) {
			int max=Integer.MIN_VALUE;
			int index=0;
			 
			int n=sc.nextInt();
			int d=sc.nextInt();
			int arr[]=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();	}
			Deque<Integer> list=new LinkedList<Integer>();
			int m=0;
			for( m=0;m<d;m++) {
				while((!list.isEmpty())&&arr[m]>arr[list.peekLast()]) {
					list.removeLast();}
				list.addLast(m);
			for(;m<n;m++) {
				while((!list.isEmpty())&&list.peekFirst()<=m-d)
					list.peekFirst();
				while((!list.isEmpty())&&arr[list.peekLast()]<arr[m]) {
					list.removeLast();	}
				list.addLast(m);
				System.out.print(arr[list.peek()]+" ");

				}
			}
			
		}
	}

}
