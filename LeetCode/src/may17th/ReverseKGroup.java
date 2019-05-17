package may17th;

import may17th.SwapPairs.ListNode;

public class ReverseKGroup {
  public ListNode reverseKGroup(ListNode head, int k) {

    // base case not enough list remain
    ListNode check = head;
    for (int i = 0; i < k; i++) {
      if (check == null) {
        return head;
      }else {
        check = check.next;
      }
    }
    
    ListNode tail = null;
    ListNode tailPointer = null;
    ListNode current = null;

    for (int i = 0; i < k; i++) {
      if (current == null) {
        tail = head;
        tailPointer = head;
        current = head.next;
      } else {
        tailPointer = current;
        current = current.next;
        tailPointer.next = tail;
        tail = tailPointer;
      }
    }

    head.next = reverseKGroup(current, k);
    return tail;
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
