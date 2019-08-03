package it.cla.generics;

public class Generics {
	public static void main(String[] args) {
		ContenitoreGenerics<String> contenitore = new ContenitoreGenerics<String>();
		contenitore.setObject("Stringa");
		System.out.println(contenitore.getObject());
	}
	
	
	
}


class ContenitoreGenerics<T>{
	private T Object; 
	
	public T getObject() {
		return Object;
	}
	public void setObject(T object) {
		Object = object;
	}
}