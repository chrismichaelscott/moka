public class SampleClass8ConstantInitialization {
	
	public static Double PI = 3.14d;
	public static Double VOLUME_OF_EARTH;
	
	static {
		VOLUME_OF_EARTH = 4 / 3 * PI * Math.pow(6378100. 2);
	}
	
}