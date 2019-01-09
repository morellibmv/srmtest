package io.brunovargas.srm.enumeration;

public enum Risco {

	A(),B(10D),C(20D);
	
	private Double taxa;
	
	Risco(Double taxa){
		this.taxa = taxa;
	}
	
	Risco(){}

	public Double getTaxa() {
		return taxa;
	}
}
