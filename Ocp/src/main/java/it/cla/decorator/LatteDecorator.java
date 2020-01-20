package it.cla.decorator;

public class LatteDecorator extends BevandaDecorator{

	BevandaComponent bevanda;
	
	public LatteDecorator(BevandaComponent component) {
		this.bevanda= component;
	}

	@Override
	public double prezzo() {
		return this.bevanda.prezzo()+1.5;
	}

	
}
