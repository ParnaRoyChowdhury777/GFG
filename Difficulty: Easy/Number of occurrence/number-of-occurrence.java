//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    int lower_bound(int arr[], int x) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    int upper_bound(int arr[], int x) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    int countFreq(int[] arr, int target) {
        // code here
        int first = lower_bound(arr, target);
        if(first == arr.length || arr[first] != target) {
            return 0;
        } 
        int last = upper_bound(arr, target) - 1;
        return (last - first + 1);
    }
}
