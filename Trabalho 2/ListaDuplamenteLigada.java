@SuppressWarnings("unchecked")
public class ListaDuplamenteLigada<T> implements Lista {

    public int size;

    public Node<T> header = new Node<>();

    public Node<T> tail = new Node<>();

    public ListaDuplamenteLigada(){
        header.setNext(tail);
        tail.setPrevious(header);
    }

    @Override
    public void add(Object x) {
        Node<T> a1 = new Node<T>((T) x);
        Node<T> previousNode = tail.getPrevious();
        previousNode.setNext(a1);
        a1.setNext(tail);
        a1.setPrevious(previousNode);
        tail.setPrevious(a1);
        size++;
    }

    @Override
    public void add(int i, Object x) {

            Node<T> NovoNode = new Node<>((T) x);
            Node<T> NodeExistente = get(i);
            NodeExistente.getNext().setPrevious(NovoNode);
            NovoNode.setNext(NodeExistente.getNext());
            NovoNode.setPrevious(NodeExistente);
            NodeExistente.setNext(NovoNode);
            size++;

    }

    @Override
    public void set(int i, Object x) {
        Node<T> setNext = get(i);
        setNext.setElemento((T) x);
    }

    @Override
    public Node<T> get(int i) {
        Node<T> novoNode = header;
        int cont = 0;
        while(cont < i){
            cont++;
            novoNode = novoNode.getNext();
        }
        return novoNode;
    }

    @Override
    public int size() {
        return size;
    }

    public String toString(){
        Node<T> nodeaux = this.header.getNext();
        StringBuilder lista = new StringBuilder();
        lista.append("[");
        if (nodeaux.getElemento() != null) {
            lista.append(nodeaux.getElemento() );
            nodeaux = nodeaux.getNext();
        }
        while(nodeaux.getElemento() != null){
            lista.append(" " + nodeaux.getElemento() );
            nodeaux = nodeaux.getNext();
        }
        lista.append("]");
        return lista.toString();
    }

    public static void main(String[] args) {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        System.out.println(lista.tail.elemento);
        System.out.println(lista.tail.Previous.elemento);
        System.out.println(lista.tail.Previous.Previous.elemento);
        System.out.println(lista.tail.Previous.Previous.Previous.elemento);
        System.out.println(lista.toString());
    }
}
