package may15th;

public class RemoveNthFromEnd {
  public ListNode removeNthFromEnd(ListNode head, int n) {

    ListNode tracker = head;
    ListNode pointer = head;
    int counter = 1;
    while (pointer.next != null) {
      pointer = pointer.next;
      counter++;
      if (counter >= n) {
        tracker = tracker.next;
      }
    }
    if (counter == n) {
      head = head.next;
    } else if (n == 0) {
      tracker.next = null;
    } else {
      tracker.next = tracker.next.next;
    }
    return head;
  }

  public static void main(String[] args) {
    ListNode a = new RemoveNthFromEnd().new ListNode(1);
    ListNode b = new RemoveNthFromEnd().removeNthFromEnd(a, 1);
    System.out.println(b);
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}

