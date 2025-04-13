//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str =
                (br.readLine()).trim().split(" "); // Reading input as a string array
            int arr[] = new int[str.length]; // Creating integer array from the input
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            // Getting the result from the Solution class
            List<Integer> result = new Solution().findDuplicates(arr);
            Collections.sort(result);
            // Printing the result in the required format
            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (int i = 0; i < result.size(); i++) {
                    if (i != 0) System.out.print(" ");
                    System.out.print(result.get(i));
                }
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        // code here
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> mpp = new HashMap<>();
         
        for(int i=0; i<arr.length; i++) {
            if(mpp.containsKey(arr[i])) {
                mpp.put(arr[i], mpp.get(arr[i]) + 1);
            } else {
                mpp.put(arr[i], 1);
            }
        }
        
        for(Map.Entry<Integer, Integer> entry: mpp.entrySet()) {
            if(entry.getValue() > 1) {
                ans.add(entry.getKey());
            }
        }
        
        return ans;
    }
}
