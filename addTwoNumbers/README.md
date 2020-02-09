# Add Two Numbers
You are given two **non-empty** linked lists representing two non-negative integers. The digits are stored in **reverse order** and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

## Example
**Input:** `(2 -> 4 -> 3) + (5 -> 6 -> 4)`
**Output:** `7 -> 0 -> 8`
**Explanation:** `342 + 465 = 807`

## addTwoNumbers.Solution
```java
/* 
    Definition for singly-linked list given.
*/
class addTwoNumbers.ListNode {
  int val;
  addTwoNumbers.ListNode next;
  addTwoNumbers.ListNode(int x) { val = x; }
}

class addTwoNumbers.Solution {
  public addTwoNumbers.ListNode addTwoNumbers(addTwoNumbers.ListNode l1, addTwoNumbers.ListNode l2) {        
    var curr1 = l1;
    var curr2 = l2;
    addTwoNumbers.ListNode head = null;
    addTwoNumbers.ListNode newNode = null;
    addTwoNumbers.ListNode prevNode = null;
    int carry = 0;
    
    while (curr1 != null || curr2 != null || carry == 1) {
      var sum = 0;
      
      if (curr1 != null && curr2 != null) {
        sum = carry + curr1.val + curr2.val;
        curr1 = curr1.next;
        curr2 = curr2.next;
      }
      else if (curr1 != null && curr2 == null) {
        sum = carry + curr1.val;
        curr1 = curr1.next;
      }
      else if (curr1 == null && curr2 != null) {
        sum = carry + curr2.val;
        curr2 = curr2.next;
      }
      else if (curr1 == null && curr2 == null) {
        if (carry == 1) {
            sum = carry;
        }
      }
      
      newNode = (sum >= 10) ? new addTwoNumbers.ListNode(sum % 10) : new addTwoNumbers.ListNode(sum);
      carry = (sum >= 10) ? 1 : 0;
      
      if (head == null) head = newNode;
      if (prevNode != null) prevNode.next = newNode;
      prevNode = newNode;
    }
    
    return head;
  }
}
```