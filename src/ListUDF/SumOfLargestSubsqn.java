package ListUDF;

import java.util.Arrays;

public class SumOfLargestSubsqn {

	public static void main(String[] args) {
		int arr[]= {1,2,101,3,100,4,5};
		int tmp[]=new int[arr.length];
		int sum[]=new int[arr.length];
		for(int i=0;i<arr.length;i++)
		sum[i]=0;
		sum[0]=arr[0];
		Arrays.fill(tmp, Integer.MIN_VALUE);
		tmp[0]=1;
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<=i;j++) {
				if(tmp[j]!=Integer.MIN_VALUE&&arr[j]<arr[i]) {
					tmp[i]=Math.max(tmp[j]+1,tmp[i]);
					sum[i]=Math.max(arr[i],sum[i]+sum[j]);
				}
			}
		}
		for(int i=0;i<arr.length;i++)
		System.out.print(sum[i]+" ");
	}

}
