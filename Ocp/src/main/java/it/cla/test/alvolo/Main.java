package it.cla.test.alvolo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		// peekTest();
		//testCollection();
		//robo();
		//robo2();
		//streamError();
		//durationTest();
		dequeTest();
	}

	private static void dequeTest() {
		Queue<Integer> queue = new ConcurrentLinkedQueue<>();
		queue.offer(10);
		queue.offer(4);
		System.out.println(queue.toString());
		System.out.println("controllo primo elemento queue: "+queue.peek());
		System.out.println("elimino primo elemento queue: "+queue.poll());
		System.out.println("controllo primo elemento queue : "+queue.peek());
		System.out.println();
		Deque<Integer> deque = new ConcurrentLinkedDeque<>();
		deque.offer(10);
		deque.push(4);
		System.out.println(deque.toString());
		System.out.println("controllo primo elemento deque: "+deque.peek());
		System.out.println("elimino primo elemento deque: "+deque.pop());
		System.out.println("controllo primo elemento deque: "+deque.peek());
		
	}

	private static void durationTest() {
		String s = Duration.of(60, ChronoUnit.SECONDS).toString();
		System.out.println(s);
	}

	private static void streamError() {
		Stream<String> s = Stream.of("brown bear-", "grizzly-");
		s.sorted(Comparator.reverseOrder()).forEach(System.out::print); // grizzly-brown
																		// bear-
		//s.sorted(Comparator::reverseOrder); // DOES NOT COMPILE

	}

	private static void robo2() {
		Set<String> s = new HashSet<>();
		s.add("lion");
		s.add("tiger");
		s.add("bear");
		//s.forEach(s -> System.out.println(s));

	}

	private static void robo() {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 10);
		map.put(2, 20);
		map.put(3, null);
		map.merge(1, 3, (a, b) -> a + b);
		map.merge(3, 3, (a, b) -> a + b);
		System.out.println(map);
	}

	static public void peekTest() {
		Stream<LocalDate> s = Stream.of(LocalDate.now());
		UnaryOperator<LocalDate> u = l -> l;
		s.filter(l -> l != null).map(u).peek(System.out::println);
	}

	static public void durationnPeriod() {
		String d = Duration.ofDays(1).toString();
		String p = Period.ofDays(1).toString();
		System.out.println(d + " " + p);
	}

	public interface Secret {
		String magic(double d);
	}

	public static void testCollection() {
		String[] array = { "gerbil", "mouse" }; // [gerbil, mouse]
		printelements(array) ;
		List<String> list = Arrays.asList(array); // returns fixed size list
		printelements(array) ;
		System.out.println(list +" list") ;
		list.set(1, "test"); // [gerbil, test]
		printelements(array) ;
		System.out.println(list +" list") ;
		array[0] = "new"; // [new, test]
		printelements(array) ;
		System.out.println(list +" list") ;
		String[] array2 = (String[]) list.toArray(); // [new, test]
		printelements(array) ;;
		System.out.println(list +" list") ;
		list.remove(1);
		printelements(array) ;
		System.out.println(list +" list") ;

	}
	
	static void printelements(String[] array){
		System.out.print("[");
		for(String s : array){
			System.out.print(s+", ");
		}
		System.out.print("] array");
		System.out.println("");
	}
}
