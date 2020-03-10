import java.util.List;

public class Problem_test_6 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
//        node1.next = node2;
        node2.next = node3;
        ArrayUtils.print(reversePrint(node1));
    }
    public static int[] reversePrint(ListNode head) {
        ListNode curr = head,pre = null,temp;
        int len = 0;
        while (curr != null) {
            temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
            len++;
        };
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = pre.val;
            pre = pre.next;
        }
        return ans;
    }
}
