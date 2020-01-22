package it.cla.concurrency.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;

class Computation1 implements Runnable {
	public static int product = 0;

	public void run() {
		product = 2 * 3;
		try {

			System.out.println("Nel Computation1 prima del await   Number of parties waiting at the barrier "
					+ "at this point = " + Tester.newBarrier.getNumberWaiting());

			Tester.newBarrier.await();

			System.out.println("Nel Computation1 dopo del await   Number of parties waiting at the barrier "
					+ "at this point = " + Tester.newBarrier.getNumberWaiting());

		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
