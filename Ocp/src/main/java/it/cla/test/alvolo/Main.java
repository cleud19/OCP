package it.cla.test.alvolo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		//peekTest();
		metodoTestInterfaccia((e) -> { String e = ""; return "Poof"; });
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
	
	public static void metodoTestInterfaccia(Secret s){
		System.out.println(s.magic(5));
	}
}
