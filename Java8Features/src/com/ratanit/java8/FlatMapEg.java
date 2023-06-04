package com.ratanit.java8;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author Manoj Kumar
 *
 */

public class FlatMapEg {

	// To Convert a set of List, Set, Map into a Single List,Map,or set we use
	// Flatmap

	public static void main(String[] args) {
		List<List<Integer>> sublist = List.of(List.of(1, 2, 3, 4), List.of(5, 6, 7, 8));
		System.out.println(sublist);

		List<Integer> list = sublist.stream().flatMap(Collection::stream).collect(Collectors.toList());
		System.out.println(list);

		Set<Set<Integer>> subset = Set.of(Set.of(1, 2, 3, 4), Set.of(5, 6, 7, 8), Set.of(1, 3, 6, 8, 9));
		System.out.println(subset);

		Set<Integer> set = subset.stream().flatMap(Collection::stream).collect(Collectors.toSet());
		System.out.println(set);

		List<Map<Integer, String>> listMaps = List.of(Map.of(1, "a", 2, "b", 3, "c"),
				Map.of(11, "aa", 22, "bb", 33, "cc"), Map.of(111, "aaa", 222, "bbb", 333, "ccc"));

		System.out.println(listMaps);

		List<Entry<Integer, String>> mapList = listMaps.stream().flatMap(d -> d.entrySet().stream())
				.collect(Collectors.toList());
		System.out.println(mapList);

		List<EmployeeFlatMap> emps = List.of(new EmployeeFlatMap("Manoj", List.of(9791865929L, 9080353912L)),
				new EmployeeFlatMap("Vignesh", List.of(9677812957L, 8072204483L)));

		List<List<Long>> phoneNo = emps.stream().map(e -> e.getPhones()).collect(Collectors.toList());
		System.out.println(phoneNo);

		List<Long> phoneNo1 = emps.stream().map(EmployeeFlatMap::getPhones).flatMap(Collection::stream)
				.collect(Collectors.toList());
		System.out.println(phoneNo1);
	}

}
