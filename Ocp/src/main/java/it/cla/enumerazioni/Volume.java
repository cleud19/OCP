package it.cla.enumerazioni;

public enum Volume {
	BASSO,MEDIO,ALTO;
	
	public void getLivello() {
		System.out.println("Livello: "+ this.ordinal());
	}
}
