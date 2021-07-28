import java.util.*;

@SuppressWarnings("unchecked")
public class AstroInt implements InterfaceAstroInt{
	
	public ListaDuplamenteLigada<Integer> ListaDuplamenteLigada;
	

	public AstroInt()
	{
		this.ListaDuplamenteLigada = new ListaDuplamenteLigada();
	}


	public AstroInt(String valor){
		this.ListaDuplamenteLigada = new ListaDuplamenteLigada();
		for(int i=0; i<valor.length(); i++){
            ListaDuplamenteLigada.add((int) valor.charAt(i) - 48);
        }
	}


	public int length()
	{
		return this.ListaDuplamenteLigada.size;
	}


	public AstroInt add(AstroInt b)
	{
		int c = 0;
		int s = 0;
		AstroInt a1 = this;
		AstroInt b1 = b;
		AstroInt aux = new AstroInt();
   		
		a1.ListaDuplamenteLigada.tail = a1.ListaDuplamenteLigada.tail.Previous;
		b1.ListaDuplamenteLigada.tail = b1.ListaDuplamenteLigada.tail.Previous;

		while (a1.ListaDuplamenteLigada.tail != a1.ListaDuplamenteLigada.header  || b1.ListaDuplamenteLigada.tail != b1.ListaDuplamenteLigada.tail)
		{
			if (a1.ListaDuplamenteLigada.tail != a1.ListaDuplamenteLigada.header && b1.ListaDuplamenteLigada.tail != b1.ListaDuplamenteLigada.header)
			{
				s = ((a1.ListaDuplamenteLigada.tail.elemento) + (b1.ListaDuplamenteLigada.tail.elemento) + c) % 10;
				c = ((a1.ListaDuplamenteLigada.tail.elemento) + (b1.ListaDuplamenteLigada.tail.elemento) + c) / 10;
				a1.ListaDuplamenteLigada.tail = a1.ListaDuplamenteLigada.tail.Previous;
				b1.ListaDuplamenteLigada.tail = b1.ListaDuplamenteLigada.tail.Previous;
			}
			else if (a1.ListaDuplamenteLigada.tail == a1.ListaDuplamenteLigada.header && b1.ListaDuplamenteLigada.tail != b1.ListaDuplamenteLigada.header)
			{
				s = ((b1.ListaDuplamenteLigada.tail.elemento) + c) % 10;
				c = ((b1.ListaDuplamenteLigada.tail.elemento) + c) / 10;
				b1.ListaDuplamenteLigada.tail = b1.ListaDuplamenteLigada.tail.Previous;
			}
			else if (a1.ListaDuplamenteLigada.tail != a1.ListaDuplamenteLigada.header && b1.ListaDuplamenteLigada.tail == b1.ListaDuplamenteLigada.header)
			{
				s = (a1.ListaDuplamenteLigada.tail.elemento + c) % 10;
				c = (a1.ListaDuplamenteLigada.tail.elemento + c) / 10;
				a1.ListaDuplamenteLigada.tail = a1.ListaDuplamenteLigada.tail.Previous;
			}
			aux.ListaDuplamenteLigada.add(0,s);
		}
     
		if (c != 0)
		{
			aux.ListaDuplamenteLigada.add(0,c);
		}
		return aux;
	}


	public AstroInt sub(AstroInt b)
	{
		int c = 0;
		int s = 0;
		AstroInt a1 = this;
		AstroInt b1 = b;
		AstroInt aux = new AstroInt();
    
		a1.ListaDuplamenteLigada.tail = a1.ListaDuplamenteLigada.tail.Previous;
		b1.ListaDuplamenteLigada.tail = b1.ListaDuplamenteLigada.tail.Previous;
    
		while (a1.ListaDuplamenteLigada.tail != a1.ListaDuplamenteLigada.header || b1.ListaDuplamenteLigada.tail != b1.ListaDuplamenteLigada.header)
		{
			if (a1.ListaDuplamenteLigada.tail != a1.ListaDuplamenteLigada.header && b1.ListaDuplamenteLigada.tail != b1.ListaDuplamenteLigada.header)
			{
				if ((a1.ListaDuplamenteLigada.tail.elemento) + c >= (b1.ListaDuplamenteLigada.tail.elemento))
				{
					s = ((a1.ListaDuplamenteLigada.tail.elemento) + c - (b1.ListaDuplamenteLigada.tail.elemento));
					c = 0;
				}
				else
				{
					s = ((a1.ListaDuplamenteLigada.tail.elemento) + c + 10 - (b1.ListaDuplamenteLigada.tail.elemento));
					c = -1;
				}
				a1.ListaDuplamenteLigada.tail = a1.ListaDuplamenteLigada.tail.Previous;
				b1.ListaDuplamenteLigada.tail = b1.ListaDuplamenteLigada.tail.Previous;
			}
			else if (a1.ListaDuplamenteLigada.tail != a1.ListaDuplamenteLigada.header && b1.ListaDuplamenteLigada.tail == b1.ListaDuplamenteLigada.header)
			{
				if (a1.ListaDuplamenteLigada.tail.elemento >= 1)
				{
					s = ((a1.ListaDuplamenteLigada.tail.elemento) + c);
					c = 0;
				}
				else
				{
					if (c != 0)
					{
						s = ((a1.ListaDuplamenteLigada.tail.elemento) + 10 + c);
						c = -1;
					}
					else
					{
						s = a1.ListaDuplamenteLigada.tail.elemento;
					}
				}
				a1.ListaDuplamenteLigada.tail = a1.ListaDuplamenteLigada.tail.Previous;
			}
			aux.ListaDuplamenteLigada.add(0,s);
		}
		return aux;
	}


	public String toString()
	{
		return this.ListaDuplamenteLigada.toString();
	}


	public static void main(String[] args) {
		AstroInt novo1 = new AstroInt("69");
		AstroInt novo2 = new AstroInt("54");
		/*AstroInt soma=novo1.add(novo2);*/
		AstroInt sub=novo1.sub(novo2);
		System.out.println(sub.toString());
	}
}
	