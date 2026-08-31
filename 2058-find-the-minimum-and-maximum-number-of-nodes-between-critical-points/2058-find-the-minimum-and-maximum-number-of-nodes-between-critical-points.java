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
        int[] ans = new int[2];
        int prev = head.val;
        head = head.next;
        ArrayList<Integer> list = new ArrayList<>(); 
        int ptr = 1;
        while(head.next != null){
            if((head.val > prev && head.val > head.next.val) || (head.val < prev && head.val < head.next.val)){
                list.add(ptr);
            }
            prev = head.val;
            head = head.next;
            ptr++;

        }
        if(list.size() < 2){
            return new int[]{-1,-1};
        }
        ans[0] = Integer.MAX_VALUE;
        for(int i = 0; i < list.size()-1; i++){
            ans[0] = Math.min(ans[0], list.get(i+1) - list.get(i));
        }
        ans[1] = list.get(list.size()-1) - list.get(0);

        return ans;
    }
}