import java.util.Arrays;

public class BeforeEvenGreater {
	/*	
	 *Time Complexity ::O(nlogn) if we best sorting technique
	 */	
	public static void main(String[] args) {
		int arr[]= {1};
		int tmp[]= new int[arr.length];
		int n=arr.length;
		int odd_pos=n-n/2-1;
		Arrays.sort(arr);
		for(int i=0,j=odd_pos;i<arr.length&&j>=0;i=i+2,j--) {
			tmp[i]=arr[j];
			//System.out.println(i);
		}
		for(int i=1,j=odd_pos+1;i<n&&j<n;i=i+2,j++) {
			tmp[i]=arr[j];
		}
		for(int i=0;i<n;i++)
			System.out.print(tmp[i]+" ");
		
	}

}
