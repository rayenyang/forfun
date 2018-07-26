package com.rayenyang.forfun;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @author yangruiheng
 *         Date:    2018/7/23
 */
public class SumOf2Num {
	public static void main(String[] args) {
		int[] arr = {2, 7, 11, 15};
		System.out.println(Arrays.toString(twoSum(arr, 9)));
		System.out.println(Arrays.toString(twoSumOptm(arr, 9)));
	}
	
	/**
	 * O(n * n)
	 */
	private static int[] twoSum(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			int tmp = target - arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (tmp == arr[j]) {
					return new int[]{i, j};
				}
			}
		}
		return null;
	}
	
	/**
	 * O(n)
	 */
	private static int[] twoSumOptm(int[] arr, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int tmp = target - arr[i];
			if (map.containsKey(tmp)) {
				return new int[]{map.get(tmp), i};
			}
			map.put(arr[i], i);
		}
		return null;
	}
}
