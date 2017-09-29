package com.bridgeit.datastrucers.Programs;

import com.bridgeit.datastrucers.Utility.Utility;

public class PrimeAnagramStack {
	public static void main(String[] args){
//AnagramStack anagramStack=new AnagramStack();
		int[][] primeArray=Utility.primeNumbersArray(0, 1000);
		int [][]primeAnagrams = Utility.anagramChecking(primeArray);

		Utility.generateAnagramStack(primeAnagrams);
	}
}
