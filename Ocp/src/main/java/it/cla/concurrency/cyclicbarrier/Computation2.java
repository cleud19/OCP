package it.cla.concurrency.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class Computation2 implements Runnable {
	public static int sum = 0;

	public void run() {
		// check if newBarrier is broken or not
		System.out.println("Is the barrier broken? - " + Tester.newBarrier.isBroken());
		sum = 10 + 20;
		try {

			System.out.println("Nel Computation2 prima del await   Number of parties waiting at the barrier "
					+ "at this point = " + Tester.newBarrier.getNumberWaiting());

			Tester.newBarrier.await(3000, TimeUnit.MILLISECONDS);

			System.out.println("Nel Computation2 dopo del await   Number of parties waiting at the barrier "
					+ "at this point = " + Tester.newBarrier.getNumberWaiting());

			// number of parties waiting at the barrier
			System.out.println("Number of parties waiting at the barrier " + "at this point 2 = "
					+ Tester.newBarrier.getNumberWaiting());
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

}
