//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().majorityElement(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int majorityElement(int arr[]) {
        // code here
        int cnt = 0, el = -1;
        int n = arr.length;
        
        for(int i=0; i<n; i++) {
            if(cnt == 0) {
                cnt = 1;
                el = arr[i];
            } else if(arr[i] == el) {
                cnt++;
            } else {
                cnt--;
            }
        }
        
        int cnt1 = 0;
        
        for(int i=0; i<n; i++) {
            if(arr[i] == el) {
                cnt1++;
            }
        }
        
        if(cnt1 > (n/2))
            return el;
        return -1;
        
    }
}