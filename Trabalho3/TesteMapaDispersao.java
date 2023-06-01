//Adriano, Artur e Gabriel Santos
public class TesteMapaDispersao {
    public static void main(String[] args) {
        MapaDispersao<String, String> mapa = new MapaDispersao<>();
        mapa.MapaDispersao(5);
        mapa.inserir("1", "A");
        mapa.inserir("2","B");
        mapa.inserir("3", "C");
        mapa.inserir("4", "D");
        mapa.inserir("5", "E");
        mapa.inserir("6", "F");
        mapa.inserir("7", "G");

        System.out.println("Quantidade de elementos: " + mapa.quantosElementos());
        System.out.println();
       // System.out.println(mapa.inserir("8", "H"));
        mapa.remover("2");
        System.out.println("Quantidade de elementos: " + mapa.quantosElementos());
    }
}
