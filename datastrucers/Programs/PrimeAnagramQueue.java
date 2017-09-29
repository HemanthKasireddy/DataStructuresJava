package com.bridgeit.datastrucers.Programs;


import com.bridgeit.datastrucers.Utility.Utility;
public class PrimeAnagramQueue {
	public static void main(String[] args){
		int [][]primes=Utility.primeNumbersArray(0, 1000);
		int [][]primeAnagrams = Utility.anagramChecking(primes);
		Utility.generateAnagramQueue(primeAnagrams);
	}
}
