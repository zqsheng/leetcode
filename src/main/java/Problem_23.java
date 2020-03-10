import java.util.Collections;

public class Problem_23 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;

        ListNode node11 = new ListNode(1);
        ListNode node21 = new ListNode(3);
        ListNode node31 = new ListNode(4);
        node11.next = node21;
        node21.next = node31;

        ListNode node12 = new ListNode(2);
        ListNode node22 = new ListNode(6);
        node12.next = node22;

        ListNode head = mergeKLists(new ListNode[]{node1, node11, node12});
        print(head);


    }
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    // 时间复杂度高,用优先队列处理
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null,tail = null;
        while (!isEmpty(lists)) {
            int index = -1;
            ListNode minNode = null;
            for (int i = 0; i < lists.length; i++) {
                ListNode start = lists[i];
                if (start != null) {
                    if (minNode == null) {
                        minNode = start;
                        index = i;
                    } else {
                        if (start.val < minNode.val) {
                            minNode = start;
                            index = i;
                        }
                    }
                }
            }
            lists[index] = minNode.next;
            minNode.next = null;
            if (head == null) {
                head = minNode;
                tail = minNode;
            } else {
                tail.next = minNode;
                tail = tail.next;
            }
        }
        return head;
    }
    public static boolean isEmpty(ListNode[] arr) {
        for (ListNode listNode : arr) {
            if (listNode != null) {
                return false;
            }
        }
        return true;
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println();
    }
}
