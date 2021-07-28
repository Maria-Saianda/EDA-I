public class QuadHashTable<T> extends Hashtable<T> {

    @Override
    protected int procPos(T s) {
        int hash = Math.abs(s.hashCode()) % size;
        int quad = hash;
        int i = 1;

        while (true) {
            if (tabela[hash] == null || tabela[hash].elemento.equals(s)) {
                return hash;
            } else if (!tabela[hash].state) {
                return hash;
            }
            hash = (int) (quad + Math.pow(i,2));
            hash = hash % size;
            i++;
        }
    }
    public static void main(String[] args) {
        QuadHashTable<Integer> livro= new QuadHashTable<>();
        livro.insere(65);
        livro.insere(76);
        livro.insere(47);
        QuadHashTable<String> dic= new QuadHashTable<>();
        dic.insere("olo");
        dic.insere("olu");
        dic.insere("nossa");
        dic.insere("senhora");
        
    
  
  
        
        livro.print();
        dic.print();
        /*System.out.println(livro.ocupados());
        System.out.println(livro.factorCarga());
        livro.remove("nossa");
        livro.print();
        livro.alocarTabela(2);
        livro.print();*/

    }

}

