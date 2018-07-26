package com.rayenyang.forfun;

import java.math.BigInteger;
import java.util.List;

/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author yangruiheng
 *         Date:    2018/7/23
 */
public class Add2Num {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
//		l2.next.next = new ListNode(4);
		
//		ListNode listNode = add2Num(l1, l2);
		ListNode listNode = add2NumOptm(l1, l2);
		while (listNode != null) {
			System.out.println(listNode.val);
			listNode = listNode.next;
		}
	}
	
	private static ListNode add2Num(ListNode l1, ListNode l2) {
		int val = l1.val;
		if (val == 0) {
			return l2;
		}
		int val2 = l2.val;
		if (val2 == 0) {
			return l1;
		}
		ListNode resultNode = new ListNode(0);
		int l1bit = 0;
		int l2bit = 0;
		{
			ListNode l1NextNode = l1;
			ListNode l2NextNode = l2;
			while (l1NextNode != null) {
				l1bit++;
				l1NextNode = l1NextNode.next;
			}
			while (l2NextNode != null) {
				l2bit++;
				l2NextNode = l2NextNode.next;
			}
		}
		ListNode l1NextNode = l1;
		ListNode l2NextNode = l2;
		ListNode resultNextNode = new ListNode(0);
		resultNode.next = resultNextNode;
		if (l1bit > l2bit) {
			int bit = l1bit - l2bit;
			while (bit-- > 0) {
				if (resultNode.val == 0) {
					resultNode.val = l1.val;
				} else {
					resultNextNode.val = l1.val;
					if (resultNode.next == null) {
						resultNode.next = resultNextNode;
					}
					if (bit > 0) {
						resultNextNode.next = new ListNode(0);
						resultNextNode = resultNextNode.next;
					}
				}
				l1NextNode = l1NextNode.next;
			}
			int overBit = 0;
			while(l1NextNode != null) {
				int value = l1NextNode.val + l2NextNode.val + overBit;
				overBit = value / 10;
				int bitValue = value % 10;
				if (resultNode.val == 0) {
					resultNode.val = bitValue;
				} else {
					resultNextNode.val = bitValue;
					if (resultNode.next == null) {
						resultNode.next = resultNextNode;
					}
					if (l1NextNode.next != null) {
						resultNextNode.next = new ListNode(0);
						resultNextNode = resultNextNode.next;
					}
				}
//				resultNextNode = resultNode.next;
				l1NextNode = l1NextNode.next;
				l2NextNode = l2NextNode.next;
			}
			return resultNode;
		} else if (l1bit < l2bit) {
			return add2Num(l2, l1);
		} else {
			int overBit = 0;
			while(l1NextNode != null) {
				int value = l1NextNode.val + l2NextNode.val + overBit;
				overBit = value / 10;
				int bitValue = value % 10;
				if (resultNode.val == 0) {
					resultNode.val = bitValue;
				} else {
					resultNextNode.val = bitValue;
					if (resultNode.next == null) {
						resultNode.next = resultNextNode;
					}
					if (l1NextNode.next != null) {
						resultNextNode.next = new ListNode(0);
						resultNextNode = resultNextNode.next;
					}
				}
//				resultNextNode = resultNode.next;
				l1NextNode = l1NextNode.next;
				l2NextNode = l2NextNode.next;
			}
			return resultNode;
		}
	}
	
	private static ListNode add2NumOptm(ListNode l1, ListNode l2) {
		ListNode headNode = new ListNode(0);
		ListNode q = l1, p = l2, curNode = headNode;
		int overBit = 0;
		while (q != null || p != null) {
			int val1 = q == null ? 0 : q.val;
			int val2 = p == null ? 0 : p.val;
			int plus = val1 + val2 + overBit;
			overBit = plus / 10;
			curNode.next = new ListNode(plus % 10);
			curNode = curNode.next;
			if (q != null) {
				q = q.next;
			}
			if (p != null) {
				p = p.next;
			}
		}
		if (overBit > 0) {
			curNode.next = new ListNode(overBit);
		}
		return headNode.next;
	}
	
	
	//Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) {
			val = x;
		}
	}
}
