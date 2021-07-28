@SuppressWarnings("all")
public class StackArray<T> {

    public T[] stack;
    int index = 0;
    int size;

    public StackArray() {
        stack = (T[]) new Object[100];
    }

    public StackArray(int size) {
        stack = (T[]) new Object[size];
        index = 0;
        this.size = size;
    }

    public void push(T o) {
        stack[index] = o;
        index++;
    }

    public T top() {
        if (index == 0)
            return stack[index];
        else
            return stack[index - 1];
    }

    public T pop() {
        index--;
        return stack[index];
    }

    public int size() {
        return index;
    }

    public boolean empty() {
        return index == 0;
    }

    public String toString() {
        String finalText = "";

        for (int i = 0; i < index; i++) {
            finalText += stack[i].toString() + " ";
        }

        return finalText;
    }    public static void main(String[] args) {

        StackArray<Integer> s1 = new StackArray<>(100);

        s1.push(12);
        s1.push(34);
        int b = s1.pop();
        int a = s1.pop();
        s1.push(a + b);
        s1.push(5);
        b = s1.pop();
        a = s1.pop();
        s1.push(a * b);

        System.out.println(s1.pop());
    }

}
