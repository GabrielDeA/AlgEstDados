
public class TestArvoreNAria {

	public static void main(String[] args) {
		NoArvore<Integer> n9 = new NoArvore<Integer>(9);
		NoArvore<Integer> n10 = new NoArvore<Integer>(10);
		NoArvore<Integer> n4 = new NoArvore<Integer>(4);
		

		NoArvore<Integer> n8 = new NoArvore<Integer>(8);
		NoArvore<Integer> n3 = new NoArvore<Integer>(3);
		

		NoArvore<Integer> n5 = new NoArvore<Integer>(5);
		NoArvore<Integer> n6 = new NoArvore<Integer>(6);
		NoArvore<Integer> n7 = new NoArvore<Integer>(7);

		NoArvore<Integer> n2 = new NoArvore<Integer>(2);
		
		

		NoArvore<Integer> n1 = new NoArvore<Integer>(1);
	    n1.inserirFilho(n2);
        n1.inserirFilho(n6);
		n1.inserirFilho(n7);
		

        n2.inserirFilho(n3);
        n2.inserirFilho(n5);

        n3.inserirFilho(n4);

        n7.inserirFilho(n8);
        n7.inserirFilho(n9);
        n9.inserirFilho(n10);

        NoArvore<Integer> n11 = new NoArvore<Integer>(11);
        n1.inserirFilho(n11);
        NoArvore<Integer> n12 = new NoArvore<Integer>(12);
       n1.inserirFilho(n12);
        

		Arvore<Integer> a = new Arvore<>();
		a.setRaiz(n1);

        Arvore<Integer> b = new Arvore<>();
		System.out.println(a.toString());
		System.out.println("Procurando 8="+a.pertence(8).getInfo());
		System.out.println("Procurando 1="+a.pertence(1).getInfo());
		System.out.println("Procurando 6="+a.pertence(6).getInfo());
		System.out.println("Procurando 4="+a.pertence(4).getInfo());
		System.out.println("Procurando 20="+a.pertence(20));

        System.out.println("Caminho até o 2:" + a.Caminho(2));

        System.out.println("Grau da Arvore: " + a.getGrau());

	}

}