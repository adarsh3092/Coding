package com.apache.spark.learning.saprk_learning;

public class KmpAlgorithm {

	public static void main(String[] args) {
		String str="abcabcabcabcabcabc";
		int n=str.length();
		int lps[]=new int[n];
		int i=1;
		int j=0;
		lps[0]=0;
		while(i<n){
			if(str.charAt(i)==str.charAt(j)) {
				j++;
				lps[i]=j;
			}else {
				if(j!=0){
					j=lps[j-1];
				}else{
					lps[i]=j;
					i++;
				}
			}
		}	
		for(int k=0;k<n;k++)
		System.out.print(lps[k]+" ");

	}

}
