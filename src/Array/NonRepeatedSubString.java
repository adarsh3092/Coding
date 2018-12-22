package Array;

import java.util.Arrays;
/*
 * find non repeated charater largest  largest substring
 * 
 * */
public class NonRepeatedSubString {

	public static void main(String[] args) {
		String str="abcbacefghi";
		int index[]=new int[256];
		int curr=0;
		int max_val=Integer.MIN_VALUE;
		Arrays.fill(index, -1);
		for(int i=0;i<str.length();i++) {
			int pre=index[str.charAt(i)];
			if(pre==-1||i-curr<pre) {
				curr++;
			}else {
				if(curr<max_val)
					max_val=i-curr;
			}
			index[str.charAt(i)]=i;
		}
	}

}
