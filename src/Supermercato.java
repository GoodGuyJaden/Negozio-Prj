import java.time.LocalDate;
import java.util.ArrayList;

public class Supermercato 
{
	private static ArrayList <Prodotti> lista_prodotti = new ArrayList <Prodotti>();
	
	public void riempiScaffali()
	{
		LocalDate dataScadenza;
		String materiale;
		
		for(int i=0;i<10;i++)
		{
			if((int)Math.random()*2 == 0)
			{
				//NonAlimentari n = new NonAlimentari("",(float)Math.random()*10,NonAlimentari.materiali_riciclabili.get((int)Math.random()*NonAlimentari.materiali_riciclabili.size()));
				lista_prodotti.add(new NonAlimentari("",(float)Math.random()*10,NonAlimentari.materiali_riciclabili.get((int)Math.random()*NonAlimentari.materiali_riciclabili.size())));
			}
			else
			{
				lista_prodotti.add(new NonAlimentari("",(float)Math.random()*10,"ferro"));
			}
		}
		
		for(int i=0;i<10;i++)
		{
			if((int)Math.random()*2 == 0)
			{
				//NonAlimentari n = new Alimentari("",(float)Math.random()*10,LocalDate.of()));
				lista_prodotti.add(new Alimentari("",(float)Math.random()*10,LocalDate.of(2018,(int)Math.random()*12+1,(int)Math.random()*30+1)));
			}
			else
			{
				lista_prodotti.add(new Alimentari("",(float)Math.random()*10,LocalDate.of(2018,LocalDate.now().getMonth(),LocalDate.now().getDayOfMonth())));
			}
		}
	}
}
