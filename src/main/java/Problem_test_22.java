public class Problem_test_22 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode.print(getKthFromEnd(node1,2));
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode left = head,right = head;
        for (int i = 0; i < k; i++) {
            right = right.next;
        }
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        return left;
    }
}
