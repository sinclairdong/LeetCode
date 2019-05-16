package may15th;

import java.util.PriorityQueue;

public class MergeKLists {

  public static void main(String[] args) {
    MergeKLists m = new MergeKLists();
    ListNode a = m.new ListNode(3, m.new ListNode(4, m.new ListNode(5)));
    ListNode b = m.new ListNode(1, m.new ListNode(7, m.new ListNode(8)));
    ListNode c = m.new ListNode(2, m.new ListNode(6));

    ListNode[] lists = {a, b, c};


    ListNode d = m.mergeKLists(lists);
    while (d != null) {
      System.out.println(d.val);
      d = d.next;
    }

  }

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int i = 0; i < lists.length; i++) {
      while (lists[i] != null) {
        queue.add(lists[i].val);
        lists[i] = lists[i].next;
      }
    }
    ListNode head = null;
    ListNode pointer = null;
    while (!queue.isEmpty()) {
      int i = queue.poll();
      if (head == null) {
        head = new ListNode(i);
        pointer = head;
      } else {
        pointer.next = new ListNode(i);
        pointer = pointer.next;
      }
    }

    return head;
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }

    ListNode(int x, ListNode next) {
      val = x;
      this.next = next;
    }
  }
}
