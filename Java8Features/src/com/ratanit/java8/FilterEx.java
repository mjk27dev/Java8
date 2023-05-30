package com.ratanit.java8;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author Manoj Kumar
 *
 */

public class FilterEx {

//	filter() method - used to filter the data based on the condition

	public static void main(String[] args) {

		System.out.println("-------Filter the even data --------");
		List<Integer> nums = Arrays.asList(5, 7, 9, 10, 59, 68, 70, 70, 35, 68);
		nums.stream().filter(i -> i % 2 == 0).forEach(num -> System.out.println(num));

		System.out.println("-------Filter the even data and collect as list --------");
		List<Integer> even = nums.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println(even);

		System.out.println("-------Filter the even data and collect as set --------");
		Set<Integer> evenset = nums.stream().filter(i -> i % 2 == 0).collect(Collectors.toSet());
		System.out.println(evenset);

		System.out.println("-------Filter the even data: count the number of elements--------");
		Long count = nums.stream().filter(i -> i % 2 == 0).count();
		System.out.println(count);

		System.out.println("-------Filter the even data: find the first element--------");
		int number = nums.stream().filter(i -> i % 2 == 0).findFirst().get();
		System.out.println(number);

		System.out.println("-------Filter the even data: find the specific element--------");
		int number1 = nums.stream().filter(i -> i % 2 == 0).skip(3).findFirst().get();
		System.out.println(number1);

		System.out.println("-------Filter the name starts with V--------");
		List<String> names = Arrays.asList("Drogon", "Syrax", "Caraxes", "Vhagar", "Sunfyre", "Dreamfyre", "Vermithor",
				"Caraxes", "Vhagar", "Vermithor");
		List<String> name = names.stream().filter(i -> i.startsWith("V")).collect(Collectors.toList());
		System.out.println(name);

		System.out.println("-------Filter the name starts with V and length is equal to 6--------");
		List<String> name1 = names.stream().filter(i -> i.startsWith("V") && i.length() == 6)
				.collect(Collectors.toList());
		System.out.println(name1);

		System.out.println("-------Filter the name starts with V and print as set--------");
		Set<String> name2 = names.stream().filter(i -> i.startsWith("V")).collect(Collectors.toSet());
		System.out.println(name2);
		
		System.out.println("-------Filter the name starts with V print the count of the elements--------");
		Long count1 = names.stream().filter(i -> i.startsWith("V")).count();
		System.out.println(count1);

		
		List<Dragons> dragons = Arrays.asList(new Dragons(101, "Drogon", 10), new Dragons(102, "Syrax", 35),
				new Dragons(103, "Caraxes", 70), new Dragons(104, "Vermithor", 120), new Dragons(105, "Vhagar", 180));

		System.out.println("----------Filter the data and print the data -------------");
		dragons.stream().filter(d -> d.getName().startsWith("V"))
				.forEach(d -> System.out.println(d.getId() + " " + d.getName() + " " + d.getAge()));

		System.out.println("----------Filter the data and print the data age more than 50 in list Format ------------");
		List<Dragons> draglist = dragons.stream().filter(d -> d.getAge() > 50).collect(Collectors.toList());
		draglist.forEach(d -> System.out.println(d.getId() + " " + d.getName() + " " + d.getAge()));

		System.out.println("----------Filter the data and print the data age more than 50 in Set Format ------------");
		Set<Dragons> dragset = dragons.stream().filter(d -> d.getAge() > 50).collect(Collectors.toSet());
		dragset.forEach(d -> System.out.println(d.getId() + " " + d.getName() + " " + d.getAge()));

		System.out.println("----------Filter the data and print the data and find the first element------------");
		Dragons d = dragons.stream().filter(f -> f.getAge() > 50).findFirst().get();
		System.out.println(d.getId() + " " + d.getName() + " " + d.getAge());

		System.out.println("----------Filter the data and print the data and find the first element or returns null------------");
		Dragons d1 = dragons.stream().filter(f -> f.getAge() > 200).findFirst().orElse(null);
		if (d1 != null) {
			
			System.out.println(d1.getId() + " " + d1.getName() + " " + d1.getAge());
		} 
		else {
			
			System.out.println(d1);
		}
		
		System.out.println("----------Filter the data and print the data and find the specific element------------");
		Dragons d2 = dragons.stream().filter(f -> f.getAge() > 50).skip(2).findFirst().get();
		System.out.println(d2.getId() + " " + d2.getName() + " " + d2.getAge());

	}

}
