package com.javaxpert.test;

import java.util.HashSet;
import java.util.Set;

class AAA {
	Integer a;
	Integer b;
	AAA(Integer x,Integer y) {
		this.a = x;
		this.b = y;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + ((b == null) ? 0 : b.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AAA other = (AAA) obj;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		if (b == null) {
			if (other.b != null)
				return false;
		} else if (!b.equals(other.b))
			return false;
		return true;
	}
}

public class TestClass3 {
	public static void main(String args[]) {
		Set<AAA> set = new HashSet<AAA>();
		AAA x = new AAA(3,4);
		AAA y = new AAA(3,4);
		set.add(x);
		set.add(y);
		System.out.println(set.size());
	}
	
}
