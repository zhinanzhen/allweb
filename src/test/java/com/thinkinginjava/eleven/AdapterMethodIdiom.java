package com.thinkinginjava.eleven;

import java.util.*;

/**
 * 适配器方式
 * @author xxn
 * @date 2016年3月25日  上午10:51:54
 */
public class AdapterMethodIdiom {
	public static void main(String[] args) {
		ReversibleArrayList<String> ral = new ReversibleArrayList<String>(
				Arrays.asList("To be or not to be".split(" ")));
		for (String s : ral)
			System.out.print(s + " ");
		System.out.println();
		for (String s : ral.reversed())
			System.out.print(s + " ");
	}
}

@SuppressWarnings("serial")
class ReversibleArrayList<T> extends ArrayList<T> {
	public ReversibleArrayList(Collection<T> c) {
		super(c);
	}

	public Iterable<T> reversed() {
		return new Iterable<T>() {
			public Iterator<T> iterator() {
				return new Iterator<T>() {
					int current = size() - 1;

					public boolean hasNext() {
						return current > -1;
					}

					public T next() {
						return get(current--);
					}

					public void remove() { // Not implemented
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
}
