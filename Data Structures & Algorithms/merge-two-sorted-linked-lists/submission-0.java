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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedHead=list1;
        // handling edge case if one of the list is empty

        if(list1==null){
            return list2; // list1 is empty
        }

        if(list2==null){
            return list1; // list2 is empty
        }

        // identifying the head

        if(list1.val<list2.val){
            list1=list1.next;
        }else{
            mergedHead=list2;
            list2=list2.next;
        }

        ListNode curr=mergedHead; // setting the head of the merged list

       // combining the sorted lists

        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
               curr.next=list1;
               list1=list1.next;
            }else{
                curr.next=list2;
                list2=list2.next;
            }
            curr=curr.next;
        }        

        while(list1!=null){
            curr.next=list1;
            curr=curr.next;
            list1=list1.next;
        }

        while(list2!=null){
            curr.next=list2;
            curr=curr.next;
            list2=list2.next;
        }
        return mergedHead;
    }
}