package it.cla.esercitazione0;

import java.util.concurrent.*;
import java.util.stream.*;

/*
 * EserCizio Executor
 * Il programma non termina mai poiche ho instanziato una cyclic barrier da 3 thread e io ho solo 2 thread
 */
public class A1Executors {

	public static void await(CyclicBarrier cb) {
		try {
			cb.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// Handle exception
		}
	}

	public static void main(String[] args) {
		System.out.println("Inizio del metodo");
		final CyclicBarrier cb = new CyclicBarrier(3, () -> System.out.println("Clean!"));// u1
		System.out.println("Ho creato il mio cyclic barrrier da 3");
		ExecutorService service = Executors.newScheduledThreadPool(2);
		System.out.println("Creo il mio executor da 2 thread!");
		IntStream.iterate(1, i -> 1) // u2
				
				.limit(12).forEach
					(i -> 
						{
							System.out.println(i);
							service.submit(() -> await(cb));
						}
					); 
		service.shutdown();
	}
}