/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    int findLength(Node slow, Node fast) {
        int cnt = 1;
        fast = fast.next;
        while(slow != fast) {
            cnt++;
            fast = fast.next;
        }
        return cnt;
    }
    
    // Function to find the length of a loop in the linked list.
    public int lengthOfLoop(Node head) {
        // Add your code here.
        Node slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
               return findLength(slow, fast);
        }
        return 0;
    }
}