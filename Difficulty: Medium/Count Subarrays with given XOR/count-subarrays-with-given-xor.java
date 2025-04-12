//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        long count = 0;
        int xor = 0;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);
        
        for(int i=0; i<arr.length; i++) {
            xor = xor ^ arr[i];
            int rem = xor ^ k;
            if(mpp.containsKey(rem)) {
                count += mpp.get(rem);
            }
            if(mpp.containsKey(xor)) {
                mpp.put(xor, mpp.get(xor) + 1);
            } else {
                mpp.put(xor, 1);
            }
            
        }
        
        return count;
    }
}