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
    public ListNode rotateRight(ListNode head, int k) {
        // corner case
        if (k == 0 || head == null) return head;

        int size = 1;
        ListNode fast = head;
        ListNode slow = head;

        // calculate the length of the linked list
        while (fast.next != null) {
            fast = fast.next;
            size++;
        }

        for (int i = 1; i < size - k%size; i++) {
            slow = slow.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }
}