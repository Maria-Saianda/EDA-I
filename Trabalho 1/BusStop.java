import java.util.*;

@SuppressWarnings("unchecked")
public class BusStop{

	public Queue q;
	public int npessoastotal;

	public BusStop(){
		this.q = new Queue();
		this.npessoastotal = 0;
    }

	public void chega_grupo(int horas, int minutos, int npessoas){
		BusData busdata = new BusData();
		busdata.addHoras(horas);
		busdata.addMinutos(minutos);
		busdata.addPessoas(npessoas);
		this.q.enQueue(busdata);
		this.npessoastotal+=npessoas;
		System.out.println("Hora "+horas+":"+minutos+" "+npessoas+" pessoas chegam, ficam  "+this.npessoastotal+" na fila");

	}

	public void chegada_bus(int horas, int minutos, int vagas){
		int tempomediototal = 0,tempoBus = horas*60+minutos,tempoEspera,vagasSave = vagas,npessoastotalSave = npessoastotal;
		System.out.println("Chega Bus -> "+horas+":"+minutos+" há "+vagas+" vagas no bus");
		if(!this.q.isEmpty()){
			BusData busdata = (BusData)this.q.top();
			while(vagas>=busdata.getPessoas()){
				System.out.println("Hora "+horas+":"+minutos+ " chegaram "+busdata.getPessoas()+" ficam 0");
				tempomediototal+=tempomedio(busdata.getHoras(),busdata.getMinutos(),busdata.getPessoas());
				vagas-=busdata.getPessoas();
				this.npessoastotal-=busdata.getPessoas();
				this.q.deQueue();
				if(!this.q.isEmpty()){
					busdata = (BusData)this.q.top();
				}else
					break;
			}
			if ((!this.q.isEmpty()) && vagas>0) {
				System.out.println("Hora "+horas+":"+minutos+ " chegaram "+busdata.getPessoas()+" ficam "+(busdata.getPessoas()-vagas));
				tempomediototal+=tempomedio(busdata.getHoras(),busdata.getMinutos(),vagas);
				busdata.addPessoas(busdata.getPessoas()-vagas);
				this.npessoastotal-=vagas;
				this.q.primeiraAtualiza(this.q, busdata);
			}
			if(npessoastotalSave>vagasSave){
				tempoEspera=tempoBus-(tempomediototal/(vagasSave));
			}else{
				tempoEspera=tempoBus-(tempomediototal/(npessoastotalSave));
			}
			
				

			System.out.println("tempo médio de espera: "+tempoEspera+"m");
		}

	}

	public int tempomedio(int horas,int minutos,int npessoas){
		return (horas*60+minutos)*npessoas;
	}
	

	public static void main(String[] args){
		
		BusStop b23=new BusStop();
		b23.chega_grupo(14,14,3);
		b23.chega_grupo(14,18,2);
		System.out.println(b23.q);
		b23.chegada_bus(14,29,4);
		b23.chegada_bus(14,40,10);

	}







}