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