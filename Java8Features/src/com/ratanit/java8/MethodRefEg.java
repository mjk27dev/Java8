package com.ratanit.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Manoj Kumar
 *
 */
public class MethodRefEg {

//	Method reference is a short form of lambda expression. Special type of lambda expression
//	Method reference uses :: symbol

	public static List<Integer> StringNumToIntNum(List<String> stringnumbers) {

		return stringnumbers.stream().map(Integer::valueOf).collect(Collectors.toList());

	}

	public static List<Integer> stringLength(List<String> names1) {

		return names1.stream().map(String::length).collect(Collectors.toList());
	}

	public static List<String> stringUpperCase(List<String> lowerCaseNames) {

		return lowerCaseNames.stream().map(String::toUpperCase).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		List<String> names = List.of("", "Daenerys", "Rhaegar", "Viserys", "", "Aerys", "Aegon", "");
		System.out.println("------for each without method referncing----------");
		names.forEach(name -> System.out.println(name));

		System.out.println("-------Method Referencing--------");
		names.forEach(System.out::println);

		List<Employee> emp = List.of(new Employee(101, "Manoj", 70000.00,30), new Employee(102, "Vignesh", 60000.00,30),
				new Employee(103, "Ayumi", 100000.00,20), new Employee(104, "Zero", 25000.00,40),
				new Employee(104, "Dante", 20000.00,20));
		emp.forEach(e -> System.out.println(e.toString()));

//		Note: When we print reference variable it automatically calls toString()

		System.out.println("-------Print using Method Referencing--------");
		emp.forEach(System.out::println);

		Long count = names.stream().filter(name -> !name.isEmpty()).count();
		System.out.println("The Count names present without empty names" + count);

		Long count1 = names.stream().filter(String::isEmpty).count();
		System.out.println("The Count empty:" + count1);

		System.out.println("------------Filter Salary more than 25000--------------");
		emp.stream().filter(emps -> emps.getEsal() > 25000)
				.forEach(em -> System.out.println(em.getEid() + " " + em.getEname() + " " + em.getEsal()));

		System.out.println("------------");

		System.out.println("------------Filter Salary more than 25000 using Method reference--------------");
		emp.stream().filter(Employee::salaryCheck).forEach(System.out::println);

		System.out.println("-----------Filter the names using Method reference------------");
		List<Employee> empList = emp.stream().filter(Employee::nameCheck).collect(Collectors.toList());
		empList.forEach(System.out::println);

		System.out.println("---------Method Reference using Map----------");
//		Apply Operations on all elements in a sequence

		List<String> stringnumbers = Arrays.asList("1", "2", "3", "4", "5");
		List<Integer> intNumbers = MethodRefEg.StringNumToIntNum(stringnumbers);
		System.out.println(intNumbers);

		List<String> names1 = Arrays.asList("Daenerys", "Drogo", "Rhaegar", "Aegon", "Targaryen");
		List<Integer> length = MethodRefEg.stringLength(names1);
		System.out.println(length);

		List<String> lowerCaseNames = Arrays.asList("daenerys", "drogo", "rhaegar", "aegon", "targaryen");
		List<String> upperCaseNames = MethodRefEg.stringUpperCase(lowerCaseNames);
		System.out.println(upperCaseNames);

		// Method referencing using custom methods
		List<Person> person = Arrays.asList(new Person("Ayumi", 20), new Person("Zero", 35), new Person("Cereza", 6),
				new Person("Jaenne", 20));
		person.stream().map(Person::newAge).forEach(age -> System.out.println(age));

		System.out.println("--------Method Reference with reduce method--------------");

		List<Integer> numbers = Arrays.asList(2, 6, 7, 8, 9);
		int results = numbers.stream().reduce((x, y) -> x * y).get();
		System.out.println("product of digits: " + "\n" + results);

		System.out.println("The Sum of all elements:");
		numbers.stream().reduce(Integer::sum).ifPresent(System.out::println);

		System.out.println("The min of all elements:");
		numbers.stream().reduce(Integer::min).ifPresent(System.out::println);

		System.out.println("The max of all elements:");
		numbers.stream().reduce(Integer::max).ifPresent(System.out::println);

		System.out.println("----------String Concatenation-------");
		names1.stream().reduce(String::concat).ifPresent(System.out::println);

		List<String> fruits = Arrays.asList("", "Apple", "Orange", "Grapes", "", "Pomogranate", "Banana", "Lemon");
		fruits.stream().filter(Predicate.not(String::isEmpty)).map(String::length).reduce(Integer::sum)
				.ifPresent(System.out::println);
		
		emp.stream().filter(Employee::salaryCheck).map(Employee::addSalary).reduce(Double::sum).ifPresent(System.out::println);
		
		
		
	}

}
