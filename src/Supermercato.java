import java.time.LocalDate;
import java.util.ArrayList;

public class Supermercato 
{
	private static ArrayList <Prodotti> lista_prodotti = new ArrayList <Prodotti>();		
	
	private static void riempiScaffali()
	{		
		for(int i=0;i<10;i++)
		{
			if((int)(Math.random()*2) == 0)
			{
				//NonAlimentari n = new NonAlimentari("",(float)Math.random()*10,NonAlimentari.materiali_riciclabili.get((int)Math.random()*NonAlimentari.materiali_riciclabili.size()));
				lista_prodotti.add(new NonAlimentari("Oggetto_" + i /*+ "   SI sconto."*/,(float)(Math.random()*10),NonAlimentari.getMat_ric().get((int)(Math.random()*NonAlimentari.getMat_ric().size()))));
			}
			else
			{
				lista_prodotti.add(new NonAlimentari("Oggetto_" + i /*+ "   NO sconto."*/,(float)(Math.random()*10),"ferro"));
			}
		}
		
		for(int i=0;i<10;i++)
		{
			if((int)(Math.random()*2) == 0)
			{
				//NonAlimentari n = new Alimentari("",(float)Math.random()*10,LocalDate.of()));
				lista_prodotti.add(new Alimentari("Oggetto_" + i /*+ "   NO sconto."*/,(float)(Math.random()*10),LocalDate.of(2019,(int)(Math.random()*12+1),(int)(Math.random()*30+1))));
			}
			else
			{
				lista_prodotti.add(new Alimentari("Oggetto_" + i /*+ "   SI sconto."*/,(float)(Math.random()*10),LocalDate.of(2018,LocalDate.now().getMonth(),LocalDate.now().plusDays((int)(Math.random()*10)).getDayOfMonth())));
			}
		}
	}

	public static void costruisci()
	{
		riempiScaffali();
	}
	
	public static ArrayList<Prodotti> getLista_prodotti() 
	{
		return lista_prodotti;
	}
	
	public static void stampaLista_Prodotti()
	{
		for (int i = 0;i<lista_prodotti.size();i++)
		{
			System.out.println(i+") " + lista_prodotti.get(i));
		}
	}
	
	public static void stampaSoloAlim()
	{
		for (Prodotti p:lista_prodotti)
		{
			if(p.getClass() == Alimentari.class)
			{
				System.out.println(lista_prodotti.indexOf(p) + ") "+ p);
			}
		}
	}
	
	public static void stampaSoloNonAlim()
	{
		for (Prodotti p:lista_prodotti)
		{
			if(p.getClass() == NonAlimentari.class)
			{
				System.out.println(lista_prodotti.indexOf(p) + ") "+ p);
			}
		}
	}
}
