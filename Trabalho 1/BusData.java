import java.util.*;

public class BusData{

	public int horas;
	public int minutos;
	public int npessoas;



	public void addHoras(int horas){
		this.horas = horas;
	}

	public void addMinutos(int minutos){
		this.minutos = minutos;
	}

	public void addPessoas(int npessoas){
		this.npessoas = npessoas;
	}

	public int getHoras(){
		return this.horas;
	}

	public int getMinutos(){
		return this.minutos;
	}

	public int getPessoas(){
		return this.npessoas;
	}

	@Override
	public String toString(){

        StringBuilder str = new StringBuilder();
        str.append(this.horas);
        str.append(":");
        str.append(this.minutos);
		str.append(" Grupo ");
        str.append(this.npessoas);
        str.append(" pessoas");

        return str.toString();
	}

	public static void main(String[] args) {
		BusData data = new BusData();
		data.addHoras(12);
		data.addMinutos(12);
		data.addPessoas(3);
		System.out.println(data.getHoras());
		System.out.println(data.getMinutos());
		System.out.println(data.getPessoas());
		System.out.println(data);
	}









}