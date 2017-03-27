package com.thinkinginjava.file.sort;

public interface Compare {
	boolean lessThan(Object lhs, Object rhs);
	boolean lessThanOrEqual(Object lhs, Object rhs);
}
