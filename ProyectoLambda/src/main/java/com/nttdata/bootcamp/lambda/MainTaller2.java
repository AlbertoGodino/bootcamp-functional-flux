package com.nttdata.bootcamp.lambda;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

enum Tax {
	
	SUPERREDUCED(4), REDUCED(10), NORMAL(21);

	public int percent;

	private Tax(int percent) {
	this.percent = percent;
	}



	public int getPercent() {
	return percent;
	}

}

public class MainTaller2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Product> shoppingCart = List.of(

				new Product("Clothes", new BigDecimal("15.90"), Tax.NORMAL),
				new Product("Bread", new BigDecimal("1.5"), Tax.SUPERREDUCED),
				new Product("Meat", new BigDecimal("13.99"), Tax.REDUCED),
				new Product("Cheese", new BigDecimal("3.59"), Tax.SUPERREDUCED),
				new Product("Coke", new BigDecimal("1.89"), Tax.REDUCED),
				new Product("Whiskey", new BigDecimal("19.90"), Tax.NORMAL));


		// Calcular el coste total de la compra, incluyendo los impuestos
//		Long count = shoppingCart.stream().map(mapper).count();
		
		BigDecimal result = shoppingCart.stream().
		map(product -> product.price.add(product.price.multiply(new BigDecimal(product.tax.percent).divide(new BigDecimal(100))))).
		reduce(BigDecimal.ZERO, (x , y) -> x.add(y));
		
		System.out.println("Valor " + result.toString());
		
		// Listamos todos los productos que empiezan por "C"
		String result2 = shoppingCart.stream()
				.filter(product -> product.name.startsWith("C"))
				.map(product -> product.name)
				.collect(Collectors.joining(", ", "Resultado: ", ". "));
		
		System.out.println("Valor2 " + result2.toString());

	}

}
