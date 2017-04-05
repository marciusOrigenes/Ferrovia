package viaFerrea;

import java.util.ArrayList;

public class Ferrovia{

	private int[][] cidadesAdj;
	private int totalCidades;
	private static Ferrovia instance = null;
	
	private Ferrovia(int totCid){
		this.totalCidades = totCid;
		this.cidadesAdj = new int[totalCidades][totalCidades];
	}
	
	/* Usando o padr�o Singleton de Design Pattern, visto que em nosso contexto s� existe uma ferrovia. */
	public static Ferrovia getInstance(int totCid){
		if(instance == null){
			instance = new Ferrovia(totCid);
		}
		return instance;
	}

	/* M�todo para inserir valores na matriz */
	public void setMatriz(char orig, char dest, int dist){

		/* Pela tabela ASCII, se subtrairmos 65 do caracter 'A' chegamos ao valor 0, do 'B' chegamos ao valor 1 e assim sucessivamente.
		 * Logo, linha 0 corresponde � origem da cidade 'A', linha 1 � origem da cidade 'B' e assim sucessivamente.
		 */		
		this.cidadesAdj[orig - 65][dest - 65] = dist;
	}

	/* Retorna a distancia dado um caminho fornecido. */
	public int distanciaDadoUmCaminho(ArrayList<Character> vet){

		int tam = 0, soma = 0;

		while( tam < vet.size() - 1){	
			
			/* Pela tabela ASCII, se subtrairmos 65 do caracter 'A' chegamos ao valor 0, do 'B' chegamos ao valor 1 e assim sucessivamente.
			 * Logo, linha 0 corresponde � origem da cidade 'A', linha 1 � origem da cidade 'B' e assim sucessivamente.
			 * Na express�o abaixo, a linha � o primeiro elemento do vetor e a coluna o segundo, sofrendo incremento de 1.
			 */	
			soma += cidadesAdj[vet.get(tam) - 65][(vet.get(tam + 1) - 65)];
			
			if(cidadesAdj[vet.get(tam) - 65][(vet.get(tam + 1) - 65)] == 0)
				return -1;

			tam++;
		}
		return soma;
	}

	/* Eleva uma matriz � quantidade de passos a qual se deseja saber a quantidade de caminhos poss�veis. */
	public int[][] calculaMatrizQtdCaminhosPossiveis(int passos){

		int[][] b = new int[totalCidades][totalCidades];
		int[][] c =new int[totalCidades][totalCidades];



		int[][] a= new int[totalCidades][totalCidades];

		for(int i = 0; i < totalCidades; i++) {
			for(int j = 0; j < totalCidades; j++) {
				a[i][j] = cidadesAdj[i][j];
			}
		}
		/* Tira os pesos da matriz que representa o grafo, transformando-a em uma matriz com somente 0s e 1s */
		for(int i = 0; i < totalCidades; i++){
			for(int j = 0; j < totalCidades; j++){
				if(cidadesAdj[i][j] !=0)
					a[i][j] = 1;
			}
		}

		for(int i = 0; i < totalCidades; i++) {
			for(int j = 0; j < totalCidades; j++) {
				b[i][j] = a[i][j];
			}
		}
		passos--;
		
		/* O c�digo abaixo mostra uma multiplica��o de matrizes sendo feita (passos - 1) vezes.
		 * Ao t�rmino, teremos uma matriz da quantidade de caminhos possiveis em rela��o � quantidade de passos informada.
		 * Ou seja, uma matriz� trar� como resultado uma matriz onde em cada posi��o teremos a quantidade de caminhos poss�veis com 2 passos.
		 */
		while(passos > 0){
			for (int i = 0; i < totalCidades; i++)
				for (int j = 0; j < totalCidades; j++)
					for (int x = 0; x < totalCidades; x++) 
						c[i][j] += a[i][x] * b[x][j];
			passos--;
			if(passos>0){
				for(int i = 0; i < totalCidades; i++) {
					for(int j = 0; j < totalCidades; j++) {
						b[i][j] = c[i][j];
					}
				}
				c =new int[totalCidades][totalCidades];
			}
		}	
		return c;
	}

	/* Para calcular o caminho m�nimo foi usado o Algoritmo de Floyd-Warshall, usando opera��es simples de matem�tica aplicadas � matriz de adjac�ncias. */
	public int calculaCaminhoMinimo(char orig, char dest){

		int[][] b = new int[totalCidades][totalCidades];

		for(int i = 0; i < totalCidades; i++) {
			for(int j = 0; j < totalCidades; j++) {
				b[i][j] = cidadesAdj[i][j];
			}
		}
		
		for(int i = 0; i < totalCidades; i++) 
			for(int j = 0; j < totalCidades; j++)
				if(b[i][j] == 0)
					b[i][j] = 99999;

		for (int k = 0; k < totalCidades; k++){
			for (int i = 0; i < totalCidades; i++)
				for (int j = 0; j < totalCidades; j++)
					if(b[i][k] + b[k][j] < b[i][j])
						b[i][j] = b[i][k] + b[k][j];
		}

		/* Pela tabela ASCII, se subtrairmos 65 do caracter 'A' chegamos ao valor 0, do 'B' chegamos ao valor 1 e assim sucessivamente.
		 * Logo, linha 0 corresponde � origem da cidade 'A', linha 1 � origem da cidade 'B' e assim sucessivamente.
		 */	
		return b[orig - 65][dest - 65];
	}
}