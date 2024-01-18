package business.sporthalle;

public class Sporthalle {

	private String name;
	private int anzahlQuadratmeter;
	private String bodenbelag;
	
	public Sporthalle(String name, int anzahlQuadratmeter, String bodenbelag) {
		super();
		this.name = name;
		this.anzahlQuadratmeter = anzahlQuadratmeter;
		this.bodenbelag = bodenbelag;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAnzahlQuadratmeter() {
		return anzahlQuadratmeter;
	}
	public void setAnzahlQuadratmeter(int anzahlQuadratmeter) {
		this.anzahlQuadratmeter = anzahlQuadratmeter;
	}
	public String getBodenbelag() {
		return bodenbelag;
	}
	public void setBodenbelag(String bodenbelag) {
		this.bodenbelag = bodenbelag;
	}
	

	public String gibSporthallenZurueck(char trenner){
  		return this.getName() + trenner 
  			+ this.getName() + trenner
  		    + this.getAnzahlQuadratmeter() + trenner
  		    + this.getBodenbelag() + trenner + "\n";
  	}
	
	
}
