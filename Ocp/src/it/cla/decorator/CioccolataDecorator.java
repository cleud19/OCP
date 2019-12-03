package it.cla.decorator;

public class CioccolataDecorator  extends BevandaDecorator{

	BevandaComponent bevanda;
	
	public CioccolataDecorator(BevandaComponent component) {
		this.bevanda=component;
	}
	@Override
	public double prezzo() {
		
		return bevanda.prezzo()+2;
	}

}
