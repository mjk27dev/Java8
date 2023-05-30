package com.ratanit.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ForEacheg {
	
//	ForEach is used to print the collection data
	
	public static void main(String[] args) {
		
//		@FunctionalInterface
//		public void Interface Consumer<T, U>{
//			void accept (T t);
//		}
		
		List<String> dragons = Arrays.asList("Drogon", "Syrax", "Carxes", "Vhagar");
		dragons.forEach(dragon -> System.out.println(dragon));

		List<Integer> numbers = Arrays.asList(15, 29, 27, 98, 75);
		numbers.forEach(num -> System.out.println(num));

		List<Dragons> drag = Arrays.asList(new Dragons(101, "Drogon", 10), new Dragons(102, "Syrax", 35),
				new Dragons(103, "Caraxes", 70));
		drag.forEach(drags -> System.out.println(drags.getId() + " " + drags.getName() + " " + drags.getAge()));

		Set<String> colors = Set.of("Red", "Black", "Green", "Orange", "Yellow");
		colors.forEach(color -> System.out.println(color));

//		foreach for List and Set is Consumer interface
//		
//		default void forEach(Consumer<? super T> action) {
//	        Objects.requireNonNull(action);
//	        for (T t : this) {
//	            action.accept(t);
//	        }
//	    }

//		foreach for Map is BiConsumer interface
//		
//		 default void forEach(BiConsumer<? super K, ? super V> action) {
//	        Objects.requireNonNull(action);
//	        for (Map.Entry<K, V> entry : entrySet()) {
//	            K k;
//	            V v;
//	            try {
//	                k = entry.getKey();
//	                v = entry.getValue();
//	            } catch (IllegalStateException ise) {
//	                // this usually means the entry is no longer in the map.
//	                throw new ConcurrentModificationException(ise);
//	            }
//	            action.accept(k, v);
//	        }
//	    }
		
//		@FunctionalInterface
//		public void Interface BiConsumer<T, U>{
//			void accept (T t, U u);
//		}
		
		Map<Integer, String> wordcount = Map.of(1, "Red", 2, "Green", 3, "Black");
		wordcount.forEach((k, v) -> System.out.println("Key is: " + k + " Value is: " + v));

		Map<String, Integer> wordcount1 = Map.of("Red", 1, "Green", 2, "Black", 3);
		wordcount1.forEach((k, v) -> System.out.println("Key is: " + k + " Value is: " + v));

		Map<Integer, Dragons> drogon = Map.of(1, new Dragons(201, "Rhaegal", 10), 2, new Dragons(202, "Vhagar", 180));
        drogon.forEach((k,v) -> System.out.println("Key is: "+ k + " Value is: "+v.getId()+" "+ v.getName()+" "+ v.getAge()));
	
	}
}
