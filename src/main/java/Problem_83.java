public class Problem_83 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(32);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode.print(deleteDuplicates(node1));


    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummay = new ListNode(0);
        dummay.next = head;
        ListNode node = head,preNode = head;
        while (node != null) {
            if (node.val != preNode.val) {
                preNode.next = node;
                preNode = preNode.next;
            }
            ListNode t = node;
            node = node.next;
            t.next = null;
        }
        return  dummay.next;
    }


}
