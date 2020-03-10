public class Problem_test_18 {
    public static void main(String[] args) {

    }

    public static ListNode deleteNode(ListNode head, int val) {
        ListNode dummay = new ListNode(0);
        dummay.next = head;
        ListNode node = head,preNode = dummay;
        while (node != null) {
            if(node.val == val) {
                preNode.next = node.next;
            }
            preNode = node;
            node = node.next;

        }
        return dummay.next;
    }
}
