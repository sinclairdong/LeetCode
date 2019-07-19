package july19th;

public class RotateRight {

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode pointer = head;
    ListNode break_point = head;
    int counter = 0;

    while (pointer != null) {
      counter++;
      pointer = pointer.next;
    }

    k = k % counter;

    if (k == 0) {
      return head;
    }

    pointer = head;
    while (pointer.next != null) {
      if (k > 0) {
        k--;
      } else {
        break_point = break_point.next;
      }

      pointer = pointer.next;
    }

    ListNode new_head = break_point.next;
    break_point.next = null;
    pointer.next = head;

    return new_head;
  }


  public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
      val = x;
    }
  }
}
