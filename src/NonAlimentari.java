import java.util.ArrayList;
import java.util.Arrays;

public class NonAlimentari extends Prodotti
{
	private String materiale;
	public static ArrayList<String> materiali_riciclabili = new ArrayList<String>(Arrays.asList("Vetro","Plastica","Carta"));
	
	
	public static ArrayList<String> getMat_ric()
	{
		return materiali_riciclabili;
	}
	
	public NonAlimentari(String descrizione, float prezzo, String materiale)
	{
		super.setId();
		super.setDescrizione(descrizione);
		super.setPrezzo(prezzo);
		this.materiale = materiale.toUpperCase().charAt(0) + materiale.toLowerCase().substring(1);
	}
	
	@Override
	public String toString() {
		return super.toString() + "NonAlimentari [materiale=" + materiale + "]";
	}

	public static void main(String[]args)
	{
		NonAlimentari nA = new NonAlimentari("ciao", (float)8.00, "vetro");
		System.out.println(nA);
		nA.applicaSconto();
		System.out.println(nA.getPrezzo());
	}
	
	@Override
	public void applicaSconto() 
	{
		if(materiali_riciclabili.contains(materiale))
		{
			super.setPrezzo(super.getPrezzo()-super.getPrezzo()/100*10);
		}
		else
		{
			System.out.println("Sconto non applicabile.");
		}
	}

}
