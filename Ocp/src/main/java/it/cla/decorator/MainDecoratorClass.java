package it.cla.decorator;

public class MainDecoratorClass {

	public static void main(String[] args) {

		CaffeConcreteComponent caffe = new CaffeConcreteComponent();
		System.out.println(caffe.prezzo());
		
		CioccolataDecorator caffeAlCioccolato = new CioccolataDecorator(caffe);
		System.out.println(caffeAlCioccolato.prezzo());
		
		LatteDecorator caffeAlCioccolatoELatte = new LatteDecorator(caffeAlCioccolato);
		System.out.println(caffeAlCioccolatoELatte.prezzo());

	}
}
