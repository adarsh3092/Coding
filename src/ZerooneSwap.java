/*swap 0,1 or 2 one side of array all 0,1 and 2 comes to
 * input:: array[0,1,2,0,1,1,2]
 * output::array[0,0,1,1,2,2]
 * Time complexity of thsi program should be O(N) and no of iteration should only one.
 * 
 * */
public class ZerooneSwap {

	public static void main(String[] args) {
		int arr[]= {2,0,2,1,0,2,1,1,0};
		int l=0;
		int r=arr.length-1;
		int mid=0;
		while(mid<=r) {
			switch(arr[mid]) {
			case 0:
				swap(arr,l,mid);
				l++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(arr,mid,r);
				r--;
				break;
			}
		}
			
		
	
	for(int i:arr) {
		System.out.print(i+" ");
	}
	}
	static void swap(int arr[],int i,int j) {
		int t=arr[i];
		arr[i]=arr[j];
		arr[j]=t;
	}
		
}

//2,0,2,1,0,2,1,1,0
//0,0,2,1,0,2,1,1,2
//---0,0,2,1,0,1,1,2,2-->00012112
//0 1 1 0 0 1 2 2 2 
