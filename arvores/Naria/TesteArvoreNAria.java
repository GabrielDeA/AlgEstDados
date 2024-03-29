public class TesteArvoreNAria {
    public static void main(String[] args) {
        NoArvore<Integer> n9 = new NoArvore<Integer>(9);
		NoArvore<Integer> n10 = new NoArvore<Integer>(10);
		NoArvore<Integer> n4 = new NoArvore<Integer>(4);
		n4.inserirFilho(n10);
		n4.inserirFilho(n9);

		NoArvore<Integer> n8 = new NoArvore<Integer>(8);
		NoArvore<Integer> n3 = new NoArvore<Integer>(3);
		n3.inserirFilho(n8);

		NoArvore<Integer> n5 = new NoArvore<Integer>(5);
		NoArvore<Integer> n6 = new NoArvore<Integer>(6);
		NoArvore<Integer> n7 = new NoArvore<Integer>(7);

		NoArvore<Integer> n2 = new NoArvore<Integer>(2);
		n2.inserirFilho(n7);
		n2.inserirFilho(n6);
		n2.inserirFilho(n5);

		NoArvore<Integer> n1 = new NoArvore<Integer>(1);
		n1.inserirFilho(n4);
		n1.inserirFilho(n3);
		n1.inserirFilho(n2);

        NoArvore<Integer> n11 = new NoArvore<Integer>(11);
     //  n10.inserirFilho(n11);
		NoArvore<Integer> n12 = new NoArvore<Integer>(12);
		//n11.inserirFilho(n12);
    
		Arvore<Integer> a = new Arvore<>();

		a.setRaiz(n1);

		System.out.println(a.toString());
		System.out.println("Procurando 8="+a.pertence(8).getInfo());
		System.out.println("Procurando 1="+a.pertence(1).getInfo());
		System.out.println("Procurando 6="+a.pertence(6).getInfo());
		System.out.println("Procurando 4="+a.pertence(4).getInfo());
		System.out.println("Procurando 20="+a.pertence(20));
        System.out.println("Altura: " + a.getAltura());
        System.out.println("Nivel do 2: " + a.getNivel(2));
        System.out.println("Nivel do 8: " + a.getNivel(8));
        System.out.println("Nivel do 1: " + a.getNivel(1));
        System.out.println("Nivel do 11: " + a.getNivel(11));
        System.out.println("Nivel do 20 (teste de erro): " + a.getNivel(20));
		System.out.println("Balanceada? " + a.isBalanceada());
    }
}
