package com.ratanit.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Manoj Kumar
 *
 */
public class SortingEg {

//	Data Sorting Operations follows 2 rules 
//	1.Data must be homogeneous
//	2. implements comparable interface
//	In Java only String, All wrapper classes are implements comparable.
//	Sorting is done by compareTo() method, compareTo() will compare the 2 objects return int value.
//    3 Ways sorting
//    Collections.sort();
//    list.sort();
//    stream.sorted(); - we can filter, map and sort it

	public static void main(String[] args) {

		// 1st Approach Collections.sort()
		System.out.println("----------- 1st approach Collections.sort()--------------");
		List<String> names = Arrays.asList("Daenerys", "Rhaenyra", "Daemon", "Aegon");
		Collections.sort(names);
		System.out.println(names);

		// for custom sort we use comparator
		Collections.sort(names, Comparator.reverseOrder());
		System.out.println(names);

		// 2nd Approach list.sort()
		System.out.println("----------- 2nd approach list.sort()--------------");

		names.sort((name1, name2) -> name1.compareTo(name2));
		System.out.println("The Ascending order: " + names);

		names.sort((name1, name2) -> -name1.compareTo(name2));
		System.out.println("The Descending order: " + names);

		// 3rd Approach stream.sorted()
		System.out.println("----------- 3rd approach stream.sorted()--------------");

		List<String> newNames = Arrays.asList("Aegon", "Rhenys", "Visenya", "Jaeherys", "Alyssane");
		System.out.println("The Ascending order:");
		newNames.stream().sorted().forEach(name -> System.out.println(name));

		System.out.println("The Descending order:");
		newNames.stream().sorted((name1, name2) -> -name1.compareTo(name2)).forEach(name -> System.out.println(name));

		System.out.println("--------Sort the name starts with A-----------");
		newNames.stream().filter(n -> n.startsWith("A")).sorted().forEach(name -> System.out.println(name));

		List<Integer> numbers = Arrays.asList(5, 4, 3, 7, 8, 23, 24, 45, 67);
		Collections.sort(numbers);
		System.out.println(numbers);
		Collections.sort(numbers, Comparator.reverseOrder());
		System.out.println(numbers);

		numbers.sort((num1, num2) -> num1.compareTo(num2));
		System.out.println(numbers);

		numbers.sort((num1, num2) -> -num1.compareTo(num2));
		System.out.println(numbers);

		numbers.stream().sorted().forEach(num -> System.out.println(num + " "));
		numbers.stream().sorted((num1, num2) -> -num1.compareTo(num2)).forEach(n -> System.out.println(n + " "));

		numbers.stream().filter(n -> n < 10).map(n -> n * 10).sorted((num1, num2) -> -num1.compareTo(num2))
				.forEach(num1 -> System.out.println(num1 + " "));

		System.out.println("----------- Sort based on List.sort()---------------");

		List<Dragons> dragons = Arrays.asList(new Dragons(101, "Caraxes", 70), new Dragons(102, "Syrax", 90),null,
				new Dragons(103, "Melys", 90), new Dragons(104, "Vermithor", 120), new Dragons(105, "Vhagar", 180),
				new Dragons(106, "Balerion", 200));

//		System.out.println("------------- Sort based on name: ----------------");
//		dragons.sort((d1, d2) -> d1.getName().compareTo(d2.getName()));
//		dragons.forEach(d -> System.out.println(d));
//		
//		System.out.println("---------- Sort based on id:--------------");
//		dragons.sort((d1, d2) -> d1.getId().compareTo(d2.getId()));
//		dragons.forEach(d -> System.out.println(d));

		System.out.println("----------- Sort based on stream---------------");
		
		// filter the null using filter operation and will not threo nul pointer exception
		
		dragons.stream().filter(dragon -> dragon != null).filter(d1 -> d1.getAge() > 100).sorted((d1, d2) -> d1.getAge().compareTo(d2.getAge()))
				.forEach(e -> System.out.println(e));

	}

}
