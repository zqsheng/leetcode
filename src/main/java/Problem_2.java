import java.util.Optional;

public class Problem_2 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n = null,tail = null;
        int d = 0;
        while (l1 != null || l2 != null || d == 1) {
            int sum = (l1 != null ? l1.val : 0)
                    + (l2 != null ? l2.val : 0)
                    + d;
            d = sum / 10;
            if (n == null) {
                n = new ListNode(sum % 10);
                tail = n;
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return n;
    }
    public static ListNode reverseLinked(ListNode l) {
        ListNode node = l,preNode, prepreNode = null;
        while (node != null) {
            preNode = node;
            node = node.next;
            preNode.next = prepreNode;
            prepreNode = preNode;
        }
        return prepreNode;
    }
  public static void main(String[] args) {
      ListNode n1 = new ListNode(1);
      ListNode n2 = new ListNode(8);
      ListNode n3 = new ListNode(3);
      ListNode n4 = new ListNode(4);
      n1.next = n2;
//      n2.next = n3;
//      n3.next = n4;
      ListNode n11 = new ListNode(0);
      ListNode n12 = new ListNode(6);
      ListNode n13 = new ListNode(4);
      ListNode n14 = new ListNode(4);
//      n11.next = n12;
//      n12.next = n13;
//      n13.next = n14;
//      reverseLinked(n1);
      ListNode listNode = addTwoNumbers(n1, n11);
//      listNode = reverseLinked(listNode);
      printLink(listNode);
  }

  private static void printLink(ListNode l) {
        while (l != null) {
            System.out.print(l.val);
            l = l.next;
        }
  }

}
