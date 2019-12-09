package hello;

public class Ereignis {
	private String startdatum;
	private String enddatum;
	private String name;
	private String beschreibung;
	private String ereignisID;
	
	public Ereignis(String startdatum, String enddatum, String name, String beschreibung, String ereignisId) {

		this.startdatum = startdatum;
		this.enddatum = enddatum;
		this.name = name;
		this.beschreibung = beschreibung;
		this.ereignisID = ereignisId;
	}

	@Override
	public String toString() {
		return "Ereignis [startdatum=" + startdatum + ", enddatum=" + enddatum + ", name=" + name + ", beschreibung="
				+ beschreibung + ", ereignisID=" + ereignisID + "]";
	}
	
	

}
