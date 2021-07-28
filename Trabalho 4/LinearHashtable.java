public class LinearHashtable<T> extends Hashtable<T>{

    @Override
    public int procPos(T s){

        int position = Math.abs(s.hashCode()) % size;

        if(tabela[position]==null){
            return position;
        }else{

            while(!(tabela[position]==null)){

                if(!tabela[position].state){
                    return position;
                }
                if(tabela[position].getElemento().equals(s)){
                    return position;
                }

                if(position==size-1){
                    position=0;
                }else{
                    position++;
                }
            }
            return position;
        }
    }
    public static void main(String[] args) {
        Hashtable<String> livro = new LinearHashtable<>();
        livro.insere("ola");
        livro.insere("oli");
        livro.insere("ole");
        livro.insere("olu");
        livro.insere("nossa");
        livro.insere("senhora");
        Hashtable<Integer> dic = new LinearHashtable<>();
        dic.insere(65);
        dic.insere(76);
        dic.insere(47);
        
    
  
  
  
        livro.print();
        dic.print();
        String nome =livro.procurar("ui");
        System.out.println(nome);
        /*System.out.println(livro.ocupados());
        System.out.println(livro.factorCarga());
        String nome = livro.procurar("do");
        System.out.println(nome);
        livro.remove("oli");
        livro.print();*/
    
        
    
        
        

      }
}