
//Back-end complete function Template for Java

class Solution {
    public static int fun(int[] arr, int pages) {
        int stu = 1, pagesCount = 0;
        for(int i=0; i<arr.length; i++) {
            if(pagesCount + arr[i] > pages) {
                stu++;
                pagesCount = arr[i];
            } else {
                pagesCount += arr[i];
            }
        }
        return stu;
    }
    public static int findPages(int[] arr, int k) {
        // code here
        int n = arr.length;
        if(k > n) return -1;
        int low = Integer.MIN_VALUE, high = 0;
        for(int i=0; i<n; i++) {
            if(arr[i] > low) {
                low = arr[i];
            }
            high += arr[i];
        }
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int stuCnt = fun(arr, mid);
            if(stuCnt > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}