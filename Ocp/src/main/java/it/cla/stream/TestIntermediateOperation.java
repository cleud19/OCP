package it.cla.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestIntermediateOperation {

	/*
	 * Test sui stream
	 */
	public static void main(String[] args) {
		
		esempio1();
		System.out.println();
		esempio2();
		System.out.println();
		esempio3();
		System.out.println();
		esempio4();
		System.out.println();
		esempio5();
		System.out.println();
		/**
		try {
			//esempio6();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Errore il path descritto non è stato trovato!");
		}
		**/
		
		esempio7();
		
	}

	private static void esempio7() {
		Stream<Integer> s = Stream.of(1);
		IntStream is = s.mapToInt(x -> x);
		DoubleStream ds = s.mapToDouble(x -> x);
		IntStream s2 = ds.mapToInt(x -> (int)x);
		s2.forEach(System.out::print);

	}

	private static void esempio6() throws IOException {
		System.out.println("Esempio6:");
		Stream<String> parole = Files.lines(Paths.get("/Users/claudioiancu/git/OCP/Ocp/src/it/cla/stream/parole.txt"));
				parole
				.sorted()
				.filter( x -> x.length()>8)
				.forEach(System.out::println);
		
	}

	/*
	 * Qui abbiamo come intermediate operration il map 
	 * e come terminal operation il average che torna un solo valore che è la media
	 */
	private static void esempio5() {
		System.out.println("Esmpio5:");
		IntStream
		.range(2, 10)
		.map(x -> x*x)
		.average()
		.ifPresent(System.out::println);
		
	}

	private static void esempio4() {
		System.out.println("Esempio4:");
		Stream.of("Stefano","star","stuccilo","pepe","portop","pireolo","stambecco","circo","test")
		.filter(x -> x.startsWith("s"))
		.forEach(System.out::println);
	}

	private static void esempio3() {
		System.out.println("Esempio3:");
		Stream.of("alberto","alfredd","aereo")
		.sorted()
		.findFirst()
		.ifPresent(System.out::println);
	
		
	}

	private static void esempio2() {
		System.out.println("Esempio2:");
		System.out.println(
			IntStream
			.range(0, 4)
			.sum()
		);
	}

	/*
	 * Vediamo come esiste la classe IntStream che crea dei stream di integer In
	 * questo caso il nostro Intermediate Ioeration è skip mentre il Terminal
	 * Operation è il forEach
	 */
	private static void esempio1() {
		System.out.println("Esempio1:");
		IntStream.range(0, 10).skip(1).forEach(x -> System.out.print(x));
		System.out.println();
	}

}
