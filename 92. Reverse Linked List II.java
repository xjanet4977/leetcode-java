/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;

        ListNode current = head;
        ListNode pre = null;
        for (int i = 0; i < left - 1; i++) {
            pre = current;
            current = current.next;
        }

        ListNode lastNodeOfFirstPart = pre;
        ListNode lastNodeOfSublist = current;
        ListNode next = null;

        for (int i = 0; i < right - left + 1; i++) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        if (lastNodeOfFirstPart != null) lastNodeOfFirstPart.next = pre;
        else head = pre;

        lastNodeOfSublist.next = current;

        return head;
    }
}