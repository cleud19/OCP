package it.cla.test.alvolo;

import java.time.Duration;
import java.time.Period;

public class Main {

	public static void main(String[] args) {
		String d = Duration.ofDays(1).toString();
		String p = Period.ofDays(1).toString();
		System.out.println(d + " " + p);
	}

}
