package com.rayenyang.forfun;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 *
 * 示例：
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串
 * @author yangruiheng
 *         Date:    2018/7/24
 */
public class LengthOfLongestSubString {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));//3
		System.out.println(lengthOfLongestSubstring("bbbbb"));//1
		System.out.println(lengthOfLongestSubstring("pwwkew"));//3
	}
	
	/**
	 * T = O(n * n)
	 * S = O(n)
	 */
	public static int lengthOfLongestSubstring(String s) {
		char[] chars = s.toCharArray();
		int maxLength = 0;
		for (int i = 0; i < chars.length - 1; i++) {
			Set<Character> set = new HashSet<>();
			set.add(chars[i]);
			for (int j = i + 1; j < chars.length; j++) {
				if (set.contains(chars[j])) {
					break;
				} else {
					set.add(chars[j]);
				}
			}
			if (set.size() > maxLength) {
				maxLength = set.size();
			}
		}
		return maxLength;
	}
}
