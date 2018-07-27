package com.rayenyang.forfun;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * <p>
 * 示例：
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串
 *
 * @author yangruiheng
 *         Date:    2018/7/24
 */
public class LengthOfLongestSubString {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));//3
		System.out.println(lengthOfLongestSubstring("bbbbb"));//1
		System.out.println(lengthOfLongestSubstring("pwwkew"));//3
		System.out.println();
		System.out.println(lengthOfLongestSubstring_OPT("abcabcbb"));//3
		System.out.println(lengthOfLongestSubstring_OPT("bbbbb"));//1
		System.out.println(lengthOfLongestSubstring_OPT("pwwkew"));//3
		System.out.println();
		System.out.println(lengthOfLongestSubstring_OPT2("abcabcbb"));//3
		System.out.println(lengthOfLongestSubstring_OPT2("bbbbb"));//1
		System.out.println(lengthOfLongestSubstring_OPT2("pwwkew"));//3
	}
	
	/**
	 * T = O(n * n)
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
	
	/**
	 * O(2n)
	 */
	public static int lengthOfLongestSubstring_OPT(String s) {
		int result = 0, m = 0, n = 0;
		int length = s.length();
		Set<Character> set = new HashSet<>();
		while (m < length && n < length) {
			if (!set.contains(s.charAt(n))) {
				set.add(s.charAt(n++));
				result = Math.max(result, n - m);
			} else {
				set.remove(s.charAt(m++));
			}
		}
		return result;
	}
	
	/**
	 * O(n)
	 */
	public static int lengthOfLongestSubstring_OPT2(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int result = 0;
		for (int i = 0, j = 0; j < s.length(); j++) {
			char key = s.charAt(j);
			if (map.containsKey(key)) {
				i = Math.max(result, map.get(key));
			}
			result = Math.max(result, j - i + 1);
			map.put(key, j + 1);
		}
		return result;
	}
}
