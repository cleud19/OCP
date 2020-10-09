package it.cla.test.alvolo;

public class MainMadalin {

	public static void main(String[] args) {
	   //Classe.ClasseAstratta cicico =  ()->{(System.out.println("ciao")});
		Interfaccia c = ()->{System.out.println("ciao");};
		c.stampa();
		System.out.println(c.toString());

	}

}
