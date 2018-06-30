package BinarySearch;

public class MaxNumbeInRotatedArray {
	static int getMax(int arr[],int l,int r) {
	while(l<r) {
		int mid=l+r/2;
		System.out.println("mid::"+mid);
		if(mid<r&&arr[mid+1]<arr[mid]) {
			return mid;
		}else if(mid>0&&arr[mid-1]>arr[mid]) {
			return mid-1;
		}else if(arr[r]<arr[mid]){
			l=mid+1;
		}else {
			r=mid;
		}
		
	}
		return arr[r];
	}
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5,6,7};
		System.out.println(getMax(arr,0,arr.length-1));
	}

}
