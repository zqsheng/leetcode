import java.util.ArrayList;
import java.util.List;

public class Problem_234 {
    private static class ListNode{
        private int val;
        private ListNode next;
        private ListNode(int x) {
            this.val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
//        ListNode node2 = new ListNode(2);
//        node1.next = node2;
//        node2.next = new ListNode(1);
//        System.out.println(isPalindrome(head));
        System.out.println(isPalindrome_0(head));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode node = head;
        List<Integer> list = new ArrayList<Integer>();
        while(node != null) {
            list.add(node.val);
            node = node.next;
        }
        node = head;
        for (int i = 0; i < list.size(); i++) {
            if (node.val != list.get(list.size() - i - 1).intValue()) {
                return false;
            }
            node = node.next;
        }
        return true;
    }

    public static boolean isPalindrome_0(ListNode head) {
        ListNode fast = head,slow = head,pre = null,prepre = null;
        while(fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
            pre.next = prepre;
            prepre = pre;
        }
        if(fast != null) {
            slow = slow.next;
        }
        while (slow != null){
            if (slow.val != pre.val) {
                return  false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
}
