package BinarySearch;

public class BitonicArray {
	static int getBitonicIndex(int arr[],int l,int h) {
		
		if(l<=h) {
		int mid=l+h/2;
		if(arr[mid]>arr[mid-1]&&arr[mid]>arr[mid+1])
			return mid;
		else if(arr[mid+1]>arr[mid])
			return getBitonicIndex(arr,mid+1, h);
		else	
		return getBitonicIndex(arr, l, mid-1);
		 }
		return -1;
		
	}
	 static int  binarysearch(int arr[],int l,int h,int k) {
		 int mid=l+h/2;
		 if(l<=h) {
		 if(arr[mid]==k)
			 return mid;
		 else if(arr[mid]>k)
			return  binarysearch(arr, l, mid-1, k);
		 else
			return binarysearch(arr, mid+1, h, k);
		 }
		return -1;
	}
	 static int reverseBinarySerach(int arr[],int l,int h,int k) {
		 int mid=l+(h-l)/ 2;
		 if(l<=h) {
			 if(arr[mid]==k)
				 return mid;
			 else if(arr[mid]<k)
				 return reverseBinarySerach(arr,l,mid-1 ,k);
			 else 
				 return reverseBinarySerach(arr, mid+1, h, k);
		 }
		 return -1;
	 }
	public static void main(String[] args) {
		int arr[]= {12,13,14,16,17,8,6,4,2};
		int key=2;
		int ar1=-1;
		int ar2=-1;
		int pivot=getBitonicIndex(arr,0,arr.length-1);
		System.out.println(pivot);
		if(pivot==-1)
			System.out.println("Opps Not Found!!");
		else {
			ar1=binarysearch(arr, 0, pivot,key);
			System.out.println(ar1);
			ar2=reverseBinarySerach(arr, pivot+1, arr.length-1, key);
				}
			if(ar1!=-1)
			System.out.println("Key found at ::"+arr[ar1]);
			else if(ar1!=-1)
				System.out.println("Key found at::"+arr[ar2]);
			else 
				System.out.println("Not found element");
		}

}
