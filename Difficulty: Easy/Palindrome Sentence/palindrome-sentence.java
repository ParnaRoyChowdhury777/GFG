

class Solution {
    public boolean isPalinSent(String s) {
        // code here
        
        StringBuilder s1 = new StringBuilder();
        
        for(char c : s.toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                s1.append(Character.toLowerCase(c));
            }
        }
        
        int n = s1.length();
        if(n == 0) return true;
        
        for(int i=0; i<=n/2; i++) {
            if(s1.charAt(i) != s1.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}