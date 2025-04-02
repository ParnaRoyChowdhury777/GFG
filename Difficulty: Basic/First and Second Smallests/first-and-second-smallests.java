//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[(int)(n)];
            for (int i = 0; i < n; i++) {
                arr[i] = (int)(Long.parseLong(inputLine[i]));
            }

            Solution obj = new Solution();
            int[] product = obj.minAnd2ndMin(arr);
            if (product[0] == -1)
                System.out.println(product[0]);
            else
                System.out.println(product[0] + " " + product[1]);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] minAnd2ndMin(int arr[]) {
        // code here
        int smallest = arr[0];
        int ssmallest = Integer.MAX_VALUE;
        int result[] = new int[2];
        
        for(int i=1; i<arr.length; i++) {
            if(arr[i] < smallest) {
                ssmallest = smallest;
                smallest = arr[i];
            }
            else if(arr[i] != smallest && arr[i] < ssmallest) {
                ssmallest = arr[i];
            }
        }
        
        if(ssmallest == Integer.MAX_VALUE) {
            smallest = -1;
            ssmallest = -1;
        }
        
        result[0] = smallest;
        result[1] = ssmallest;
        
        return result;
    }
}
