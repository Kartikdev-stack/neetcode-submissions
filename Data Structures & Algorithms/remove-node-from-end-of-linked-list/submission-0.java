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
    public ListNode removeNthFromEnd(ListNode head, int n) {

           if(head==null)
               return null;

           int length=size(head);

           if(n==length)
              return head.next;

           ListNode current=head;
           int end=length-n;

          for(int i=1;i<length-n;i++){
            current=current.next;
          }

           current.next=current.next.next;
           
           return head;
    }

    public int size(ListNode head){
        ListNode current=head;
        int count=0;
        while(current!=null){
            current=current.next;
            count++;
        }
        return count;
    }
}
