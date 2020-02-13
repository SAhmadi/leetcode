package add_two_numbers.java;

/*
    Definition for singly-linked list given.
*/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {        
        var curr1 = l1;
        var curr2 = l2;
        ListNode head = null;
        ListNode newNode;
        ListNode prevNode = null;
        int carry = 0;
        
        while (curr1 != null || curr2 != null || carry == 1) {
            var sum = 0;
            
            if (curr1 != null && curr2 != null) {
                sum = carry + curr1.val + curr2.val;
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
            else if (curr1 != null) {
                sum = carry + curr1.val;
                curr1 = curr1.next;
            }
            else if (curr2 != null) {
                sum = carry + curr2.val;
                curr2 = curr2.next;
            }
            else {
                sum = carry;
            }
            
            newNode = (sum >= 10) ? new ListNode(sum % 10) : new ListNode(sum);
            carry = (sum >= 10) ? 1 : 0;
            
            if (head == null) head = newNode;
            if (prevNode != null) prevNode.next = newNode;
            prevNode = newNode;
        }
        
        return head;
    }
}