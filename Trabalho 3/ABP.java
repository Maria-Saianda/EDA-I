@SuppressWarnings("all")
public class ABP<T extends Comparable<? super T>> implements Iterable<T> {

    Node<T> root;
    Iterador<T> iterador;

    public ABP(T x) {
        root = new Node<T>(x);
    }

    public ABP(Node<T> r) {
        root = r;
        iterador = new Iterador<>(root);
    }

    public ABP() {
        root = null;
    }

    public boolean empty() {
        return root == null;
    }

    public ABP(T r, Node<T> e, Node<T> d) {
        root = new Node<T>(r, e, d);
    }

    public T findMin() {
        if (empty())
            return null;
        return findMin(root);
    }

    private T findMin(Node<T> n) {
        if (n.esq == null)
            return n.elemento;
        else
            return findMin(n.esq);
    }

    private boolean contains(T x, Node<T> n) {
        if (n == null)
            return false;
        else {
            if (n.elemento.compareTo(x) < 0)
                return contains(x, n.dir);
            else if (n.elemento.compareTo(x) > 0)
                return contains(x, n.esq);
            else
                return true;
        }
    }

    public void insere(T x) {
        root = insere(x, root);
    }

    private Node<T> insere(T x, Node<T> n) {
        if (n == null)
            n = new Node<T>(x, null, null);
        else if ((n.elemento).compareTo(x) > 0)
            n.esq = insere(x, n.esq);
        else if ((n.elemento).compareTo(x) < 0)
            n.dir = insere(x, n.dir);
        return n;
    }

    public void remove(T x) {
        root = remove(x, root);
    }

    private Node<T> remove(T x, Node<T> n) {
        if (n == null)
            return n;
        if (n.elemento.compareTo(x) < 0)
            n.dir = remove(x, n.dir);
        else if (n.elemento.compareTo(x) > 0)
            n.esq = remove(x, n.esq);
        else if (n.esq != null && n.dir != null) {
            T min = findMin(n.dir);
            n.elemento = min;
            n.dir = remove(min, n.dir);
        } else if (n.esq == null)
            n = n.dir;
        else
            n = n.esq;
        return n;
    }

    public T getRoot() {
        return root.elemento;
    }

    ///////////////////////////////////////////////////
    public String printEmOrdem() {
        return printingEmOrdem(this.root);
    }

    public String printingEmOrdem(Node<T> atual) {
        if (atual != null) {
            String frase = atual.getElemento().toString() + " ";
            return printingEmOrdem(atual.getNodeEsq()) + frase + printingEmOrdem(atual.getNodeDir());
        }
        return "";
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new Iterador<>(root);
    }

}