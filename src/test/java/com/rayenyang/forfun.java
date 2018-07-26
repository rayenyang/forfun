package com.rayenyang;

/**
 * @author yangruiheng
 *         Date:    2018/7/24
 */
public class forfun {
	public static void main(String[] args) {
		Ref r1 = new Ref();
		Ref r2 = r1;
		r1 = null;
		System.out.println(r2);
	}
	
	static class Ref {
	
	}
}
