public class Agenda {

    ABP<Contacto> lista;
    Iterador<Contacto> iterador;

    public Agenda() {
        lista = new ABP<>();
        iterador = new Iterador<Contacto>(lista.root);
    }

    public Agenda(Contacto contacto) {
        lista = new ABP<Contacto>(contacto);
    }

    public void adicionar(Contacto novoContacto) {
        lista.insere(novoContacto);
    }

    public void remove_Nome(Contacto tirarNome){

        lista.remove(tirarNome);
    }
    public String listar() {

        return lista.printEmOrdem();
    }

    public void editar(Contacto pessoa, int novoNumero) //nome para numero
    {
        Node<Contacto> novo = lista.root;

        while(pessoa.getNome() != novo.getElemento().getNome())
        {
            if(pessoa.getNome().compareTo(novo.getElemento().getNome()) < 0 && novo.getNodeEsq() != null)
            {
                novo = novo.getNodeEsq();
            }
            else if(pessoa.getNome().compareTo(novo.getElemento().getNome()) > 0 && novo.getNodeDir() != null)
            {
                novo = novo.getNodeDir();
            }
            else
            {
                break;
            }
        }
        novo.getElemento().setNumero(novoNumero);
    }

    public void editar(Contacto pessoa, String novoNome) //nome para nome
    {
        Node<Contacto> atual = lista.root;

        while (pessoa.getNome() != atual.getElemento().getNome()) {
            if (pessoa.getNome().compareTo(atual.getElemento().getNome()) < 0 && atual.getNodeEsq() != null) {
                atual = atual.getNodeEsq();
            } else if (pessoa.getNome().compareTo(atual.getElemento().getNome()) > 0 && atual.getNodeDir() != null) {
                atual = atual.getNodeDir();
            } else {
                break;
            }
        }

        atual.getElemento().setNome(novoNome);
    }
    ///////////
    public void editar(int num, String novoNome){ // numero para nome
        Node<Contacto> pessoa_1 = lista.root;

        while(num != pessoa_1.getElemento().getNumero())
        {
            if(num == pessoa_1.getElemento().getNumero() && num<0 && pessoa_1.getNodeEsq() != null)
            {
                pessoa_1 = pessoa_1.getNodeEsq();
            }
            else if(num == pessoa_1.getElemento().getNumero() && num> 0 && pessoa_1.getNodeDir() != null)
            {
                pessoa_1 = pessoa_1.getNodeDir();
            }
            else
            {
                break;
            }
        }
        pessoa_1.getElemento().setNome(novoNome);
    }
    public void editar(int numero, int novoNumero){ // numero para numero
        Node<Contacto> atual = lista.root;

        while(numero != atual.getElemento().getNumero())
        {
            if(numero == atual.getElemento().getNumero() && numero < 0 && atual.getNodeEsq() != null)
            {
                atual = atual.getNodeEsq();
            }
            else if(numero == atual.getElemento().getNumero() && numero > 0 && atual.getNodeDir() != null)
            {
                atual = atual.getNodeDir();
            }
            else
            {
                break;
            }
        }
        atual.getElemento().setNumero(novoNumero);
    }

   public int pesquisaNum(String Nome) {

        iterador = new Iterador<>(lista.root);
        while (iterador.hasNext()) {
            Contacto ContactoAtual = iterador.next();
            if (ContactoAtual.getNome().equals(Nome)) {
                return ContactoAtual.getNumero();
            }
        }
        return 0;
    }
    public void editar(String pessoa, int novoNumero) //nome para numero // erro
    {
        Node<Contacto> atual = lista.root;

        while (pessoa != atual.getElemento().getNome()) {
            if (pessoa == atual.getElemento().getNome() && atual.getNodeEsq() != null) {
                atual = atual.getNodeEsq();
            } else if (pessoa == atual.getElemento().getNome() && atual.getNodeDir() != null) {
                atual = atual.getNodeDir();
            } else {
                break;
            }
        }
            atual.getElemento().setNumero(novoNumero);  
    }
    public void chamador(int num) {
        Contacto procura;
        iterador = new Iterador<>(lista.root);

        String algo = "DESCONHECIDO";

        while (iterador.hasNext()) {
            procura = iterador.next();
            if (procura.getNumero() == num) {
                algo = procura.getNome();
            }
        }

        System.out.println(algo);

    }
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Contacto cont1 = new Contacto("leonor", 44481);
        Contacto cont2 = new Contacto("dinis", 44491);
        Contacto cont3 = new Contacto("ze", 44421);
        agenda.adicionar(cont1);
        agenda.adicionar(cont2);
        agenda.adicionar(cont3);
        /*agenda.adicionar(cont4);
        agenda.adicionar(cont5);
        agenda.adicionar(cont6);*/
        System.out.println(agenda.listar());// leonor dinis ze
        agenda.remove_Nome(cont1);// leonor
        System.out.println(agenda.listar());// dinis ze
        agenda.chamador(44499);// desconhecido
        agenda.chamador(44491);
        agenda.editar(cont2, "joao");// dinis passa a joao
        System.out.println(agenda.listar());// joao ze
        /*agenda.editar("joao",3);// erro*/
        agenda.editar(44421,4);
        System.out.println(agenda.listar());
    }
}