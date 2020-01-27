package it.cla.concurrency.cyclicbarrier;

import java.util.stream.IntStream;

public class SampleCycleBarrierMain {

	public static void main(String[] args) {
		IntStream.iterate(1, i-> 1) 
		.limit(12).forEach(System.out::println); 

	}

}
