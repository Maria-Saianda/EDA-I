import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;



public class Corrector {
    
    public static boolean verificaPalavra(String palavra,QuadHashTable<String> dicionario){
        if(dicionario.procurar(palavra) != null)
        {
            return true;
        }
        return false;
    }

    public static String sugestaoRemover(String palavra,QuadHashTable<String> dicionario){
        String output = "";

        for(int i = 0; i < palavra.length(); i++){
            String novaPalavra = "";
            StringBuilder temp = new StringBuilder(palavra);
            StringBuilder sugestao = temp.deleteCharAt(i);
            novaPalavra += sugestao;

            if(dicionario.procurar(novaPalavra) != null){
                output += novaPalavra + " | ";
            }
        }
        return output;
    }

    public static String sugestaoAdicionar(String palavra, QuadHashTable<String> dicionario){
        String output = "";
        int counter = 0;
        while(counter <= palavra.length()){
            String[] alfabeto = {"a", "b", "c", "d", "e", "f", "g", "h", "i",
            "j", "k", "l", "m", "n", "o", "p",
            "q", "r", "s", "t", "u", "v", "w",
            "x", "y", "z", "ç", "á", "à", "â",
            "é", "è", "ê", "í", "Í", "î", "ó",
            "N", "O", "P", "Q", "R", "T", "U",
            "V", "X", "Z", "Y", "W", "ò", "ô",
            "ú", "ù", "E", "A", "B", "C", "D",
            "F", "G", "H", "I", "J", "K", "L" , "-"};
            for(String i:alfabeto) {
                String novaPalavra = "";
                StringBuilder temp = new StringBuilder(palavra);
                StringBuilder sugestao = temp.insert(counter, i);
                novaPalavra += sugestao;

                if(dicionario.procurar(novaPalavra) != null){
                    output += novaPalavra + " | ";
                }
            }
            counter++;
        }
        return output;
    }

    public static String sugestaoTroca(String n,QuadHashTable<String> dicionario){
        String sugestoes = "";

        for(int pos = 0; pos < n.length()-1; pos++) {

            StringBuilder palavra_chars = new StringBuilder(n);
            StringBuilder nova_palavra;

            char char_1 = palavra_chars.charAt(pos);
            char char_2 = palavra_chars.charAt(pos+1);

            nova_palavra = palavra_chars.deleteCharAt(pos);
            nova_palavra = palavra_chars.deleteCharAt(pos);
            nova_palavra = palavra_chars.insert(pos, char_1);
            nova_palavra = palavra_chars.insert(pos, char_2);


            try {
                if (dicionario.procurar(nova_palavra.toString()).equals(nova_palavra.toString())) {
                    sugestoes = sugestoes + " | " + nova_palavra;
                }

            } catch (NullPointerException e) {
                System.out.print("");
            }

        }
        return sugestoes;
    }
   
    public static void main(String[] args) {

        QuadHashTable<String> dicionario= new QuadHashTable<>();
        dicionario.alocarTabela(1575320);


        try{
        File file = new File("C:\\Users\\Administrador\\Desktop\\Uni\\2º ano\\1º semestre\\EDA I\\Trabalho 4\\wordlist-big-20201212.txt");
        BufferedReader ficheiro = new BufferedReader(new FileReader(file));

        String nomeFicheiro;
        
        while ((nomeFicheiro = ficheiro.readLine()) != null)
                dicionario.insere(nomeFicheiro);
      
        }catch (FileNotFoundException e) {
           // System.out.println("Não existe.");
        }catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
        try{
            File newFile = new File("algo.txt");
            BufferedReader newFicheiro = new BufferedReader(new FileReader(newFile));

            String linha,sugestao;
            int numLinha=0;
            while((linha = newFicheiro.readLine()) != null){
                String[] palavras = linha.split(" ");

                for(int i=0;i <palavras.length;i++){
                    
                    if(!verificaPalavra(palavras[i],dicionario)){
                        sugestao = sugestaoAdicionar(palavras[i], dicionario);
                        System.out.println("linha " + numLinha + ": sugestão " + sugestao);

                        sugestao = sugestaoRemover(palavras[i], dicionario);
                        System.out.println("linha " + numLinha + ": sugestão " + sugestao);

                        sugestao = sugestaoTroca(palavras[i], dicionario);
                        System.out.println("linha " + numLinha + ": sugestão " + sugestao);
                    }
                }
                numLinha++;
            }
            
            
          
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro de texto não encontrado.");
        } catch (java.io.IOException e) {
            System.out.println("nao sei");
        }
        
   
}
}


