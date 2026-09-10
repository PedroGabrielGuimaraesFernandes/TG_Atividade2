package GrafoMatriz;

//definição de uma estrutura Matriz de Adjacência para armezanar um grafo
public class TGrafo {
	// Atributos Privados
	private	int n; // quantidade de vértices
	private	int m; // quantidade de arestas
	private	int adj[][]; //matriz de adjacência
	// Métodos Públicos
	public TGrafo( int n) {  // construtor
	    this.n = n;
	    // No início dos tempos não há arestas
	    this.m = 0; 
	    // alocação da matriz do TGrafo
	    this.adj = new int [n][n];

	    // Inicia a matriz com zeros
		for(int i = 0; i< n; i++)
			for(int j = 0; j< n; j++)
				this.adj[i][j]=0;	
	}

	// Insere uma aresta no Grafo tal que
	// v é adjacente a w
	public void insereA(int v, int w) {
	    // testa se nao temos a aresta
	    if(adj[v][w] == 0 ){
	        adj[v][w] = 1;
	        m++; // atualiza qtd arestas
	    }
	}
	
	// remove uma aresta v->w do Grafo	
	public void removeA(int v, int w) {
	    // testa se temos a aresta
	    if(adj[v][w] == 1 ){
	        adj[v][w] = 0;
	        m--; // atualiza qtd arestas
	    }
	}
	// Apresenta o Grafo contendo
	// número de vértices, arestas
	// e a matriz de adjacência obtida	
	public void show() {
	    System.out.println("n: " + n );
	    System.out.println("m: " + m );
	    for( int i=0; i < n; i++){
	    	System.out.print("\n");
	        for( int w=0; w < n; w++)
	            if(adj[i][w] == 1)
	            	System.out.print("Adj[" + i + "," + w + "]= 1" + " ");
	            else System.out.print("Adj[" + i + "," + w + "]= 0" + " ");
	    }
	    System.out.println("\n\nfim da impressao do grafo." );
	}

	/ "Visita" o nó. Aqui apenas imprime, mas poderia ser
	// qualquer outra operação sobre o vértice.
	private void visitarNo(int v) {
		System.out.print(v + " ");
	}

	// Marca o nó v como já visitado
	private void marcarNo(boolean[] nosMarcados, int v) {
		nosMarcados[v] = true;
	}

	// Procura, a partir do nó n, o PRIMEIRO nó adjacente
	// ainda não marcado. Retorna -1 se não existir nenhum.
	private int noAdjacente(int n, boolean[] nosMarcados) {
		for (int w = 0; w < this.n; w++) {
			if (adj[n][w] == 1 && !nosMarcados[w]) {
				return w;
			}
		}
		return -1;
	}

	// Percurso em Profundidade usa PILHA
	// Baseado no algoritmo dos slides o roteiro tem que ser:
	// 1. Visita-se um nó n previamente selecionado;
	// 2. Marca o nó n;
	// 3. Empilha n em uma pilha P;
	// 4. Enquanto a pilha P não estiver vazia:
	//    4.1 desempilha n;
	//    4.2 enquanto existir m não marcado adjacente a n:
	//        4.2.1 visita m;
	//        4.2.2 empilha n;
	//        4.2.3 marca m;
	//        4.2.4 n <- m;
	public void percursoProfundidade(int vInicio) {
		boolean[] nosMarcados = new boolean[this.n];
		Stack<Integer> p = new Stack<Integer>();
		int n, m;

		System.out.print("Percurso em profundidade a partir de " + vInicio + ": ");

		visitarNo(vInicio);
		marcarNo(nosMarcados, vInicio);
		p.push(vInicio);

		while (!p.isEmpty()) {
			n = p.pop();
			while ((m = noAdjacente(n, nosMarcados)) != -1) {
				visitarNo(m);
				p.push(n);
				marcarNo(nosMarcados, m);
				n = m;
			}
		}
		System.out.println();
	}

	// Percurso em Largura usa FILA
	// Baseado no algoritmo dos slides o roteiro tem que ser:
	// 1. Visita-se um nó n previamente selecionado;
	// 2. Marca o nó n;
	// 3. Insere n em uma fila F;
	// 4. Enquanto a fila F não estiver vazia:
	//    4.1 retira um elemento da fila e atribui a n;
	//    4.2 para cada m não marcado adjacente a n:
	//        4.2.1 visita m;
	//        4.2.2 insere m na fila;
	//        4.2.3 marca m;
	public void percursoLargura(int vInicio) {
		boolean[] nosMarcados = new boolean[this.n];
		Queue<Integer> f = new LinkedList<Integer>();
		int n, m;

		System.out.print("Percurso em largura a partir de " + vInicio + ": ");

		visitarNo(vInicio);
		marcarNo(nosMarcados, vInicio);
		f.add(vInicio);

		while (!f.isEmpty()) {
			n = f.poll();
			while ((m = noAdjacente(n, nosMarcados)) != -1) {
				visitarNo(m);
				f.add(m);
				marcarNo(nosMarcados, m);
			}
		}
		System.out.println();
	}
}