

import java.security.SecureRandom;


/*
=============================================================================================================================

	Data Structures 			
	Submission: Aaron Dykes
	
=============================================================================================================================
*/
/**

	BinarySearch class ->
	sorts and searches a given array
	for user inputed key value.

	@author aarondykes
	
*/
public class BinarySearch {

	
/* 	Both build and space variables 
	declared as fields.
	-> Formats final output.
*/	private StringBuilder build;
	private String space;
	
	
/**
 	Empty constructor used 
 	to initialize space variable.
*/ 	public BinarySearch() {
		space = "";
	}


/*
=============================================================================================================================
=============================================================================================================================
*/

/**
    nonRecursiveBinarySearch() takes 
    an array of sorted integers ( data ), 
    caculates the middle index ( mid ), 
    and divides array in half until 
    while loop condition is met
    ( fromIndex == toIndex ) || ( fromIndex > toIndex ).
    
	@param data = integer array
	@param key = search key
	@return int
*/
	
	public int nonRecursiveBinarySearch( int[] data, 
					     int key ) { 
		long start = System.nanoTime();
		int mid = 0,
		    fromIndex = 0,
		    toIndex = data.length - 1;
/*						While fromIndex <= toIndex, 
						each iteration will either decrement
						toIndex or increment fromIndex
						until they are equal... or not.
		
						If toIndex is < fromIndex, 
						key wasn't found, return -1.
						Else, return mid value ( key found );
		
*/		while( fromIndex <= toIndex ) {
/*								Each iteration will divide 
	 							search results by two and print 
	 							remaining elements.
*/			mid = ( fromIndex + toIndex + 1 ) / 2;
			remainingElements( data, 	
					   fromIndex, 
					   toIndex );
/* 							If key value is < data index 
							of ( middle ), to = middle - 1.
*/			if ( key < data[mid] ) 
				toIndex = mid - 1;
/* 							If key value is > data index
							of ( middle ), from = middle + 1.
*/			else if ( key > data[mid] ) 
				fromIndex = mid + 1;
/*							If the else condition 
							is met on last iteration,
							key was found. 
							End timer, return index.
 */			else {
				long end = System.nanoTime(),
					   nanoTime = (end - start),
					   time = (end - start) / 1000000;
				System.out.printf( "%n%s%s%s%n%s%n%s",
						   "Number " + key,
						   " found at index " + mid,
						   " on the screen",
						   "Milliseconds: " + time,
						   "Nanoseconds: " + nanoTime );
				space = "";
				return mid;
			}
		} 
/*						Else, key was not found.
						End timer, return index.
*/		long end = System.nanoTime(),
			   nanoTime = (end - start),
			   time = (end - start) / 1000000;
		System.out.printf( "%n%s%n%s%n%s", 
				   "Milliseconds: " + time,
				   "Nanoseconds: " + nanoTime,
				   "The number " + key + " was not found." );
		space = "";
		return -1;
	}
	
	
/*
=============================================================================================================================
=============================================================================================================================
*/
	
/**

	recursiveBinarySearch() will recursively call itself 
	until the while loop condition is met 
	( fromIndex == toIndex ) || ( fromIndex > toIndex ).
	
	@param data = integer array
	@param fromIndex = 1st array index
	@param toIndex = last array index
	@param key = search key.
	@return int
*/
	public int recursiveBinarySearch(  int[] data, 
					   int fromIndex, 
					   int toIndex,
					   int key ) {
		long start = System.nanoTime();
/*						While fromIndex <= toIndex, 
						each iteration will either decrement
						toIndex or increment fromIndex 
						until they are equal... or not.
		
						If toIndex is < fromIndex 
						key wasn't found, return -1.
						Else, return mid value ( key found );
*/		while( fromIndex <= toIndex ) {
			
			int mid = ( fromIndex + toIndex + 1 ) / 2;
			remainingElements( data, 
	   		   		   fromIndex,
	   		   		   toIndex );
/*							If key value is < data[mid],
							to = middle - 1.
							return recursiveBinarySearch()
							method call with new to value.
*/			if( key < data[mid] ) 
				return recursiveBinarySearch( data, 
							      fromIndex, 
							      mid - 1, 
							      key );
/*									Else if key value is > data[mid],
									return recursiveBinarySearch()
									method call with new from value.
*/			else if( key > data[mid] ) 
				return recursiveBinarySearch( data, 
							      mid + 1, 
							      toIndex, 
							      key );
			else {
/*								If the else condition 
				 				is met on final iteration,
				 				key was found. 
				 				End timer, return index.
*/				long end = System.nanoTime(),
					   nanoTime = (end - start),
					   time = (end - start) / 1000000;
				System.out.printf( "%n%s%s%s%n%s%n%s",
						   "Number " + key,
						   " found at index " + mid,
						   " on the screen",
						   "Milliseconds: " + time,
						   "Nanoseconds: " + nanoTime );
				space = "";
				return mid;
			}
		}
/*						Else, key was not found.
						End timer, return -1.
*/
		long end = System.nanoTime(),
			   nanoTime = (end - start),
			   time = (end - start) / 1000000;
		System.out.printf( "%n%s%n%s%n%s", 
				   "Milliseconds: " + time,
				   "Nanoseconds: " + nanoTime,
				   "The number " + key + " was not found." );
		space = "";
		return -1;
	}
	
		
/*
=============================================================================================================================
=============================================================================================================================
*/
	
/**
		
	generateRandomIntegers() generates 
	and returns an array of random integers.
	
	@param data = integer array.
	@param fromIndex = first element of data.
	@param toIndex = last element of data.
	@return int[]
*/
	public int[] generateRandomIntegers( int[] data,
					     int fromIndex,
					     int toIndex ) {
		SecureRandom rand = new SecureRandom();
/*							Populating data 
							array with values.
 */		for ( int i = 0; i < data.length; i++ ) {
			data[i] = rand.nextInt( 99 - 11 ) + 11;
		}
/*					Calling mergeSort to 
					sort data array.
*/		mergeSort( data );
/*					Printing all elements.
*/		remainingElements( data,
				   fromIndex,
				   toIndex );
		return data;
	}
	
/**
 	remainingElements() formats and 
 	prints final output of array values.
	
	@param data = Array of integers.
	@param fromIndex = First index of data.
	@param toIndex = Last index of data.
*/
	private void remainingElements( int[] data, 
					int fromIndex, 
					int toIndex ) {
		build = new StringBuilder();
/*								Iterate through remai	
								array elements and append 
								( value + " " ) to stringBuilder.
*/		for( int i = fromIndex; i < toIndex + 1; i++ ) {
			build.append( data[i] + " " );
		}
/*								Iterate through the remaing
 								array elements and 
								create space value for pattern.
*/		for ( int i = fromIndex; i < toIndex; i++ ) {
			space+=" ";
		}
/*						First iteration of recursive 
						search yields an incorrect output.
					
						Setting space = "" anywhere other than
						end of the loop or final else condition, 
						resets space variable with each iteration.
					
						Fixed by trimming excessive space.
*/		if ( space.length() > 33 ) 
			 space = space.substring(19);
/*							Appending new line and 
							incremented space value.
*/		build.append( "\n" + space )
			 .setLength( build.length() - 4 );
		System.out.print( build );
	}
	
	
	
/*
=============================================================================================================================

	mergeSort()
	and merge()
	methods.

=============================================================================================================================
*/
	private static void mergeSort( int[] data ) {
		
		int inputLength = data.length;
		if ( inputLength < 2 ) return;
		int mid = inputLength / 2;
		
		int[] leftData = new int[ mid ];
		int[] rightData = new int[ inputLength - mid ];
/* 								Populating left 
								array with data.
*/		for( int i = 0; i < mid; i++ ) {
			leftData[i] = data[i];
		}
/* 							Populating right 
							array with data.
*/		for( int i = mid; i < inputLength; i++ ) {
			rightData[i - mid] = data[i];
		}
/*					Recursively calling mergeSort 
					for left and right data.
					Dividing left and right 
					arrays in half until only 
					individual elements remain.
*/		mergeSort( leftData );
		mergeSort( rightData );
/*					Merging both halfs of 
					data array into an
					individual sorted array.
*/		merge( data, 
		       leftData, 
		       rightData );
	}
	
	
	private static void merge( int[] data, 
				   int[] leftData, 
				   int[] rightData ) {
/*							Declaring variables for left
							and right half's of array.
							Also, 3 indexing variables for
							l (left), r (right), and d(data).
*/		int lSize = leftData.length,
		    rSize = rightData.length; 
		
		int l = 0,
		    r = 0,
		    d = 0;
/*						While left index < left size && 
						right index < right size,
						continue iterating.
*/		while( l < lSize && r < rSize ) {
/*							If left array[leftIndex] <= 
							right array[rightIndex];
						
							Place leftArray[leftIndex] 
							into data[dataIndex] and
							increment left array index.
*/			if( leftData[l] <= rightData[r] ) {
				data[d] = leftData[l];
				l++;
			}
/*							Else, place right array[leftIndex] 
							into data[dataIndex] and
							increment right array index.
*/			else {			
				data[d] = rightData[r];
				r++;
			}
/*				Each iteration, 
				increment data index.
 */			d++;
		}
/*				 	After initial while loop. 
				 	There may be remaining elements 
				 	from left or right array.
				 	
				 	While left index < left size
				 	add remaining elements to array and
				 	increment left and data index variables.
*/		while( l < lSize ) {
			data[d] = leftData[l];
			l++;
			d++;
		}
/*					While right index < right size
					add remaining elements to array and
					increment left and data index variables.
*/		while( r < rSize ) {
			data[d] = rightData[r];
			r++;
			d++;
		}
	}
}
/*
=============================================================================================================================

	Data Structures 
	Submission: Aaron Dykes
	
=============================================================================================================================
*/
