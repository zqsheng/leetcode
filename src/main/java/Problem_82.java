public class Problem_82 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        ListNode.print(deleteDuplicates(node1));


    }
    // TODO 未处理完成
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummay = new ListNode(Integer.MAX_VALUE);
        dummay.next = head;
        ListNode node = dummay,preNode = dummay,tail = dummay;
        while (node != null) {
            ListNode next = node.next;
            if (next != null) {
                if (node.val != next.val && node.val != preNode.val) {
                    tail.next = node;
                    tail = tail.next;

                }
            } else {
                if (node.val != preNode.val) {
                    tail.next = node;
                    tail = tail.next;
                }
            }
            ListNode t = node;
            node = node.next;
            t.next = null;
            preNode = t;
        }
        return  dummay.next;
    }
}
