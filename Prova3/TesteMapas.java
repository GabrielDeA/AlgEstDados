public class TesteMapas {
    public static void main(String[] args) {
        MapaDispersao mp = new MapaDispersao<>(5);
        
       
        
        System.out.println(mp.inserir(1, 2));
        System.out.println( mp.inserir(1, 2));
        System.out.println(mp.buscar(1));
    }
}
