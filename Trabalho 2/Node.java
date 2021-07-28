public class Node<T> {

    public T elemento;

    public Node<T> Next;

    public Node<T> Previous;

    public Node(){
        this.elemento = null;
        this.Previous = null;
        this.Next = null;
    }

    public T getElemento() {
        return elemento;
    }

    public Node(T nodevalue){
        this.elemento = nodevalue;
        this.Previous = null;
        this.Next = null;
    }

    public void setElemento(T elemento){
        this.elemento = elemento;
    }

    public Node<T> getNext() {
        return this.Next;
    }

    public void setNext(Node<T> next) {
        this.Next = next;
    }


    public Node<T> getPrevious() {
        return this.Previous;
    }

    public void setPrevious(Node<T> previous) {
        this.Previous = previous;
    }
}
