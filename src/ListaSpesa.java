import java.util.ArrayList;

public class ListaSpesa 
{
	private ArrayList<Prodotti> lista = new ArrayList<Prodotti>();
	
	
	public int getSizeLista()
	{
		return lista.size();
	}
	
	public void addProd(int n)
	{
		lista.add(Supermercato.getLista_prodotti().get(n));
		System.out.println("Prodotto aggiunto\n");
	}
	
	public void removeProd(int n)
	{
		lista.remove(n);
		System.out.println("Prodotto rimosso\n");
	}
	
	public void stampa()
	{
		for (int i = 0;i<lista.size();i++)
		{
			System.out.println(i+") " + lista.get(i));
		}
	}
	
	public String conto()
	{
		Float conto = (float)0;
		
		for(Prodotti p : lista)
		{
			//System.out.println("Prezzo prima --->" + p.getPrezzo());
			p.applicaSconto();
			//System.out.println("Prezzo dopo --->" + p.getPrezzo() + "\n");
			conto+=p.getPrezzo();
		}
		
		return "Il totale da pagare è: " + String.format("%.2f", conto) + "€";
	}
}
