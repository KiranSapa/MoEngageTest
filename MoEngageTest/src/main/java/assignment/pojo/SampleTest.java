package assignment.pojo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SampleTest {
	
	
	 public static long subarraySum(List<Integer> arr) {
		 long result = 0; 
	       int n=arr.size();
	        // Pick starting point 
	        for (int i = 0; i < n; i ++) 
	        { 
	            // Pick ending point 
	            for (int j = i; j < n; j ++) 
	            { 
	                // sum subarray between current 
	                // starting and ending points 
	                for (int k = i; k <= j; k++) 
	                    result += arr.get(k) ; 
	            } 
	        } 
	        return result ; 
		    }
	 
	 public static void printSubArrays(int[] arr){
		 int len=arr.length;
		 for (int i=0;i<len;i++){
			 for(int j=i;j<len;j++){
				
					 System.out.print(arr[j]+" "); 
					
			           
	           
				 
			 }
			 System.out.println("\n"); 
			
		 }
		
	 }
	 

	 static int countDuplicates(int[] array) {

		 Set<Integer> set = new HashSet<Integer>();
         int count=0;
         for(int i = 0; i < array.length ; i++)
	        {
	            //If same integer is already present then add method will return FALSE
	            if(set.add(array[i]) == false)
	            {
	               	                count++;
	            }
	        }
	   return count;
	    }

	 
	 

	public static void main(String[] args) {
//		long res=SampleTest.subarraySum(Arrays.asList(1,2,3,4));
//		System.out.println(res);
		int[] array = {1,2,3};
	SampleTest.printSubArrays(array);
//		int res1=SampleTest.countDuplicates(array);
//		System.out.println(res1);
		
	}

}
