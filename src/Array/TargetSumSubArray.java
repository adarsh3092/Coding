package Array;

public class TargetSumSubArray {

	public static void main(String[] args) {
		int arr[]= {9,4,5,7,3,2};
		int sum=9;
		int tmp=arr[0];
		int j=0;
		int end=0;
		for(int i=1;i<=arr.length;i++) {
			
			while(tmp>sum&&j<i-1) {
				tmp-=arr[j++];
			}if(sum==tmp) {
				end=i-1;
				break;
			}
			if(i<arr.length)
			tmp+=arr[i];
		}
		
		for(int i=j;i<=end;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
