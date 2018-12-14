import java.util.ArrayList;

public abstract class Prodotti 
{
	private String id;
	private String descrizione;
	private float prezzo;
	private static ArrayList <String> ids = new ArrayList <String>();
		
	private String generaIds()
	{
		String id = "";
		for (int i = 0; i < 8; i++) {
			id += (int) Math.floor(Math.random()*10);

			if (!ids.contains(id) && i == 7) {
				ids.add(id);
			} else if (i == 7) {
				i = -1;
			}
		}
		return id;
	}
	
	
	public static ArrayList<String> getIds() 
	{
		return ids;
	}

	public String getId() 
	{
		return id;
	}
	
	public void setId() 
	{
		this.id = generaIds();
	}

	public String getDescrizione() 
	{
		return descrizione;
	}

	public void setDescrizione(String descrizione) 
	{
		this.descrizione = descrizione;
	}

	public float getPrezzo() 
	{
		return prezzo;
	}

	public void setPrezzo(float prezzo) 
	{
		this.prezzo = prezzo;
	}

	public abstract void applicaSconto();
	
	public abstract void checkSconto();

	@Override
	public String toString() {
		return "Codice a barre: " + id +"\nDescrizione del prodotto: " + descrizione + "\nPrezzo unitario: " + String.format("%.2f", prezzo) + "€\n";
	}
}
