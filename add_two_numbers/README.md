# Add Two Numbers
You are given two **non-empty** linked lists representing two non-negative integers. The digits are stored in **reverse order** and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

## Example
**Input:** `(2 -> 4 -> 3) + (5 -> 6 -> 4)`\
**Output:** `7 -> 0 -> 8`\
**Explanation:** `342 + 465 = 807`

## Solution in Java
```java
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
```

## Solution in C++
```cpp
/**
 * Definition for singly-linked list given.
 */
struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {}
};

class Solution
{
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2)
    {
        auto carry = 0;
        ListNode* head = nullptr;
        ListNode* newNode = nullptr;
        ListNode* prevNode = nullptr;
        
        while (l1 || l2 || carry == 1)
        {
            auto sum = carry;
            
            sum = (l1) ? sum + l1->val : sum;
            sum = (l2) ? sum + l2->val : sum;
            l1 = (l1) ? l1->next : l1;
            l2 = (l2) ? l2->next : l2;
            
            carry = (sum >= 10) ? 1 : 0;
            sum = (sum >= 10) ? sum % 10 : sum;
        
            newNode = new ListNode(sum);
            if (!head) { head = newNode; }
            if (prevNode) { prevNode->next = newNode; }
            prevNode = newNode;
        }
        
        return head;
    }
};
```