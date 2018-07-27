package com.rayenyang.forfun;

/**
 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 
 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 
 你可以假设 nums1 和 nums2 均不为空。
 
 nums1 = [1, 3]
 nums2 = [2]
 
 中位数是 2.0
 
 nums1 = [1, 2]
 nums2 = [3, 4]
 
 中位数是 (2 + 3)/2 = 2.5
 
 * @author yangruiheng
 *         Date:    2018/7/27
 */
public class FindMedianSortedArrays {
	public static void main(String[] args) {
	
	}
	
	static double findMedianSortedArrays(int[] arr1, int[] arr2) {
		int length1 = arr1.length;
		int length2 = arr2.length;
		int total = length1 + length2;
		boolean b = total % 2 == 0;
		int pos = total / 2;
		int index = 2;
		for (int i = 0, j = 0; i < length1 || j < length2; i++,j++) {
			int val1 = i < length1 ? arr1[i] : 0;
			int val2 = j < length2 ? arr2[j] : 0;
			if (index == pos);
		}
		return 0;
	}
}
