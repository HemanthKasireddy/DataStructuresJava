package com.bridgeit.datastrucers.Programs;

import java.util.ArrayList;
import com.bridgeit.datastrucers.Utility.Utility;

public class Prime2DGreedyArray {
	public static void main(String []args){
		ArrayList<Integer> arrayList=Utility.primeNumbers(0,1000);
		Utility.printArray(arrayList);
	}
}
