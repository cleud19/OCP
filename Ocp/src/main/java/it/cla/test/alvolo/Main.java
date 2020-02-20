package it.cla.test.alvolo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		// peekTest();
		//testCollection();
		robo();
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
