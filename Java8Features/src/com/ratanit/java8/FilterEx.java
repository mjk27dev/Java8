package com.ratanit.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FilterEx {

//	filter() method - used to filter the data based on the condition
	
	public static void main(String[] args) {
	
		System.out.println("-------Filter the even data --------");
		List<Integer> nums = Arrays.asList(5,7,9,10,59,68,70,70,35,68);
		nums.stream().filter(i-> i%2 ==0).forEach(num->System.out.println(num));
		
		System.out.println("-------Filter the even data and collect as list --------");
		List<Integer> even = nums.stream().filter(i-> i%2 ==0).collect(Collectors.toList());
		System.out.println(even);
		
		
		System.out.println("-------Filter the even data and collect as set --------");
		Set<Integer> evenset= nums.stream().filter(i-> i%2 ==0).collect(Collectors.toSet());
		System.out.println(evenset);
		
		System.out.println("-------Filter the even data: count the number of elements--------");
		Long count = nums.stream().filter(i -> i%2==0).count();
		System.out.println(count);
		
		System.out.println("-------Filter the even data: find the first element--------");
		int number = nums.stream().filter(i-> i%2 == 0).findFirst().get();
		System.out.println(number);
		
		System.out.println("-------Filter the even data: find the specific element--------");
		int number1 = nums.stream().filter(i-> i%2 == 0).skip(3).findFirst().get();
		System.out.println(number1);
		
		System.out.println("-------Filter the name starts with V--------");
		List<String> names = Arrays.asList("Drogon", "Syrax", "Caraxes", "Vhagar", "Sunfyre","Dreamfyre", "Vermithor","Caraxes","Vhagar","Vermithor");
		List<String> name = names.stream().filter(i -> i.startsWith("V")).collect(Collectors.toList());
	    System.out.println(name);
	    
	    System.out.println("-------Filter the name starts with V and length is equal to 6--------");
		List<String> name1 = names.stream().filter(i -> i.startsWith("V") && i.length()==6).collect(Collectors.toList());
	    System.out.println(name1);
	    
	    System.out.println("-------Filter the name starts with V and print as set--------");
		Set<String> name2 = names.stream().filter(i -> i.startsWith("V")).collect(Collectors.toSet());
	    System.out.println(name2);
	    
	}

}
