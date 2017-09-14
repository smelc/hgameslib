package com.hgames.lib.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * @author smelC
 */
public class Queues {

	/**
	 * @param queue
	 * @return An iterator that destructs {@code queue}.
	 */
	public static <T> Iterator<T> iteratorOf(final Queue<T> queue) {
		return new Iterator<T>() {
			@Override
			public boolean hasNext() {
				return !queue.isEmpty();
			}

			@Override
			public T next() {
				if (hasNext())
					return queue.remove();
				else
					throw new NoSuchElementException();
			}

			@Override
			public void remove() {
				next();
			}
		};
	}

}
