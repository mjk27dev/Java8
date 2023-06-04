package com.ratanit.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortWithMethodRef {

	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Ayumi", "Jill", "Sheva", "Cerza");
//		Collections.sort(names);
//		names.sort((i,j) -> i.compareTo(j));
		names.sort(String::compareTo);
		System.out.println(names);
		
		List<Integer> num = Arrays.asList(1,7,8,9,5,3,4);
		num.sort(Integer::compareTo);
		System.out.println(num);

		System.out.println("-------sort by id using Collections.sort() --------");
		List<Product> product = Arrays.asList(new Product(1, "Chair", 100), 
				new Product(2, "Table", 200), new Product(3, "Bike", 65000), new Product(4, "Car", 300000));
		Collections.sort(product,Comparator.comparingInt(Product::getPid));
		product.forEach(System.out::println);
		
		System.out.println("-------sort by Name using List.Sort()--------");
		product.sort(Comparator.comparing(Product::getPname));
		product.forEach(System.out::println);
		
		System.out.println("-------sort by Name Descending order using List.Sort()--------");
		product.sort(Comparator.comparing(Product::getPname).reversed());
		product.forEach(System.out::println);
		
		System.out.println("-------sort by Cost using Stream.sorted()--------");
		product.stream().sorted(Comparator.comparing(Product::getPcost)).forEach(System.out::println);
		
		System.out.println("-------sort by Cost using Stream.sorted() descending order--------");
		product.stream().sorted(Comparator.comparing(Product::getPcost).reversed()).forEach(System.out::println);
		
		num.stream().sorted(Integer::compareTo).forEach(System.out::println);
	}

}
