package esercizio;

import java.util.ArrayList;

public class Esercizio1
{
	//Gestione di un Magazzino Scrivi un programma Java che gestisca l'inventario di un magazzino. Il magazzino è organizzato in scaffali, e ogni scaffale ha più scomparti con prodotti.

	static final int[][] creaMagazzino(int numeroScaffali, int numeroProdotti) //Crea un magazzino vuoto, con un certo numero di scaffali e scomparti.
	{                                                                                //Il numero degli scomparti equivale al numero di prodotti da vendere
		final int[][] magazzino = new int[numeroScaffali][numeroProdotti];
		return magazzino;
	}

	static final int spazioScomparto = 5; //Dopo aver creato il magazzino, impostiamo lo spazio massimo di ogni scompartimento (o quantità massima di ogni prodotto)

	static void aggiungiProdottiAScaffale(int[][] magazzino, int spazioScomparto, int scaffale, int prodotto, int quantitaDaAggiungere) //Aggiunge un prodotto di quantitaDaAggiungere nello scaffale specificato se non supera lo spazioScomparto
	{
		if (scaffale < magazzino.length && prodotto < magazzino[scaffale].length && magazzino[scaffale][prodotto] <= (spazioScomparto - quantitaDaAggiungere))
			magazzino[scaffale][prodotto] += quantitaDaAggiungere;
		else if (scaffale >= magazzino.length)
			System.out.println("\nNon ci sono abbastanza scaffali");
		else if (prodotto >= magazzino[scaffale].length)
			System.out.println("\nNon c'è questo scomparto");
		else if (magazzino[scaffale][prodotto] > (spazioScomparto - quantitaDaAggiungere))
			System.out.println("Non c'è più posto :(");
	}

	static void rimuoviProdottiAScaffale(int[][] magazzino, int scaffale, int prodotto, int quantitaDaRimuovere) //Rimuove un prodotto di quantitaDaRimuovere nello scaffale specificato se è presente
	{
		if (scaffale < magazzino.length && prodotto < magazzino[scaffale].length && magazzino[scaffale][prodotto] >= quantitaDaRimuovere)
			magazzino[scaffale][prodotto] -= quantitaDaRimuovere;
		else if (scaffale >= magazzino.length)
			System.out.println("\nNon ci sono abbastanza scaffali");
		else if (prodotto >= magazzino[scaffale].length)
			System.out.println("\nNon c'è questo scomparto");
		else if (magazzino[scaffale][prodotto] < quantitaDaRimuovere)
			System.out.println("\nNon puoi rimuovere così tanti prodotti");
	}

	static void prodottiEsauriti(int[][] magazzino) //Stampa la lista dei prodotti esauriti (se non presenti in nessuno scaffale)
	{
		ArrayList<Integer> listaProdottiEsauriti = new ArrayList<Integer>();
		int c = 0; // Counter per tenere traccia delle volte che il prodotto non è presente sugli scaffali  
		for (int i = 0; i < magazzino[0].length; i++)
		{
			for (int j = 0; j < magazzino.length; j++)
			{
				if (magazzino[j][i] == 0)
				{
					c++;
					if (c == magazzino[0].length - 1)
					{
						listaProdottiEsauriti.add(i);
						c = 0;
					}
				}

			}
			c = 0;
		}
		if (listaProdottiEsauriti.isEmpty())
		{
			System.out.println("Tutti i prodotti sono disponibili");
		} else
		{
			System.out.print("Non ci sono più ");
			for (int i : listaProdottiEsauriti)
			{
				System.out.print("prodotti" + i + " ");

			}
			System.out.println("");
		}
	}

	static void statoMagazzino(int[][] magazzino) //Stampa il numero di prodotti sugli scaffali
	{
		for (int i = 0; i < magazzino.length; i++)
		{
			System.out.print("Prodotti in scaffale " + (i + 1) + ": ");
			for (int j = 0; j < magazzino[i].length; j++)
			{
				System.out.print(magazzino[i][j] + " prodotti" + j + " ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args)
	{
		int[][] magazzino = creaMagazzino(3, 4);
		prodottiEsauriti(magazzino);
		for (int i = 1; i < magazzino.length; i++)
		{
			for (int j = 0; j < magazzino[i].length; j++)
			{
				magazzino[i][j] = (int) (Math.random() * spazioScomparto);
			}
		}
		aggiungiProdottiAScaffale(magazzino, spazioScomparto, 2, 1, 4);
		statoMagazzino(magazzino);
		prodottiEsauriti(magazzino);

	}
}
