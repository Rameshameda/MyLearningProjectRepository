package com.example.demo;

import java.util.Collections;
import java.util.HashSet;

public class TestDuplicate {
public static void main(String[] args) {
	HashSet<Person> persons = new HashSet<Person>();
	persons.add(new Person(1, "Ramesh", "Meda"));
	persons.add(new Person(2, "Arjun", "Meda"));
	persons.add(new Person(3, "Praveen", "Meda"));
	persons.add(new Person(4, "Srilakshmi", "Bysani"));
	persons.add(new Person(5, "Chubby", "Meda"));
	persons.add(new Person(5, "Chubby", "Meda"));
	System.out.println(persons.size());
	System.out.println(persons);
}
}
