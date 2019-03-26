package com.example.my;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsIntermediatoryOprations {
	public static void main(String[] args) {
		Stream<Integer>  stream = Stream.of(1, 2, 3, 4);


		Stream<String> streamString = Stream.of("Peanut Butter Cookies",
				"Oatmeal-Raisin Cookies", "Basic Chocolate Chip Cookies");

		boolean containCookies = streamString.allMatch(p -> p.contains("Cookies"));

		stream = Stream.of(1, 2, 3, 4);  
		stream.filter(p -> p.intValue() < 4)
		.forEach(i -> System.out.println(i));
		System.out.println("--------------------");

		stream = Stream.of(1, 2, 3, 4);
		stream.map(m -> m )
		.forEach(i -> System.out.println(i));
		System.out.println("--------------------");

		stream = Stream.of(1, 2, 3, 4);
		stream.peek(m -> System.out.println(m) )
		.forEach(i -> System.out.println(i));
		System.out.println("--------------------");

		stream = Stream.of(5, 6, 6, 6, 3, 2, 2);
		System.out.println( stream.distinct().collect(Collectors.toList()));
		System.out.println("--------------------");

		List<String> vals = Stream.of("limit", "by", "two","limit1", "by1", "two1").limit(5)
				.collect(Collectors.toList());
		System.out.println(vals);
		System.out.println("--------------------");

		//terminal oprations
		OptionalInt vals1 = IntStream.of(5, 6, 6, 6, 3, 2, 2, 5).reduce((a,b) -> a+b);
		//.collect(Collectors.toList());
		System.out.println(vals1);



	}
}
