package Array;

public class FindSmallestNumber {
	static int searchNumber(int arr[],int m) {
		int l=0;
		int r=arr.length-1;
		int mid=-1;
		while(l<=r) {
			 mid=l+(r-l)/2;
			if(mid==arr[mid])
				l=mid+1;
			else 
				r=mid-1;
				
		}
		return mid==arr.length-1?mid+1:mid;
	}
	public static void main(String[] args) {
		int arr[]= {0,1,3,4,5,6,7,8};
		System.out.println(searchNumber(arr, 9));
	}

}
