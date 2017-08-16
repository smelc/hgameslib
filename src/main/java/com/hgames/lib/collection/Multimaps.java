package com.hgames.lib.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Class to simulate multimaps.
 * 
 * @author smelC
 */
public class Multimaps {

	/**
	 * Record k->v in {@code mmap}.
	 * 
	 * @param mmap
	 * @param k
	 * @param v
	 */
	public static <K, V> void addToListMultimap(Map<K, List<V>> mmap, K k, V v) {
		List<V> list = mmap.get(k);
		if (list == null) {
			list = new ArrayList<V>();
			mmap.put(k, list);
		}
		list.add(v);
	}

	/**
	 * Record k->v in {@code mmap} if it isn't in there already.
	 * 
	 * @param mmap
	 * @param k
	 * @param v
	 */
	public static <K, V> void addToListMultimapIfAbsent(Map<K, List<V>> mmap, K k, V v) {
		List<V> list = mmap.get(k);
		if (list == null) {
			list = new ArrayList<V>();
			mmap.put(k, list);
		}
		if (!list.contains(v))
			list.add(v);
	}

}
