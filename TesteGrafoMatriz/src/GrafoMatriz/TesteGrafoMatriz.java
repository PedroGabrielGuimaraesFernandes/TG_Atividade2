package GrafoMatriz;

public class TesteGrafoMatriz {
	public static void main(String args[]) {
		// // Grafo G10 dos slides
		// vértices: a=0, b=1, c=2, d=3, e=4, f=5, g=6, h=7
		TGrafo g = new TGrafo(8);

		g.insereA(0, 1); // a-b
		g.insereA(0, 2); // a-c
		g.insereA(0, 4); // a-e
		g.insereA(1, 3); // b-d
		g.insereA(1, 4); // b-e
		g.insereA(2, 5); // c-f
		g.insereA(2, 6); // c-g
		g.insereA(3, 7); // d-h
		g.insereA(4, 7); // e-h
		g.insereA(5, 4); // f-e
		g.insereA(5, 6); // f-g
		g.insereA(6, 7); // g-h

		g.show();

		// Esperado (slide): a, b, d, h, e, c, f, g
		g.percursoProfundidade(0);

		// Esperado (slide): a, b, c, e, d, f, g, h
		g.percursoLargura(0);

		g.percursoProfundidade(3);
		g.percursoLargura(3);
		
		// Grafo G9 dos slides
		// vértices: a=0, b=1, c=2, d=3, e=4, f=5, g=6, h=7
		TGrafoND gND = new TGrafoND(4);

		gND.insereAND(0, 1); // a-b
		gND.insereAND(1, 2); // b-c
		gND.insereAND(2, 3); // c-d
		gND.insereAND(3, 0); // d-a
		

		gND.show();

		// Esperado (slide): a, b, c, d
		gND.percursoProfundidade(0);

		// Esperado (slide): a, b, c, d
		gND.percursoLargura(0);

		gND.percursoProfundidade(2);
		gND.percursoLargura(2);
	}
}
