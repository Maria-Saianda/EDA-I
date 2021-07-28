import java.util.*;
 

@SuppressWarnings("unchecked")
public class Queue<AnyType> implements QueueInterface<AnyType>{

    public static int CAPACIDADEMAX = 20;
    public AnyType[] arr;      // array para armazenar elementos da Queue
    public int front;          // front 
    public int rear;           // cauda
    public int capacity;       // capacidade
    public int count;          // size 
    
    // Construtor que inicializa a Queue
    
    public Queue() {
        this.arr = (AnyType[]) new Object[CAPACIDADEMAX];
        this.capacity = CAPACIDADEMAX;
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    public Queue(int size){
        this.arr = (AnyType[]) new Object[size];
        this.capacity = size;
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

 
    //  remove elemento da front da  Queue
    @Override
    public AnyType deQueue(){
        // verifica a underflow da Queue
        if (isEmpty())
        {
            System.out.println("dQUnderFlow\nPrograma Terminou");
            System.exit(1);
        }

        int x = front;
        
        this.front = (this.front + 1) % this.capacity;
        this.count--;

        return arr[x];
    }
 
    // funçao para adicionar um item a Queue
    @Override
    public void enQueue(AnyType item){
        // verfica overflow da Queue
        if (isFull())
        {
            System.out.println("OverFlow\nPrograma Terminou");
            System.exit(1);
        }
 
        this.rear = (this.rear + 1) % this.capacity;
        this.arr[this.rear] = item;
        this.count++;
    }
 
    //funçao para dar return do front element na Queue
    @Override
    public AnyType top(){
        if (isEmpty()) 
        {
            System.out.println("UnderFlow\nPrograma Terminou");
            System.exit(1);
        }
        return arr[front];
    }
 
    // funçao para dar return do size da Queue
    @Override
    public int size(){
        return count;
    }
 
    // funçao para verificar se a Queue está vazia
    @Override
    public Boolean isEmpty(){
        return (size() == 0);
    }
 
    // funçao para verificar se a Queue está cheia
    @Override
    public Boolean isFull(){
        return (size() == this.capacity);
    }

    @Override
    public String toString(){
        if (isEmpty())
            return "Queue Vazia";

        StringBuilder str = new StringBuilder();
        str.append("[");
        str.append(this.arr[this.front]);

        for(int i = 1;i<size();i++){
            str.append(";");
            str.append(this.arr[front+i]);
        }

        str.append("]");

        return str.toString();
    }


    public void primeiraAtualiza(Queue q, AnyType item){
        q.deQueue();
        q.enQueue(item);
        for (int i=0; i<q.size()-1; i++){
            q.enQueue(q.deQueue());
        }
    }


    
    // implementaçao da queue
    
    public static void main (String[] args){
        Queue q = new Queue();
 
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.primeiraAtualiza(q,5);

        System.out.println(q);
        System.out.println("Elemento da front: " + q.top());
        q.deQueue();
        System.out.println("Elemento da front: " + q.top());
 
        System.out.println("Tamanho da Queue " + q.size());
 
        q.deQueue();
        q.deQueue();
        
        if (q.isEmpty())
            System.out.println("Queue está vazia");
        else
            System.out.println("Queue não está vazia");
        System.out.println(q);
    }
}