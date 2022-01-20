package com.nttdata.bootcamp.lambda;

import java.util.List;

public class Functional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> numbers = List.of(18, 6, 4, 15, 55, 78, 12, 9, 8);
		
		// Te cuenta todos los elementos mayores que 10
		Long count = numbers.stream().filter(num -> num > 10).count();
		
		// Te va mostrando los elementos mayores que 10 y luego imprime el número total
		Long count2 = numbers.stream().filter(num -> num > 10).peek(num -> System.out.println(num)).count();
		
		System.out.println(count);

	}

}
