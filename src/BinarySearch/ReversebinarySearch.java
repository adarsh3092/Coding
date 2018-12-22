package BinarySearch;

import java.util.Scanner;

public class ReversebinarySearch {
	static int findElement(int arr[],int l,int h,int key) {
		if(l<=h) {
			int mid=l+(h-l)/2;
			if(arr[mid]==key)
				return mid;
			else if(arr[mid]<key)
				return findElement(arr, l, mid-1, key);
				else 
					return findElement(arr, mid+1,h, key);
			}
		
		return -1;
		
	}
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		System.out.println(findElement(arr, 0,arr.length-1 , k));
			
	}

}
