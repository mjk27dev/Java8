package com.ratanit.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamsEg {

//	Sequential Streams all the threads runs only in one core all the other cores are idle and parallel streams run on different threads will run in different cores  

	public static void main(String[] args) {
		List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9);
		numbers.stream().forEach(System.out::print);
		
		System.out.println("---------------");
		
		numbers.parallelStream().forEach(System.out::print);

//		multiple cores running so the process is increased in parallel streams
//		Sequential streams are in the pipeline will have one single resource running multiple threads in a single core 
//		on the other hand parallel streams runs different threads in different cores
		
		System.out.println("-------------------");
		long start = System.currentTimeMillis();
		List<Integer> even = numbers.stream().filter(n-> n%2 == 0).collect(Collectors.toList());
		
		
		long end = System.currentTimeMillis();
		System.out.println("Sequential tream time is: " +(end - start));
		
		long start1 = System.currentTimeMillis();
		List<Integer> evendata = numbers.parallelStream().filter(num-> num%2 == 0).collect(Collectors.toList());
		
		long end1 = System.currentTimeMillis();
		System.out.println("Parallel tream time is: " +(end1 - start1));
		
		List<Employee> emps = Arrays.asList(new Employee(1, "Manoj", 90000.00, 30), new Employee(2, "Vignesh", 60000.00,30), 
				new Employee(3, "Ayumi", 70000.00,20), new Employee(4, "Michele", 50000.00 , 20));
		
		long start2 = System.currentTimeMillis();
		emps.stream().sorted(Comparator.comparing(Employee::getEname)).forEach(System.out::println);
		
		long end2 = System.currentTimeMillis();
		System.out.println("Sequential Stream sorting time: " +(end2-start2));
		
		long start3 = System.currentTimeMillis();
		emps.parallelStream().sorted(Comparator.comparing(Employee::getEname)).forEach(System.out::println);
		
		long end3 = System.currentTimeMillis();
		System.out.println("Parallel Stream sorting time: " +(end3-start3));
		
		double avg = emps.parallelStream().mapToInt(Employee::getAge).average().getAsDouble();
		System.out.println(avg);
	}

}
