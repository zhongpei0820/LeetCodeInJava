#
#Reverse a linked list from position m to n. Do it in-place and in one-pass.
#
#
#
#For example:
#Given 1->2->3->4->5->NULL, m = 2 and n = 4,
#
#
#return 1->4->3->2->5->NULL.
#
#
#Note:
#Given m, n satisfy the following condition:
#1 ≤ m ≤ n ≤ length of list.
#
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseBetween(self, head, m, n):
        """
        :type head: ListNode
        :type m: int
        :type n: int
        :rtype: ListNode
        """
        node = ListNode(0)
        node.next = head
        prev = node
        for i in range(0,m - 1):
            prev = prev.next
        start = prev.next
        then = start.next
        for i in range(m,n):
            start.next = then.next
            then.next = prev.next
            prev.next = then
            then = start.next
        return node.next