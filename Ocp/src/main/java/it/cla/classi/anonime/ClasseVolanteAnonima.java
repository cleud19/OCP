package it.cla.classi.anonime;

public class ClasseVolanteAnonima {
	public static void main(String[] args) {
		Volante ufo = new Volante() {
			
			@Override
			public void plana() {
				System.out.println("Sto planando!");
				
			}
			
			@Override
			public void decolla() {
				System.out.println("Sto decollando!");
				
			}
			
			@Override
			public void atterra() {
				System.out.println("Sto atterrando!");
				
			}
		};
		ufo.decolla();
		ufo.plana();
		ufo.atterra();
	}
}
