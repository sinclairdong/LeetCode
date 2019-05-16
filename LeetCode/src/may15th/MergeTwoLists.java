package may15th;



public class MergeTwoLists {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    // head
    ListNode result, l1P, l2P, resultP;
    if (l1 == null && l2 == null) {
      return null;
    } else if (l1 == null) {
      return l2;
    } else if (l2 == null) {
      return l1;
    }
    if (l1.val < l2.val) {
      result = l1;
      resultP = result;
      l1P = l1.next;
      l2P = l2;
    } else {
      result = l2;
      resultP = result;
      l1P = l1;
      l2P = l2.next;
    }

    while (l1P != null || l2P != null) {
      if (l1P == null) {
        resultP.next = l2P;
        l2P = l2P.next;
      } else if (l2P == null) {
        resultP.next = l1P;
        l1P = l1P.next;
      } else if (l1P.val < l2P.val) {
        resultP.next = l1P;
        l1P = l1P.next;
      } else {
        resultP.next = l2P;
        l2P = l2P.next;
      }
      resultP = resultP.next;
    }

    return result;
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
