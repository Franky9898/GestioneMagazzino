package esercizio;

public class Esercizio1
{
	//Gestione di un Magazzino Scrivi un programma Java che gestisca l'inventario di un magazzino. Il magazzino è organizzato in scaffali, e ogni scaffale ha più scomparti con prodotti.

	static int[][] creaMagazzino(final int numeroScaffali, final int numeroProdotti) //Crea un magazzino vuoto, con un certo numero di scaffali e scomparti.
	{                                                                                //Il numero degli scomparti equivale al numero di prodotti da vendere
		int[][] magazzino = new int[numeroScaffali][numeroProdotti];
		return magazzino;
	}

	static final int spazioScomparto = 5; //Dopo aver creato il magazzino, impostiamo lo spazio massimo di ogni scompartimento (o quantità massima di ogni prodotto)

	static void aggiungiProdottoAScaffale(int[][] magazzino, final int spazioScomparto, int scaffale, int prodotto) //Aggiunge un prodotto nello scaffale specificato se non supera lo spazioScomparto
	{
		if (scaffale < magazzino.length && prodotto < magazzino[scaffale].length && magazzino[scaffale][prodotto] < spazioScomparto)
			magazzino[scaffale][prodotto]++;
		else if (scaffale >= magazzino.length)
			System.out.println("Non ci sono abbastanza scaffali");
		else if (prodotto >= magazzino[scaffale].length)
			System.out.println("Non c'è questo scomparto");
		else if (magazzino[scaffale][prodotto] == spazioScomparto)
			System.out.println("Non c'è più posto :(");
	}

	static void rimuoviProdottoAScaffale(int[][] magazzino, int scaffale, int prodotto) //Rimuove un prodotto nello scaffale specificato se è presente
	{
		if (scaffale < magazzino.length && prodotto < magazzino[scaffale].length && magazzino[scaffale][prodotto] > 0)
			magazzino[scaffale][prodotto]--;
		else if (scaffale >= magazzino.length)
			System.out.println("Non ci sono abbastanza scaffali");
		else if (prodotto >= magazzino[scaffale].length)
			System.out.println("Non c'è questo scomparto");
		else if (magazzino[scaffale][prodotto] == 0)
			System.out.println("Cosa vuoi togliere che non c'è niente");
	}

	public static void main(String[] args)
	{
		int[][] magazzino = creaMagazzino(3, 4); //(0,0) -- (0,3) --- (1,0) -- (1,3) --- (2,0) -- (2,3)
		aggiungiProdottoAScaffale(magazzino, spazioScomparto, 2, 1);
		for (int j = 0; j < magazzino.length; j++)
		{
			for (int i : magazzino[j])
			{
				System.out.println(i);
			}
		}

	}
}
