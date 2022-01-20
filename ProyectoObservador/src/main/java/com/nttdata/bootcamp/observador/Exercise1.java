package com.nttdata.bootcamp.observador;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Exercise1 {

	public static void main(String[] args) {
		
		// Creamos el objeto observable que emite 3 mensajes de texto
		Observable<String> messageSender = Observable.just("Mensaje 1", "Mensaje 2", "Mensaje 3");
		
		
		// Creo el primer objeto observer (observador), que cuando recebe el mensaje, lo presenta por pantalla
		Observer<String> observer1 = new Observer<String>() {

			@Override
			public void onSubscribe(Disposable d) {
				System.out.println("Observer 1. Subscribed.");				
			}

			@Override
			public void onNext(String s) {
				System.out.println("Observer 1. Received: " + s);
			}

			@Override
			public void onError(Throwable e) {
				System.out.println("Observer 1. Error: " + e.getMessage());				
			}

			@Override
			public void onComplete() {
				System.out.println("Observer 1. Completed.");				
			}
			
		};
		
		// Creo el segundo objeto observer (observador), que cuando recebe el mensaje, lo presenta por pantalla
		Observer<String> observer2 = new Observer<String>() {

			@Override
			public void onSubscribe(Disposable d) {
				System.out.println("Observer 2. Subscribed.");
			}

			@Override
			public void onNext(String s) {
				System.out.println("Observer 2. Received: " + s);
			}

			@Override
			public void onError(Throwable e) {
				System.out.println("Observer 2. Error: " + e.getMessage());
			}

			@Override
			public void onComplete() {
				System.out.println("Observer 2. Completed.");
			}

		};
				
		// Subscribimos ambos observers (observadores) al objeto observable y comprobamos que se presentan en pantalla los mensajes
		// emitidos por dublicado
		messageSender.subscribe(observer1);
		messageSender.subscribe(observer2);
				

	} // Fin del método máin

}// Fin de la clase
