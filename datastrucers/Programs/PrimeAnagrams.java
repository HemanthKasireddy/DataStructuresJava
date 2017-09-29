package com.bridgeit.datastrucers.Programs;


import com.bridgeit.datastrucers.Utility.Utility;


public class PrimeAnagrams {
	public static void main(String[] args){
		int [][]primes = Utility.primeNumbersArray(0,1000);
		int [][]primeAnagrams = Utility.anagramChecking(primes);
		int [][]primeNonAnagrams = Utility.nonAnagram(primes,primeAnagrams);
		Utility.printPrimeAnagram(primeAnagrams);
		Utility.printPrimeNonAnagram(primeNonAnagrams);
	}
}
