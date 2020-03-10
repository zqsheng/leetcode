import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem_19 {
      public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  // 空间复杂度高
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list  = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int loc = list.size() - n;
        if (loc == 0) {
            head = head.next;
            return head;
        }
        ListNode node1 = list.get(loc - 1);
        node1.next = node1.next.next;
        return head;
    }
    public static ListNode removeNthFromEnd_1(ListNode head,int n) {
        int length = 0;
        ListNode dummayNode = new ListNode(0);
        dummayNode.next = head;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        int loc = length - n;
        int i = 0;
        node = dummayNode;
        while (i < loc) {
            node = node.next;
            i++;
        }
        node.next = node.next.next;
        return dummayNode.next;
    }

    public static ListNode removeNthFromEnd_2(ListNode head,int n) {
        ListNode dummay = new ListNode(0),first = dummay,second = dummay;
        dummay.next = head;
        for (int i = 0; i < n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummay.next;
    }

    static void print(ListNode node) {
          while (node != null) {
              System.out.println(node.val);
              node = node.next;
          }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node = removeNthFromEnd_2(node1, 4);
        print(node);
    }
}
