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
public class MapEg {

	public static void main(String[] args) {

// map() method is used to perform/apply the operation on every element in sequence, which takes biconsumer. operation on specific element is not possible in map

//		 <R> Stream<R> map(Function<? super T, ? extends R> mapper);

//		@FunctionalInterface
//		public interface Function<T, R> {
//
//		    /**
//		     * Applies this function to the given argument.
//		     *
//		     * @param t the function argument
//		     * @return the function result
//		     */
//		    R apply(T t);
//		}

		List<Integer> marks = Arrays.asList(78, 80, 89, 90, 90, 91, 91, 93);
		marks.stream().map(mark -> mark + 2).forEach(mark -> System.out.println(mark));

		System.out.println("---------------- Appending after the strings ----------------");
		List<String> names = Arrays.asList("Daenerys", "Daemon", "Rheneyra", "Aegon 1");
		names.stream().map(name -> name + " Targaryen").forEach(name -> System.out.println(name));

		System.out.println("--------- Print even numbers and multiply with 2 -----------------");
		List<Integer> numbers = Arrays.asList(2, 3, 3, 4, 4, 5, 6, 7, 8, 9);
		List<Integer> evenlist = numbers.stream().filter(number -> number % 2 == 0).map(num -> num * 10)
				.collect(Collectors.toList());
		System.out.println(evenlist);

		System.out.println(
				"------------------ Print even numbers without duplicates and multiply with 2 -----------------");
		Set<Integer> evenlist1 = numbers.stream().filter(number -> number % 2 == 0).map(num -> num * 10)
				.collect(Collectors.toSet());
		System.out.println(evenlist1);

		System.out.println("----------- Append names--------------------");
		List<Dragons> dragons = Arrays.asList(new Dragons(101, "Vermithor", 120), new Dragons(102, "SilverWing", 100),
				new Dragons(103, "Vhagar", 180), new Dragons(104, "Balerion", 200));
		dragons.stream().map(s -> s.getName() + " Targaryens Dragon").forEach(name -> System.out.println(name));

		System.out.println("----------- Filter age >100 and every dragons increase age 2 years--------------------");
		dragons.stream().filter(i -> i.getAge() > 100).map(a -> {
			a.setAge(a.getAge() + 2);
			return a;
		}).forEach(e -> System.out.println(e));

		System.out.println("----------- Filter age <100 and every dragons and append names--------------------");
		dragons.stream().filter(i -> i.getAge() > 100).map(s -> {
			s.setName(s.getName() + "Dragons");
			return s;
		}).forEach(a -> System.out.println(a));
	}

}
