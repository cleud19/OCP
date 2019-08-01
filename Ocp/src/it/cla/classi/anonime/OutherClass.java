package it.cla.classi.anonime;
import it.cla.classi.anonime.SuperClasse;

public class OutherClass {
	private String messaggio="Nella classe ";
	
	/**
	 * Vediamo come per scrivere una classe anonima va sovrascritta una classe esistente
	 */
	SuperClasse sc = new SuperClasse() {
		@Override
		public void metodo() {
			System.out.println(messaggio + "anonime");
		}
	};
	
	public static void main(String[] args) {
		OutherClass outher =  new OutherClass();
		outher.sc.metodo();
	}
}
