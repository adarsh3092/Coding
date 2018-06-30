
public class ZerooneSwap {

	public static void main(String[] args) {
		int arr[]= {2,0,2,1,0,2,1,1,0};
		int l=0;
		int r=arr.length-1;
		int k=r;
		while(l<r&&k>=0) {
			if(arr[l]!=0&&arr[k]==0)
			{
				int t=arr[k];
				arr[k]=arr[l];				
				arr[l]=t;
				l++;
			}
			if(arr[l]==0)
				l++;
			
			 if(arr[r]!=2&&arr[k]==2) {
				 int t=arr[k];
					arr[k]=arr[r];
					arr[r]=t;
					r--;
					
			 }
			 if(arr[r]==2)
				 r--;
			 k--;
			 	}
		for(int i:arr)
		System.out.print(i+" ");
	}
	static void swap(int m,int n) {
		
	}
		
}
//2,0,2,1,0,2,1,1,0
//0,0,2,1,0,2,1,1,2
//---0,0,2,1,0,1,1,2,2-->00012112
//0 1 1 0 0 1 2 2 2 
