//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            Solution ob = new Solution();
            int ans = ob.sumOfDivisors(N);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    static int sum(int num) {
        int s = 0;
        for(int i=1; i<=num; i++) {
            if(num % i == 0) {
                s = s + i;
            }
        }
        return s;
    }
    public static int sumOfDivisors(int n) {
        // code here
        int res = 0;
        for(int i=1; i<=n; i++) {
            res = res + sum(i);
        }
        return res;
    }
}