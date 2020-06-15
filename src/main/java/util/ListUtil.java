package util;

public class ListUtil {

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }

    public static ListNode buildListByArray(int[] arr) {
        if (arr.length < 1) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode pointer = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode tmp = new ListNode(arr[i]);
            pointer.next = tmp;
            pointer = pointer.next;
        }
        return head;
    }
}
