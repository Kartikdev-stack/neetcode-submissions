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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode secondHalf=reverseLL(slow.next);

        slow.next=null;
        ListNode firstHalf=head;

        mergeLL(firstHalf, secondHalf);
    }

    public ListNode reverseLL(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        ListNode next=null;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }   

    public void mergeLL(ListNode l1, ListNode l2){

        while(l1!=null && l2!=null){
            ListNode temp1=l1.next;
            ListNode temp2=l2.next;

            l1.next=l2;

            if(temp1==null) break;

            l2.next=temp1;

            l1=temp1;
            l2=temp2;
            
        }
    }

}
