public class SampleClass2 {
	
	private SampleHelper helper;
	
	private int size;
	
	public SampleHelper getHelper() {
		if (helper.inError) {
			throw new Exception("yo!");
		}
		
		return helper;
	}
	
	public void setHelper(SampleHelper helper) {
		this.helper = helper;
	}
	
}