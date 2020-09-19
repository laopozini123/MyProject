package com.why;

/**
 * @author ：why
 * @description：
 * @version:
 */
public class AddTwoNums {
    public static void main(String[] args) {
        addTwoNums(new ListNode(807), new ListNode(203));
    }

    static ListNode addTwoNums(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode((l1.val + l2.val) % 10);
        int jinwei = (l1.val + l2.val) / 10;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            int current = l1.val + l2.val + jinwei;
            ListNode temp = result;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(current % 10);
            jinwei = current / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int current = l1.val + jinwei;
            ListNode temp = result;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(current % 10);
            jinwei = current / 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            int current = l2.val + jinwei;
            ListNode temp = result;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(current % 10);
            jinwei = current / 10;
            l2 = l2.next;
        }

        return result;
    }
}
