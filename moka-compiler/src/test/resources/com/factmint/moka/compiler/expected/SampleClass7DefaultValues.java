public class SampleClass7DefaultValues {
	
	public static Double PI = 3.14d;
	
	public Double ratioOfArea(Double area, Double ratio) {
		return area * ratio;
	}
	
	public Double ratioOfArea(Double area) {
		return ratioOfArea(area, PI);
	}
	
}