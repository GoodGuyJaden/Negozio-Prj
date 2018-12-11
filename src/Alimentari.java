import java.time.LocalDate;

public class Alimentari extends Prodotti
{
	private LocalDate dataScadenza;
	
	public Alimentari(String descrizione, float prezzo, LocalDate dataScadenza)
	{
		super.setId();
		super.setDescrizione(descrizione);
		super.setPrezzo(prezzo);
		this.dataScadenza = dataScadenza;
	}
	
	public LocalDate getData()
	{
		return dataScadenza;
	}
	
	public static void main(String[]args)
	{
		Alimentari a = new Alimentari("ciao", (float)7.50, LocalDate.of(2018, 11, 27));
		System.out.println(a);
		a.applicaSconto();
		System.out.println(a.getPrezzo());
	}
	
	@Override
	public String toString() {
		return super.toString()+ "Alimentari [dataScadenza=" + dataScadenza + "]";
	}

	@Override
	public void applicaSconto() 
	{
		if(this.dataScadenza.isBefore(LocalDate.now().minusDays(10)))
		{
			super.setPrezzo(super.getPrezzo()-super.getPrezzo()/100*20);
		}
		else
		{
			System.out.println("Non si applica lo sconto.");
		}
	}

}
