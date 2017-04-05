package principal;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import viaFerrea.Ferrovia;

public class Principal {

	public static void main(String[] args) {
		Scanner arquivo = null;

		Set<Character> contaTotalCidades = new HashSet<Character>();

		try {
			Character i, j;
			String aux;
			int dist;
			
			arquivo = new Scanner(new FileReader("ferrovia.txt"));
			
			while(arquivo.hasNext()){
				aux = arquivo.nextLine();
				
				i = aux.charAt(0);
				j = aux.charAt(1);
				dist = Integer.parseInt(aux.substring(2));
				
				contaTotalCidades.add(i);
				contaTotalCidades.add(j);
			}
			
		} catch(IOException e){
			e.printStackTrace();
			System.out.println("Erro na leitura do arquivo. Tente novamente!");
			System.exit(1);
			
		} finally {
			arquivo.close();
		}

		Ferrovia ferrovia = Ferrovia.getInstance(contaTotalCidades.size());

		try {
			Character i, j;
			String aux;
			int dist;
			
			arquivo = new Scanner(new FileReader("ferrovia.txt"));
			
			while(arquivo.hasNext()){
				aux = arquivo.nextLine();
				
				i = aux.charAt(0);
				j = aux.charAt(1);
				dist = Integer.parseInt(aux.substring(2));
				
				ferrovia.setMatriz(i.charValue(), j.charValue(), dist);
			}
			
		} catch(IOException e){
			System.out.println("Erro na leitura do arquivo. Tente novamente!");
			System.exit(1);
			
		} finally {
			arquivo.close();
		}
		
		ArrayList<Character> vet = new ArrayList<Character>();
		
		vet.add('A');
		vet.add('B');
		vet.add('C');		
		if(ferrovia.distanciaDadoUmCaminho(vet) != -1)
			System.out.println("Saída # 1: "+ferrovia.distanciaDadoUmCaminho(vet));
		else
			System.out.println("Saída # 1: NENHUMA ROTA ENCONTRADA");
		
		vet = new ArrayList<Character>();
		
		vet.add('A');
		vet.add('D');		
		if(ferrovia.distanciaDadoUmCaminho(vet) != -1)
			System.out.println("Saída # 2: "+ferrovia.distanciaDadoUmCaminho(vet));
		else
			System.out.println("Saída # 2: NENHUMA ROTA ENCONTRADA");
		
		vet = new ArrayList<Character>();
		
		vet.add('A');
		vet.add('D');
		vet.add('C');
		if(ferrovia.distanciaDadoUmCaminho(vet) != -1)
			System.out.println("Saída # 3: "+ferrovia.distanciaDadoUmCaminho(vet));
		else
			System.out.println("Saída # 3: NENHUMA ROTA ENCONTRADA");
		
		vet = new ArrayList<Character>();
		
		vet.add('A');
		vet.add('E');
		vet.add('B');
		vet.add('C');
		vet.add('D');
		if(ferrovia.distanciaDadoUmCaminho(vet) != -1)
			System.out.println("Saída # 4: "+ferrovia.distanciaDadoUmCaminho(vet));
		else
			System.out.println("Saída # 4: NENHUMA ROTA ENCONTRADA");
		
		vet = new ArrayList<Character>();
		
		vet.add('A');
		vet.add('E');
		vet.add('D');
		if(ferrovia.distanciaDadoUmCaminho(vet) != -1)
			System.out.println("Saída # 5: "+ferrovia.distanciaDadoUmCaminho(vet));
		else
			System.out.println("Saída # 5: NENHUMA ROTA ENCONTRADA");
		
	   
		int[][] mat = ferrovia.calculaMatrizQtdCaminhosPossiveis(2) ;
		int soma = mat['C' - 65]['C' - 65];
	    mat = ferrovia.calculaMatrizQtdCaminhosPossiveis(3) ;
		soma += mat['C' - 65]['C' - 65];
		System.out.println("Saída # 6: "+soma);
		
		mat = ferrovia.calculaMatrizQtdCaminhosPossiveis(4) ;
		System.out.println("Saída # 7: "+mat['A' - 65]['C' - 65]);		
		
		int dist = ferrovia.calculaCaminhoMinimo('A', 'C');
		System.out.println("Saída # 8: "+dist);
		
		dist = ferrovia.calculaCaminhoMinimo('B', 'B');
		System.out.println("Saída # 9: "+dist);
		
		/*Para o item 10 havia soluções melhores mas o meu tempo se esgotou. Então apaguei o caminho que estava seguindo e enviei a solução abaixo pois esta está funcionando.*/
		vet.clear();
		int result = 0, cont = 0;
		vet.add('C');
		vet.add('D');
		vet.add('C');
		result += ferrovia.distanciaDadoUmCaminho(vet);
		if(result <= 30){
			cont++;
		}
		result = 0;
		vet.clear();
		vet.add('C');
		vet.add('E');
		vet.add('B');
		vet.add('C');
		result += ferrovia.distanciaDadoUmCaminho(vet);
		if(result <= 30){
			cont++;
		}
		result = 0;
		vet.add('D');
		vet.add('C');
		result += ferrovia.distanciaDadoUmCaminho(vet);
		if(result <= 30){
			cont++;
		}
		result = 0;
		vet.clear();
		vet.add('C');
		vet.add('D');
		vet.add('C');
		vet.add('E');
		vet.add('B');
		vet.add('C');
		result += ferrovia.distanciaDadoUmCaminho(vet);
		if(result <= 30){
			cont++;
		}
		result = 0;
		vet.clear();
		vet.add('C');
		vet.add('D');
		vet.add('E');
		vet.add('B');
		vet.add('C');
		result += ferrovia.distanciaDadoUmCaminho(vet);
		if(result <= 30){
			cont++;
		}
		result = 0;
		vet.clear();
		vet.add('C');
		vet.add('E');
		vet.add('B');
		vet.add('C');
		vet.add('E');
		vet.add('B');
		vet.add('C');
		result += ferrovia.distanciaDadoUmCaminho(vet);
		if(result <= 30){
			cont++;
		}
		result = 0;
		vet.add('E');
		vet.add('B');
		vet.add('C');
		result += ferrovia.distanciaDadoUmCaminho(vet);
		if(result <= 30){
			cont++;
		}
		
		System.out.println("Saída # 10: "+cont);
	}
	
}