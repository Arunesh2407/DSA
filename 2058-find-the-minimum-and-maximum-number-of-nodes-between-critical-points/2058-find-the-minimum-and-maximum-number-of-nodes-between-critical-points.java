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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] arr = new int[] { -1, -1 };
        ListNode prev = head;
        ListNode cur = head.next;
        ListNode nextt = cur.next;
        int lc = -1;
        int first = -1;
        int dist = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (cur.next != null) {
            dist++;
            if ((prev.val > cur.val && nextt.val > cur.val) || (prev.val < cur.val && nextt.val < cur.val)) {
                if (lc != -1) {
                    min = Math.min(min, dist - lc);
                }
                else{
                    first =  dist;
                }
                lc = dist;
                count++;
            }

            prev = prev.next;
            cur = cur.next;
            nextt = nextt.next;
        }
        if (count > 1) {
            arr[0] = min;
            arr[1] = lc - first;
        }

        return arr;
    }
}