import java.time.LocalDate;

public class Alimentari extends Prodotti
{
	private LocalDate dataScadenza;
	
	
	public static void main(String[] args) {
		Alimentari n = new Alimentari("cetrioli",(float)8.50,LocalDate.of(2018, 12, 29));
		System.out.println(n);
		n.applicaSconto();
	}
	
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
	
	@Override
	public void applicaSconto() 
	{
		if(this.dataScadenza.isBefore(LocalDate.now().plusDays(10)) && this.dataScadenza.isAfter(LocalDate.now()))
		{
			System.out.println("Sconto applicato sul prodotto: " + super.getDescrizione() + " di -->" + String.format("%.2f", super.getPrezzo()/100*20));
			super.setPrezzo(super.getPrezzo()-super.getPrezzo()/100*20);
		}
		else
		{
			//System.out.println("Non si applica lo sconto."); 
		}
	}
	
	@Override
	public void checkSconto() 
	{
		if(this.dataScadenza.isBefore(LocalDate.now().plusDays(10)) && this.dataScadenza.isAfter(LocalDate.now()))
		{
			System.out.println("Sconto applicabile di -->" + String.format("%.2f", super.getPrezzo()/100*20) +"�\nPrezzo da pagare finale: " + String.format("%.2f", (super.getPrezzo()-super.getPrezzo()/100*20)) + "�\n");
		}
		else
		{
			System.out.println("Non si applica lo sconto.\n");
		}
	}
	
	
	@Override
	public String toString() {
		return super.toString()+ "Tipo prodotto: ALIMENTARI\nData di scadenza: " + dataScadenza + "\n";
	}
}
