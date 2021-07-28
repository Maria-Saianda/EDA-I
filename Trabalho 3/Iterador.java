public class Iterador<T> implements java.util.Iterator<T> {

    Node<T> root;
    StackArray<Node<T>> choice_points;

    public Iterador(Node<T> x) {
        root = x;
        choice_points = new StackArray<Node<T>>();
    }

    public boolean hasNext() {
        return root != null;
    }

    public T next() {
        if (!hasNext())
            throw new java.util.NoSuchElementException();
        T to_return = root.elemento;
        if (root.getNodeDir() != null)
            choice_points.push(root.getNodeDir());
        if (root.getNodeEsq() != null)
            root = root.getNodeEsq();
        else {
            if (!choice_points.empty()) {
                root = choice_points.pop();
            } else
                root = null;
        }
        return to_return;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

}