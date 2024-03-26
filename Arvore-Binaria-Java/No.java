package lab.exxxx;

public class No<T extends Comparable<T>> {

	T valor;
	No<T> esquerda;
	No<T> direita;
	
	
	public No(T valor) {
		this.valor = valor;
		esquerda = direita = null;
		
	}
}
