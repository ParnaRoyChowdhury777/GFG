//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    static int merge(int arr[], int low, int mid, int high) {
        int count = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        
        int i=low, j=mid+1;
        
        while(i <= mid && j <= high) {
            if(arr[i] <= arr[j]) {
                ans.add(arr[i++]);
            } else {
                ans.add(arr[j++]);
                count += mid - i + 1;
            }
            
        }
        
        while(i <= mid) {
            ans.add(arr[i++]);
        }
        
        while(j <= high) {
            ans.add(arr[j++]);
        }
        
        for(int x=low; x<=high; x++) {
            arr[x] = ans.get(x - low);
        }
        return count;
    }
    
    static int mergeSort(int arr[], int low, int high) {
        int count = 0;
        if(low >= high) {
            return count;
        }
        int mid = (low + high) / 2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);
        return count;
    }
    
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Your Code Here
        int n = arr.length;
        return mergeSort(arr, 0, n-1);
    }
}