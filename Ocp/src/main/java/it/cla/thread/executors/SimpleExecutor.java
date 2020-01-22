package it.cla.thread.executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SimpleExecutor {
	/*
	 *  An ExecutorService provides two methods for that purpose: 
	 *  shutdown() waits for currently running tasks to finish while 
	 *  shutdownNow() interrupts all running tasks and shut the executor down immediately.
	 */
	static ExecutorService executor = Executors.newSingleThreadExecutor();
	
	public static void main(String[] args) {
		//simpleExecutorTest();
		//futureTest();
		invokeAllTest();

	}

	
	public static void simpleExecutorTest(){
		executor.submit(() -> {
		    String threadName = Thread.currentThread().getName();
		    System.out.println("Hello " + threadName);
		});
	}
	
	public static void futureTest(){
		/*
		 * Submit() doesn't wait until the task completes, the executor service cannot return the result of the callable directly.
		 * Instead the executor returns a special result of type Future
		 * which can be used to retrieve the actual result at a later point in time.
		 */
		Future<Integer> future = executor.submit(()-> {
			System.out.println("Inizio metodo runnable prima del sleep");
			TimeUnit.SECONDS.sleep(3);
			System.out.println("Fine metodo runnable prima del sleep");
			return 123;
		});

		System.out.println("future done? " + future.isDone());

		Integer result=0;
		
		try {
			/**
			 * Calling the method get() blocks the current thread and waits until the callable 
			 * completes before returning the actual result 123.
			 * In the worst case a callable runs forever,  so we can simply counteract those scenarios by passing a timeout:
			 */
			//result = future.get();
			result = future.get(1,TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			System.out.println("TimeoutException lanciata il get è andato in errore dopo aver aspettato 1 secondo. Il thread andrà avanti.");
		}

		System.out.println("future done? " + future.isDone());
		System.out.println("result: " + result);
	}

	public static void invokeAllTest(){
		ExecutorService executor = Executors.newWorkStealingPool();

		List<Callable<String>> callables = Arrays.asList(
		        () -> "task1",
		        () -> "task2",
		        () -> "task3");

		try {
			/**
			 * This method accepts a collection of callables and returns a list of futures.
			 */
			executor.invokeAll(callables)
			    .stream()
			    .map(future -> {
			        try {
			            return future.get();
			        }
			        catch (Exception e) {
			            throw new IllegalStateException(e);
			        }
			    })
			    .forEach(System.out::println);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
