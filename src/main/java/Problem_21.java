public class Problem_21 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;

        ListNode n11 = new ListNode(1);
        ListNode n12 = new ListNode(3);
        ListNode n13 = new ListNode(4);
        n11.next = n12;
        n12.next = n13;
        ListNode l = mergeTwoLists(n1, n11);
        print(l);


    }

    private static void print(ListNode l) {
        while (l != null) {
            System.out.print(l.val + "->");
            l = l.next;
        }
    }

    public static class ListNode {
        int val;
        public ListNode next;
        public ListNode(int x) { this.val = x;}
    }

    public static ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode l = null, tail = null;
        if (l1.val > l2.val) {
           l = l2;
           l2 = l2.next;
        } else {
            l = l1;
            l1 = l1.next;
        }
        tail = l;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val > l2.val){
                    tail.next = l2;
                    tail  = tail.next;
                    l2 = l2.next;
                } else {
                    tail.next = l1;
                    tail = tail.next;
                    l1 = l1.next;
                }
            } else if (l2 == null) {
                tail.next = l1;
                break;
            } else {
                tail.next = l2;
                break;
            }
        }
        return l;
    }
}
