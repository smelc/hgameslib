package com.hgames.lib;

import java.util.ArrayList;
import java.util.List;

import com.hgames.lib.collection.list.Lists;
import com.hgames.lib.iterable.Iterables;

/**
 * @author smelC
 */
public class IterablesTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final List<Integer> unDeux = new ArrayList<Integer>();
		unDeux.add(1);
		unDeux.add(2);
		final List<Integer> troisQuatreCing = new ArrayList<Integer>();
		unDeux.add(3);
		unDeux.add(4);
		unDeux.add(5);
		final List<List<Integer>> ll = Lists.newArrayList();
		ll.add(unDeux);
		ll.add(troisQuatreCing);
		final List<Integer> flattened = Lists.newArrayList(Iterables.flatten(ll).iterator());
		if (flattened.size() != unDeux.size() + troisQuatreCing.size())
			throw new IllegalStateException();
		System.out.println(flattened);
	}

}
