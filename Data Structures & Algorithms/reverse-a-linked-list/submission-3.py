# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# 1-> 2-> 3-> 4
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev=None

        current=head

        while current is not None:
            next_node=current.next

            current.next=prev

            prev=current

            current=next_node
        
        return prev