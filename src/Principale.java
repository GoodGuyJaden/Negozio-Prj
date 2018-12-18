import java.util.Scanner;

public class Principale 
{
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		ListaSpesa miaLista = new ListaSpesa();
		Supermercato.costruisci();
		menu(miaLista);
	}
	
	public static ListaSpesa selectChoice(ListaSpesa miaLista)
	{
		System.out.println("Se vuoi inserire uno di questi prodotti digita il numero corrispondente altrimenti premi 'INVIO'");
		String stringa = "";
		int scelta_lista = -1;
		while(!(scelta_lista >= 0 && scelta_lista < Supermercato.getLista_prodotti().size()))
		{
			System.out.println("Inserisci SOLO i numeri disponibili\n");
			stringa = sc.nextLine().replaceAll("\\D+", "");
			
			if(stringa.equals(""))
			{
				return null;
			}
			else
			{
				scelta_lista = Integer.parseInt(stringa);	
			}
			
		}
		miaLista.addProd(scelta_lista);
		return miaLista;
	}
	
	public static int selectChoice()
	{
		System.out.println("Seleziona il prodotto o premi 'INVIO' se si ha cambiato idea");
		String stringa = "";
		int scelta_lista = -1;
		while(!(scelta_lista >= 0 && scelta_lista < Supermercato.getLista_prodotti().size()))
		{
			stringa = sc.nextLine().replaceAll("\\D+", "");
			
			if(stringa.equals(""))
			{
				return -1;
			}
			else
			{
				scelta_lista = Integer.parseInt(stringa);
			}
			
		}
		return scelta_lista;
	}
	
	public static void menu(ListaSpesa miaLista)
	{
		String scelta_switch = "";
		int scelta_lista = 0;
		
		while(!scelta_switch.equals("9"))
		{
			System.out.println("Benvenuto su Pagazon, il sito giusto per la spesa online\n\n" + 
							   "Menu: seleziona la voce che desideri con il numero correlato\n"+
							   "1) Visualizza tutti i prodotti e i loro prezzi\n" + 
							   "2) Visualizza solo i prodotti alimentari\n" + 
							   "3) Visualizza solo i prodotti non alimentari\n" + 
							   "4) Visualizza se lo sconto è applicabile ad un prodotto e a quanto ammonta\n" +
							   "5) Aggiungi un prodotto alla tua lista della spesa\n" +
							   "6) Rimuovi un prodotto dalla tua lista della spesa\n" +
							   "7) Visualizza la tua lista della spesa\n" + 
							   "8) Per andare alla cassa\n" + 
							   "9) Annulla la tua spesa e chiudi l'applicazione");
			
			scelta_switch = sc.nextLine();
			
			switch (scelta_switch) 
			{
				case "1": case "5":	Supermercato.stampaLista_Prodotti();
									selectChoice(miaLista);
									break;
							
				case "2":			Supermercato.stampaSoloAlim();
									selectChoice(miaLista);
									break;
							
				case "3":			Supermercato.stampaSoloNonAlim();
									selectChoice(miaLista);
									break;
							
				case "4":			Supermercato.stampaLista_Prodotti();
									scelta_lista = selectChoice();
									if(scelta_lista == -1)
									{
										
									}
									else
									{
										Supermercato.getLista_prodotti().get(scelta_lista).checkSconto();
									}
									break;
							
				case "6":			if(miaLista.getSizeLista() == 0)
									{
										System.out.println("Non hai prodotti nel carrello. ");
									}
									else
									{
										miaLista.stampa();
										scelta_lista = selectChoice();
										if(scelta_lista == -1)
										{
											
										}
										else
										{
											miaLista.removeProd(scelta_lista);
										}
									}
									
									break;
				
				case "7":			miaLista.stampa();
									break;
				
				case "8":			if(miaLista.getSizeLista() == 0)
									{
										System.out.println("Non hai prodotti nel carrello. ");
									}
									else
									{
										System.out.println(miaLista.conto());
										System.out.println("\nTransazione eseguita. La spesa le verrà consegnata in " + (int)(Math.random()*9999999) + " secondi. Grazie per aver effettuato acquisti con noi."); 
										scelta_switch = "9";
									}
									break;
							
				case "9":			System.out.println("\nAnnullamento ordine in corso...\nAnnullato. Arrivederci.");
									break;
				
				default:			System.out.println("\nSi prega di inserire soltanto le opzioni valide\n");
									break;
			}
		}
		
	}
}
