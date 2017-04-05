# Ferrovia
Traçado de rotas entre cidades para um sistema ferroviário.

## Pacotes

1. principal
    * Principal.java

2. viaFerrea
    * Ferrovia.java

### Principal
Na classe principal é onde é feito todos os teste solicitados.
Nesta classe se encontra o método __main__.

### Ferrovia
Nesta classe utilizamos grafo para representar a ferrovia e para representar o grafo com seus nós e arestas utilizamos matriz de adjacentes. Portanto, métodos que utilizem tal matriz estão dentro desta classe, ou seja, todos, visto que todos os métodos utilizados utilizam operações na matriz, que é a nossa ferrovia, e estão imergidos neste contexto.

_Temos_ :

**public void setMatriz(char orig, char dest, int dist):**
 Método que recebe duas cidades que são do tipo char, em nosso contexto, e a distância entre elas e preeenche a matriz de adjacentes.
Para isso utilizei a tabela ASCII, onde o caracter 'A' - 65 é igual a 0 e 'B' - 65 é igual a 1 e assim sucessivamente.
Com isso consigo mapear a cidade para seu respectivo local dentro da matriz chamada cidadesAdj de forma simples e pouco custosa. 

**public int distanciaDadoUmCaminho(ArrayList<Character> vet):**
Método que recebe um arraylist de objetos Character, que são cidades que a ferrovia liga, e retorna a distância para percorrer tais cidades.

**public int[][] calculaMatrizQtdCaminhosPossiveis(int passos):**
Método que recebe a quantidades de passos que gostaria que fosse percorrida entre uma origem e um destino e retorna uma matriz com a quantidade de caminhos possíveis com esses passos.
O método eleva a matriz a passos, ou seja, a matriz elevada ao cubo representará uma matriz onde, 
Matriz[i][j] será a quantidade de caminhos possíveis de 3 passos para sair da cidade i e chegar na cidade j.  

**public int calculaCaminhoMinimo(char orig, char dest):**
O método recebe duas cidades e retorna o menor caminho entre elas usando o algoritmo de Floyd Warshall

## Executar

Para rodar basta executar o comando _java -jar rotasEntreCidades.jar_
O arquivo .jar está na pasta rotasEntreCidades.

