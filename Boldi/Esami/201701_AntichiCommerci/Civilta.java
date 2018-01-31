public class Civilta {
	private String nome="";
	private ArrayList <Citta> colonie = null;
	private int tesoro;
	private ArrayList<Risorsa> stock = null;

	public Civilta (String nome){
		this.nome = nome.toUpperCase();
		this.colonie = new ArrayList<Citta>();
		this.tesoro = 0;
		this.stock = new ArrayList<Risorsa>();
	}
	
	@Override
	public boolean equals (Object c){
		if(c instanceof Civilta){
			Civilta civ = (Civilta) c;
			return (this.nome.equals(civ.nome));
		} else {
			return false;
		}
	}

	@Override
	public int hashCode(){
		return this.nome.length();
	}

	public ArrayList<Citta> getColonie(){
		return this.colonie;
	}

	public int getTesoro(){
		return this.tesoro;
	}

	public String getNome(){
		return this.nome;
	}

	public Citta fondaCitta(String nome, Risorsa risorsa){
		Citta c = new Citta(nome, risorsa);
		this.colonie.add(c);
		return c;
	}

	public void aggiungiCitta(Citta c){
		this.colonie.add(c);
	}

	public void rimuoviCitta(Citta c){
		this.colonie.remove(c);
	}
	
	
	public void aggiungiRisorsa(Risorsa r){
		this.stock.add(r);
	}
	
	public void aggiungiDenaro(int d){
		tesoro+=d;
	}

	public void faiProdurre(){
		for(Citta c : colonie){
			this.stock.add(c.produci());
		}
	}

	public boolean possiede(Risorsa r){
		boolean flag=false;
		for(Risorsa ris : stock){
			if(ris.equals(r)){
				flag=true;
				break;
			}
		}

		return flag;
	}

	public boolean vendiRisorseA(Civilta altra){
		boolean commercio=false;
		ArrayList<Risorsa> vendute = new ArrayList<Risorsa>();
		for(Risorsa ris : stock){
			if(altra.possiede(ris)==false){
				altra.aggiungiRisorsa(new Risorsa(ris));
				altra.aggiungiDenaro(-(ris.getPrezzo()));
				this.aggiungiDenaro(ris.getPrezzo());
				//Non è possibile rimuovere la risorsa qui
				//Perchè l'oggetto è usato dal for
				vendute.add(ris);
				commercio=true;
			}
		}
		//Rimozione di tutte le risorse vendute
		for(Risorsa r : vendute){
			this.stock.remove(r);
		}

		return commercio;
	}

	public void printColonie(){
		System.out.println("-------------------------------------");
		System.out.println(this.getNome()+" ha le seguenti colonie:");
		for(Citta c : colonie)
			System.out.println("    "+c.toString());	
		System.out.println("-------------------------------------");
	}
}
