public class Contacto implements Comparable<Contacto> {

    public String nome;
    public int numero;

    public Contacto(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public int compareTo(Contacto o) {
        return nome.compareTo(o.nome);
    }

    public String toString() {
        return "ID:" + this.nome + ", Numero:" + this.numero + "\n";
    }

}