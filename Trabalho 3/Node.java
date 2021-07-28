public class Node<T> {
    public T elemento;
    public Node<T> esq;
    public Node<T> dir;

    public Node(T e) {
        elemento = e;
        esq = null;
        dir = null;
    }

    public Node(T r, Node<T> e, Node<T> d) {
        elemento = r;
        setDir(dir);
        setEsq(esq);
    }

    public T getElemento() {
        return elemento;
    }

    public Node<T> getNodeEsq() {
        return esq;
    }

    public Node<T> getNodeDir() {
        return dir;
    }

    public void setElemento(T e) {
        elemento = e;
    }

    public void setEsq(Node<T> e) {
        esq = e;
    }

    public void setDir(Node<T> e) {
        dir = e;
    }

    public String toString() {
        return elemento.toString();
    }
}
