@SuppressWarnings("unchecked")
public abstract class Hashtable<T>{ 

    public Element<T>[] tabela;
    public int size;
    public int used;

    //construtor vazio
    public Hashtable(){
        this.tabela = new Element[11];
        this.size = 11;
        this.used = 0;
    }

     //construtor para uma tabela de dimensão size
    public Hashtable(int size){
         this.tabela= new Element[size];
         this.size = size;
         this.used = 0;
     }

     //retorna o nº de elementos da tabela 
    public int ocupados(){
        return this.used;
    }

     //retorna o factor de carga -> verificar a proporção de distribuição das chaves dentro do array/tabela
    public float factorCarga(){
         return (float) used/ (float) size;
    }

    //retornará a posição em que s será inserido ou se s existe a sua localização na tabela 
    protected abstract int procPos(T s);
   
    //uma nova tabela de dimensão especificada 
    public void alocarTabela(int dim){

        this.tabela = new Element[dim];
        this.size = dim;
        this.used = 0;

    }

    //retorna o elemento que esta na tabela , se x não está lá retorna null 
    public T procurar(T x){
        if(tabela[procPos(x)] != null){
            if(tabela[procPos(x)].getElemento().equals(x)){
                return tabela[procPos(x)].getElemento();
            }
        }
        return null;
    }


    //esvazia a tabela em uso
    public  void tornarVazia(){
        this.tabela = new Element[size];
        this.used = 0;
    }

    //remove o elemento da tabela
    public  void remove(T x){

        int Hash=procPos(x);

        if (tabela[Hash].elemento.equals(x)){
        
            tabela[Hash]=null;
        }  
    }

    //insere x na tabela
    public  void insere (T x){

        float carga = factorCarga();
        if (carga > 0.5) {
            rehash();
        }
        int alocar = procPos(x);

        tabela[alocar] = new Element<T>(x);
        used++;
    }
    
    //lista os elementos da tabela
    public void print(){
        for (int i = 0; i < size; i++) {
            if (tabela[i] != null) {
                if (tabela[i].state) {
                    System.out.println(""+i+" : "+tabela[i]);
                } else {
                    System.out.println("" + i + " : " + "removed/vazia");
                }
            } else {
                System.out.println(""+i+" : ");
            }

        }

        //fazer for each
    }

    //rehashing
    public void rehash(){

        //System.out.println("------Reashing Hastable------");

        Element<T>[] temp= tabela;
        alocarTabela(nextPrime(size*2));
        used=0;
        for(int i=0; i<temp.length; i++){
            if(temp[i]!=null && temp[i].state){
                insere(temp[i].getElemento());
            }
        }

    }

    public boolean isPrimo(int num){
        if(num==2){
            return true;
        }
        if(num % 2==0){
            return false;
        }
        for(int i=3; i*i<num; i+=2){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    public int nextPrime(int num){
        int result=num;
        while(!isPrimo(result)){
            result++;

        }
        return result;
    }
    

 
} 