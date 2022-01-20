package com.nttdata.bootcamp.reactor;

import reactor.core.publisher.Flux;

public class ExcerciseReactor {

	public static void main(String[] args) {
		
		// Creamos un objeto Publisher que emite 3 mensajes de texto
		Flux<String> messageSender = Flux.just("mensaje 1", "Mensaje 2", "Mensaje 3");
		
		// Creamos 2 objetos consumer que cuando reciben el evento, los muestran por pantalla.
//		messageSender.subscribe(message -> System.out.println("Observer 1. Recivido: " + message));
//		messageSender.subscribe(message -> System.out.println("Observer 2. Recivido: " + message));
		
		
		// Ejemplo que muestra los mensajes y se para al final del último.
		messageSender.doOnNext((element) -> {
			System.out.println(element);
		}).blockLast();
		
		// Ejemplo que muestra los mensajes y se para después del primero.
		messageSender.doOnNext((element) -> {
			System.out.println(element);
		}).blockFirst();

	} // Fin del main

} // Fin de la clase
