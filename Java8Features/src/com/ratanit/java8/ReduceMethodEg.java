package com.ratanit.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

/**
 * @author Manoj Kumar
 *
 */
public class ReduceMethodEg {

	public static void main(String[] args) {

//		reduce() method is to perform the operations on all elements return one value
//		 Optional<T> reduce(BinaryOperator<T> accumulator);
//		forEach(Consumer) :: accept(T)
//		forEach(BiConsumer) :: accept(t1,T2)
//		filter(predicate) :: test(T)
//        map(Function) :: apply(T)
//        reduce(Binary Operator) :: apply(T1,T2)

		List<Integer> prices = List.of(52, 53, 54, 59, 60);
		int result = prices.stream().reduce((i, j) -> i + j).get();
		System.out.println(result);

		List<String> names = Arrays.asList("Daemon", "Rhaeneyra", "Viserys", "Aegon", "Daenerys");
		String result1 = names.stream().filter(name -> (name.startsWith("D") || name.contains("e") )&& name.length() >=5 )
				.map(name -> name + "Targaryen").reduce((name1, name2) -> (name1 + name2) +"\n").get();
		System.out.println(result1);
		
		List<Integer> numbers = Arrays.asList(2,67,4,6,10,23,44);
		int total = numbers.stream().filter(num -> num < 10).map(num -> num*10).reduce((num1, num2) -> num1+num2).get();
		System.out.println(total);
		
	}

}
