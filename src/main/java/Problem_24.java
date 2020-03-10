public class Problem_24 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next =  node5;
        node5.next =  node6;

        ListNode node = swapPairs(node1);
        print(node);

    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummay = new ListNode(0);
        dummay.next = head;
        ListNode node = head,preNode = dummay;
        while (node != null){
            ListNode next = node.next;
            if (next == null) {
                node.next = null;
                preNode.next = node;
                break;
            }
            preNode.next = next;
            ListNode t = node.next.next;
            next.next = node;
            preNode = node;
            node.next = null;
            node = t;
        }
        return dummay.next;
    }
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }
    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println();
    }

}