package may17th;


public class SwapPairs {
  /**
   * Given 1->2->3->4, you should return the list as 2->1->4->3.
   * 
   * @param head
   * @return
   */
  public ListNode swapPairs(ListNode head) {

    if (head == null || head.next == null) {
      return head;
    }


    ListNode a = head;
    ListNode b = head.next;

    a.next = b.next;
    b.next = a;
    a.next = swapPairs(a.next);

    return b;
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
