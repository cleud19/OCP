package it.cla.enumerazioni;

public class TestEnum {

	public static void main(String[] args) {
		Volume vol = Volume.ALTO;
		vol.getLivello();
		
		switch (getLivello()) {
		case BASSO:
			Volume.BASSO.getLivello();
			break;

		default:
			break;
		}
		
		
	}

	public static Volume getLivello() {
		
		return Volume.BASSO;
	}
}
