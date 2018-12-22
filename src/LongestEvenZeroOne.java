import java.util.HashMap;

public class LongestEvenZeroOne {
	static void getLengthOfSubArray(int arr[]) {
		int n=arr.length;
		int sum=0;
		for(int i=0;i<n;i++)
			arr[i]=arr[i]==0?-1:0;
		int end_index=0;
		int max_length=Integer.MIN_VALUE;
		HashMap<Integer,Integer>hm=new HashMap<Integer,Integer>();
		for(int i=0;i<n;i++) {
			sum+=arr[i];
			if(hm.containsKey(n+sum)) {
				end_index=i;
				max_length=i-hm.get(n+sum);
			}
			
		}
	}
	public static void main(String[] args) {
		
	}

}
