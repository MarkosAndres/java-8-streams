package com.markos.stream.streamdemo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApp {

	public static void main(String[] args) {
		String[] array = new String[]{"a", "b", "c"};
		Stream<String> stringStream1 = Arrays.stream(array);

		Stream<String> strinStream2 = Stream.of("a", "b", "c");
		strinStream2 = Stream.of(array);

		List<String> list = Arrays.asList(array);
		Stream<String> listStream = list.stream();


		// -------------------------------
		System.out.println(listStream.count());

		// -------------------------------

		boolean b1 = list.stream().anyMatch(element -> element.contains("a"));
		System.out.println(b1);

		// -------------------------------
		// FILTERING

		ArrayList<String> listFiltering = new ArrayList<>();
		listFiltering.add("One");
		listFiltering.add("OneAndOnly");
		listFiltering.add("Derek");
		listFiltering.add("Change");
		listFiltering.add("factory");
		listFiltering.add("justBefore");
		listFiltering.add("Italy");
		listFiltering.add("Italy");
		listFiltering.add("Thursday");
		listFiltering.add("");
		listFiltering.add("");

		int size = listFiltering.stream().filter(element -> element.contains("d")).collect(Collectors.toList()).size();
		System.out.println("size = " + size);

		// -------------------------------
		// MAPPING

		List<Detail> details = new ArrayList<>();
		details.add(new Detail("A"));
		details.add(new Detail("B"));

		Stream<String> detailsStream = details.stream().flatMap(d -> d.getParts().stream());
		System.out.println(detailsStream.collect(Collectors.toList()));

		// -------------------------------
		// MATCHING

		System.out.println("Match? " +
			listFiltering.stream().anyMatch(element -> element.contains("d"))
		);
	}
}

@Data
class Detail {
	private List<String> parts = new ArrayList<>();

	public Detail(String type) {
		parts.add(type + "1");
		parts.add(type + "2");
		parts.add(type + "3");
		parts.add(type + "4");
	}
}
