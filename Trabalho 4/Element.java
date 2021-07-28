public class Element<T> {
    
    public T elemento;
    public boolean state;

    public Element(){
        this.elemento=null;
        this.state = true;
    }
      
    public Element(T element) {
        this.elemento = element;
        this.state = true;
    }

    public void setElemento(T elemento){
        this.elemento=elemento;
    }

    public void setState(boolean valor){
        state=valor;
    }


    public T getElemento(){
        return elemento;
    }

    public String toString(){
        return elemento.toString();
    }
     

}