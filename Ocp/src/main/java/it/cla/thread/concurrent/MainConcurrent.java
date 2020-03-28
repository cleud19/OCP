package it.cla.thread.concurrent;

import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Stream;

public class MainConcurrent {

	public static void main(String[] args) {
		startTest();

	}

	private static void startTest() {
		Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
		SortedSet<String> set = stream.collect(ConcurrentSkipListSet::new, Set::add,
		ConcurrentSkipListSet::addAll);
		System.out.println(set); // [f, l, o, w]
		
	}

}
