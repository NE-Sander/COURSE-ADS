
public class Principal {

	public static void main(String[] args) {
		
	
		//exemplo de lista
		StaticList<Integer> lista1 = new StaticList<>(20);
		StaticList<Integer> lista2 = new StaticList<>(20);
		
		for(int i=0; i<5; i++)
			lista1.insert(((i)*3), i);
		
		for(int i=0; i<5; i++)
			lista2.insert(((i)), i);
			
		System.out.println("Lista 1 original:");
		System.out.println(lista1.toString());
		//System.out.println("Quantidade elementos na lista: " +lista1.numElements());
		
		//System.out.println("Quantidade de valores negativos: " + contaNegativos(lista1));
		
		//removePrimos(lista1);
		//System.out.println("Lista 1 sem os valores primos:");
		//System.out.println(lista1.toString());
		
		System.out.println("Lista 2 original:");
		System.out.println(lista2.toString());
		
		//System.out.println("Somatório de duas listas: " +exercicio4(lista1, lista2));
		
		System.out.println("Equals de lista: " + lista1.equals(lista1, lista1));
		
		System.out.println("Lista clonada:");
		System.out.println(lista1.clone());
		
		System.out.println("Lista 2 antes do split:");
		System.out.println(lista2.toString());
		System.out.println("Lista retorno split:");
		System.out.println(lista2.split(2));
		System.out.println("Lista 2 depois do split:");
		System.out.println(lista2.toString());
		
		/*
		Integer[] pares = new Integer[20];
		
		pares = evenNumbers(lista1);
		for(int i=0; i<pares.length; i++)
			System.out.println("Imprimindo array do exercício 1: " +pares[i]);
		
		
		StaticList<Character> lista2 = new StaticList<>(20);
		StaticList<Character> lista3 = new StaticList<>(20);
		StaticList<Character> listaretorno = new StaticList<>(20);
		
		lista2.insert('A',0);
		lista2.insert('B',1);
		lista2.insert('C',2);
		
		lista3.insert('D',0);
		lista3.insert('E',1);
		lista3.insert('F',2);
		
		
		System.out.println("Lista 2 original:");
		System.out.println(lista2.toString());
		
		System.out.println("Lista 3 original:");
		System.out.println(lista3.toString());
		
		
		listaretorno = (StaticList<Character>) mergeLists(lista2, lista3);
		
		System.out.println("Lista retorno depois do merge:");
		System.out.println(listaretorno.toString());
		
		
		
		StaticList<Double> lista4 = new StaticList<>(20);
		StaticList<Double> lista5 = new StaticList<>(20);
		
		lista4.insert(4.5,0);
		lista4.insert(4.4,0);
		lista4.insert(4.3,0);
		
		lista5.insert(3.7,0);
		lista5.insert(8.2,0);
		lista5.insert(9.0,0);
		
		
		System.out.println("Lista 4 original:");
		System.out.println(lista4.toString());
		
		System.out.println("Lista 5 original:");
		System.out.println(lista5.toString());
		
		prependList(lista4, lista5);
		
		
		System.out.println("Lista 4 depois da chamdda do método:");
		System.out.println(lista4.toString());
		
		System.out.println("Lista 5 depois da chamada do método:");
		System.out.println(lista5.toString());*/
		
	}
	
	
	public static Integer[] evenNumbers(List<Integer> lista) {
		Integer[] retorno = new Integer[lista.numElements()];
		int cont = 0;
		
		for(int i=0; i<lista.numElements(); i++)
			if(lista.get(i) % 2 == 0)
				retorno[cont++] = lista.get(i);
		
		return retorno;
	}
	
	public static List<Character> mergeLists(List<Character> t1, List<Character> t2) throws OverflowException, IndexOutOfBoundsException{
		List<Character> retorno = new StaticList<>(t1.numElements() + t2.numElements());
		
		int contT1 = 0, contT2 = 0;
		
		while(true) {
			if(contT1 < t1.numElements())
				retorno.insert(t1.get(contT1++), retorno.numElements());
			
			if(contT2 < t2.numElements())
				retorno.insert(t2.get(contT2++), retorno.numElements());
			
			if(contT1 >= t1.numElements() && contT2 >= t2.numElements())
				break;
		}
		
		return retorno;
	}
	
	public static void prependList(List<Double> t1, List<Double> t2) throws OverflowException, IndexOutOfBoundsException{
		for(int i=t2.numElements()-1; i>=0; i--)
			t1.insert(t2.get(i), 0);
	}
	
	// exercício 2 de Prog II
	public static int contaNegativos (List<Integer> lista) {
		return contaNegativos(lista, 0, lista.numElements()-1, 0);
	}
	
	private static int contaNegativos(List<Integer> lista, int inicio, int fim, int cont) {
		if(inicio > fim) {
			return cont;
		}
		if(lista.get(inicio) < 0) {
			inicio++;
			cont++;
			return contaNegativos(lista, inicio,fim, cont);
		}
		inicio++;
		return contaNegativos(lista, inicio, fim, cont);
	}
	
	//exercício 3 de Prog II
	public static boolean isPrimo(int n) {
		if(n<=1) {
			return false;
		}
		for(int i=2; i <= Math.sqrt(n); i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void removePrimos(List<Integer> lista) {
		for(int i =0; i < lista.numElements(); i++) {
			if(isPrimo(lista.get(i))) {
				lista.remove(i);
			}
		}
	}
	
	//exercício 4 de Prog II
	public static int exercicio4(List<Integer> lista1, List<Integer> lista2) throws UnderflowException{
		if(lista1.isEmpty() || lista1 == null || lista2 == null || lista2.isEmpty()) throw new UnderflowException();
		return exercicio4(lista1, lista2, 0,0,0);
	}
	
	private static int exercicio4(List<Integer> lista1, List<Integer> lista2, int soma, int i, int j) {
		if(i < lista1.numElements()) {
			soma += lista1.get(i);
			i++;
			return exercicio4(lista1, lista2, soma, i, j);
			
		} else if (j < lista2.numElements()){
			soma += lista2.get(j);
			j++;
			return exercicio4(lista1, lista2, soma, i, j);
		}
		return soma;
	}
	
}
