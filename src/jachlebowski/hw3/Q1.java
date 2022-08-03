package jachlebowski.hw3;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StopwatchCPU;
import algs.days.day16.ComparableTimSort;
import algs.hw3.CountedItem;
import algs.hw3.PrimitiveTimSort;

/**
 * 
 * Use the existing SortTrial class, and write your own for your implementation
 * of TimSort and also the HeapSort 
 * 
 * https://shakespeare.folger.edu/shakespeares-works/hamlet/download/
 * 
 * What is the longest word which is not a modern English word, according to
 * our dictionary?
 */
public class Q1 {
	
	/** Return time to sort array using merge sort. */
	public static double mergeSort(Comparable<?>[] A) {
		StopwatchCPU start = new StopwatchCPU();
		edu.princeton.cs.algs4.Merge.sort(A);
		return start.elapsedTime();
	}
	
	/** Return time to sort array using quick sort. */
	public static double quickSort(Comparable<?>[] A) {
		StopwatchCPU start = new StopwatchCPU();
		edu.princeton.cs.algs4.Quick.sort(A);
		return start.elapsedTime();
	}
	
	/** Return time to sort array using Insertion Sort. */
	public static double insertionSort(Comparable<?>[] A) {
		StopwatchCPU start = new StopwatchCPU();
		edu.princeton.cs.algs4.Insertion.sort(A);
		return start.elapsedTime();
	}
	
	/** Return time to sort array using Selection Sort. */
	public static double selectionSort(Comparable<?>[] A) {
		StopwatchCPU start = new StopwatchCPU();
		edu.princeton.cs.algs4.Selection.sort(A);
		return start.elapsedTime();
	}
	
	/** Return time to sort array using Heap Sort. */
	public static double heapSort(Comparable<?>[] A) {
		StopwatchCPU start = new StopwatchCPU();
		edu.princeton.cs.algs4.Heap.sort(A);
		return start.elapsedTime();
	}
	
	/** Return time to sort array using Primitive Tim Sort. */
	public static double primitiveTimSort(Comparable<?>[] A) {
		StopwatchCPU start = new StopwatchCPU();
		PrimitiveTimSort.sort(A);
		return start.elapsedTime();
	}
	
	/** Return time to sort array using Optimized Tim Sort. */
	public static double builtinSort(Comparable<?>[] A) {
		StopwatchCPU start = new StopwatchCPU();
		ComparableTimSort.sort(A);
		return start.elapsedTime();
	}
	
	
	
	
	
	
	
	
	
	/** Determine if the array is sorted. */
	public static boolean isSorted(Comparable[] A) {
		boolean sorted = false;
		for(int i=0;i<A.length-1;i++){
			int first = (int) A[i];
			int second = (int) A[i+1];
			
			if(!(first<second)) { //if first is NOT less than second
				return false;
			}
			else {sorted=true;}
		}
		return sorted;
	}

	
	
	
	/** 
	 * Given a sorted array of CountedItem<String> objects, ensure that for 
	 * any two index positions, i and j, if A[i] is equal to A[j] and i < j, 
	 * then A[i].earlier(A[j]) is true.
	 * 
	 * Performance must be O(N).
	 */
	public static boolean isSortedArrayStable(CountedItem[] A) {
		boolean isStable = false;
		for(int i=0;i<A.length-1;i++) {
			CountedItem one = A[i];
			CountedItem two = A[i+1];
			
			if((one.equals(two))&&(two.earlier(one))){
					return false;
					}
			else {isStable=true;}
			}	
		return isStable;
		}
	
	
	
	
	
	
	/** 
	 * Given an array of integers, return a CountedItem<Integer> array. If you construct
	 * and add the objects from left to right, then for two duplicate values A[i] and A[j],
	 * you know that the counter for A[i] is smaller than the counter for A[j] if i < j. 
	 */
	static CountedItem<Integer>[] toCountedArray(Integer vals[]) {
		CountedItem<Integer>[] copy = new CountedItem[vals.length];
		for (int i  = 0; i < copy.length; i++) {
			copy[i] = new CountedItem<>(vals[i]);
		}
		
		return copy;
	}
	
	
	
	
	
	
	//only using CountedItem<Integer> class on 1.1
	
	public static void trial1_1() {
		System.out.println("Q1.1");
		
		// create array of integers with opportunities for duplicates
		Integer vals[] = new Integer[4096];
		for (int i = 0; i < vals.length; i++) { vals[i] = StdRandom.uniform(128); }
		
		
	
		// using this SAME ARRAY, create different CountedItem<> arrays and 
		// determine which of the sorting algorithms are stable, and which ones are not.
		CountedItem<Integer>[] HeapSort = toCountedArray(vals);
		CountedItem<Integer>[] InsertionSort = toCountedArray(vals);
		CountedItem<Integer>[] MergeSort = toCountedArray(vals);
		CountedItem<Integer>[] QuickSort = toCountedArray(vals);
		CountedItem<Integer>[] SelectionSort = toCountedArray(vals);
		CountedItem<Integer>[] TimSort_Primitive = toCountedArray(vals);
		CountedItem<Integer>[] TimSort_Optimized = toCountedArray(vals);
		
		//Using SAME ARRAY, create six different CountedItem>Integer>[] arrays USING
		//toCountedArray() method and evaluate the RESULT using isSortedArrayStable()
		
		heapSort(HeapSort);
		insertionSort(InsertionSort);
		mergeSort(MergeSort);
		quickSort(QuickSort);
		selectionSort(SelectionSort);
		primitiveTimSort(TimSort_Primitive);
		builtinSort(TimSort_Optimized);
		
		boolean heapStable = isSortedArrayStable(HeapSort);
		boolean insertionStable = isSortedArrayStable(InsertionSort);
		boolean mergeStable = isSortedArrayStable(MergeSort);
		boolean quickStable = isSortedArrayStable(QuickSort);
		boolean selectionStable = isSortedArrayStable(SelectionSort);
		boolean primitiveStable = isSortedArrayStable(TimSort_Primitive);
		boolean optimizedStable = isSortedArrayStable(TimSort_Optimized);
		
		
		System.out.println("Algorithm" + "\t\tStable Sort");
		System.out.println("HeapSort:" + "\t\t"+ heapStable);
		System.out.println("InsertionSort:" + "\t\t"+ insertionStable);
		System.out.println("MergeSort:" + "\t\t"+ mergeStable);
		System.out.println("QuickSort:" + "\t\t"+ quickStable);
		System.out.println("SelectionSort:" + "\t\t"+ selectionStable);
		System.out.println("TimSort Primitive:" + "\t"+ primitiveStable);
		System.out.println("TimSort Optimized:" + "\t"+ optimizedStable);
	}
	
	
	
	
	
	
	public static void trial1_2() {
		System.out.println("\n\nQ1.2");
		// completed by student
		System.out.print("N" + "\t\tTimSort"+"\tMerge"+"\tPrimTS"+"\tQuick"+"\tHeap");
	
		
		//create array of integers
		for (int i = 1048576; i <= 16777216; i=i*2) {
			Comparable tim[] = new Comparable[i];
			Comparable prim[] =  new Comparable[i];
			Comparable merge[] = new Comparable[i];
			Comparable quick[]= new Comparable[i];
			Comparable heap[] = new Comparable[i];
			for(int k=0;k<i;k++) {
			tim[k] = StdRandom.uniform(i);
			prim[k] = StdRandom.uniform(i);
			merge[k] = StdRandom.uniform(i);
			quick[k] = StdRandom.uniform(i);
			heap[k] = StdRandom.uniform(i);
		}
			if(i!=16777216) {
			System.out.format("\n%d"+"\t\t"+"%.3f"+"\t",i,builtinSort(tim));
			System.out.format("%.3f"+"\t" ,primitiveTimSort(prim)); 
			System.out.format("%.3f"+"\t",mergeSort(merge));
			System.out.format("%.3f"+"\t",quickSort(quick));
			System.out.format("%.3f"+"\t",heapSort(heap));
			}
			else {
				System.out.format("\n%d"+"\t"+"%.3f"+"\t",i,builtinSort(tim));
				System.out.format("%.3f"+"\t" ,primitiveTimSort(prim)); 
				System.out.format("%.3f"+"\t",mergeSort(merge));
				System.out.format("%.3f"+"\t",quickSort(quick));
				System.out.format("%.3f"+"\t",heapSort(heap));
			}
		}
	}
	
	
	
	
	
	
	
	
	public static void trial1_3() {
		System.out.println("\n\nQ1.3");
	
		System.out.print("N" + "\t\tTimSort"+"\tMerge"+"\tPrimTS"+"\tQuick"+"\tHeap");
	
		
		//create array of integers
		for (int i = 1048576; i <= 16777216; i=i*2) {
			Integer tim[] = new Integer[i];
			Integer prim[] =  new Integer[i];
			Integer merge[] = new Integer[i];
			Integer quick[]= new Integer[i];
			Integer heap[] = new Integer[i];
			for(int k=0;k<i;k++) {
			tim[k] = StdRandom.uniform(i/512);
			prim[k] = StdRandom.uniform(i/512);
			merge[k] = StdRandom.uniform(i/512);
			quick[k] = StdRandom.uniform(i/512);
			heap[k] = StdRandom.uniform(i/512);
		}
			if(i!=16777216) {
			System.out.format("\n%d"+"\t\t"+"%.3f"+"\t",i,builtinSort(tim));
			System.out.format("%.3f"+"\t" ,primitiveTimSort(prim)); 
			System.out.format("%.3f"+"\t",mergeSort(merge));
			System.out.format("%.3f"+"\t",quickSort(quick));
			System.out.format("%.3f"+"\t",heapSort(heap));
			}
			else {
				System.out.format("\n%d"+"\t"+"%.3f"+"\t",i,builtinSort(tim));
				System.out.format("%.3f"+"\t" ,primitiveTimSort(prim)); 
				System.out.format("%.3f"+"\t",mergeSort(merge));
				System.out.format("%.3f"+"\t",quickSort(quick));
				System.out.format("%.3f"+"\t",heapSort(heap));
			}
		}	
	}
	
	
	
	
	
	
	
	public static void trial1_4() {
		System.out.println("\n\nQ1.4");
		System.out.print("N" + "\t\tTimSort"+"\tMerge"+"\tPrimTS"+"\tQuick"+"\tHeap");
	
		
		//create array of integers
		for (int i = 1048576; i <= 16777216; i=i*2) {
			Integer tim[] = new Integer[i];
			Integer prim[] =  new Integer[i];
			Integer merge[] = new Integer[i];
			Integer quick[]= new Integer[i];
			Integer heap[] = new Integer[i];
			for(int k=i-1;k>=0;k--) {
			tim[k] = i;
			prim[k] =i;
			merge[k] = i;
			quick[k] = i;
			heap[k] = i;
		}
			if(i!=16777216) {
			System.out.format("\n%d"+"\t\t"+"%.3f"+"\t",i,builtinSort(tim));
			System.out.format("%.3f"+"\t" ,primitiveTimSort(prim)); 
			System.out.format("%.3f"+"\t",mergeSort(merge));
			System.out.format("%.3f"+"\t",quickSort(quick));
			System.out.format("%.3f"+"\t",heapSort(heap));
			}
			else {
				System.out.format("\n%d"+"\t"+"%.3f"+"\t",i,builtinSort(tim));
				System.out.format("%.3f"+"\t" ,primitiveTimSort(prim)); 
				System.out.format("%.3f"+"\t",mergeSort(merge));
				System.out.format("%.3f"+"\t",quickSort(quick));
				System.out.format("%.3f"+"\t",heapSort(heap));
			}
		}	
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		trial1_1();
		trial1_2();
		trial1_3();
		trial1_4();
	}
}
