package it.cla.esercitazione0;

import java.io.*;
/*
 * Classe con diversi errori di compilazione 
 * 
 * 1 la classe InputStream non contiene il motodo getObject e anche se fosse prima di essere assegnato a vird va fatto il cast esplicito
 * 2  i vari oggetti stream lanciano eccezzioni di tipo IOException che vanno gestite
 * 3 infine vediamo come la classe bird contiene un parametro di tipo Tail che a sua volta non implementa seriazable quindi andrebbe in errore
 */
public class A2InputStream {

	public class Tail {
	}

	public class Bird implements Serializable {
		private String name;
		private transient int age;
		private Tail tail;

		public String getName() {
			return name;
		}

		public Tail getTail() {
			return tail;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setTail(Tail tail) {
			this.tail = tail;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public void main(String[] args) {
			 try(InputStream is = new ObjectInputStream(
			 new BufferedInputStream(new FileInputStream("birds.dat")))) {
			 Bird bird = is.readObject();
			}
		}
	}
}
