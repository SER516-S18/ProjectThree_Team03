package utility;

public class FaceData {
	FaceExpressionData faceExpressionData;
	FaceAffectiveData faceAffectiveData;
	Double timeElapsed = 0.0;
	
	public FaceExpressionData getFaceExpressionData() {
		return faceExpressionData;
	}
	public void setFaceExpressionData(FaceExpressionData faceExpressionData) {
		this.faceExpressionData = faceExpressionData;
	}
	public FaceAffectiveData getFaceAffectiveData() {
		return faceAffectiveData;
	}
	public void setFaceAffectiveData(FaceAffectiveData faceAffectiveData) {
		this.faceAffectiveData = faceAffectiveData;
	}	
	public Double getTimeElapsed() {
		return timeElapsed;
	}
	public void setTimeElapsed(Double timeElapsed) {
		this.timeElapsed = timeElapsed;
	}
	public String toString() {
		return "FaceData{" +
				"faceExpressionData=" + faceExpressionData +
				", faceAffectiveData=" + faceAffectiveData +
				'}';
	}
}
