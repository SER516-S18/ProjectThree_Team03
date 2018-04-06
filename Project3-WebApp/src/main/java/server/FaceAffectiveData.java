package server;

public class FaceAffectiveData {
	
	Double meditation = 0.0;
	Double engagementBoredom = 0.0;
	Double excitementShortTerm = 0.0;
	Double frustation = 0.0;
	Double excitementLongTerm = 0.0;
	
	public FaceAffectiveData() {
		this.meditation = new Double(0.0);
		this.engagementBoredom = new Double(0.0);
		this.excitementShortTerm = new Double(0.0);
		this.frustation = new Double(0.0);
		this.excitementLongTerm = new Double(0.0);
	}

	public Double getMeditation() {
		return meditation;
	}
	public void setMeditation(Double meditation) {
		this.meditation = meditation;
	}
	public Double getEngagementBoredom() {
		return engagementBoredom;
	}
	public void setEngagementBoredom(Double engagementBoredom) {
		this.engagementBoredom = engagementBoredom;
	}
	public Double getExcitementShortTerm() {
		return excitementShortTerm;
	}
	public void setExcitementShortTerm(Double excitementShortTerm) {
		this.excitementShortTerm = excitementShortTerm;
	}
	public Double getFrustation() {
		return frustation;
	}
	public void setFrustation(Double frustation) {
		this.frustation = frustation;
	}
	public Double getExcitementLongTerm() {
		return excitementLongTerm;
	}
	public void setExcitementLongTerm(Double excitementLongTerm) {
		this.excitementLongTerm = excitementLongTerm;
	} 
	
	public String toString() {
		return "FaceAffectiveData{" +
				"meditation=" + meditation +
				", engagementBoredom=" + engagementBoredom +
				", excitementShortTerm=" + excitementShortTerm +
				", frustation=" + frustation +
				", excitementLongTerm=" + excitementLongTerm +
				'}';
	}
	
	
}
