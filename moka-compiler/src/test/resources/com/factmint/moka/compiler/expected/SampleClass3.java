public class SampleClass3 {
	
	private SampleHelper helper;
	
	private int size;
	
	public SampleClass3(String name) {
		construct(name);
	}
	
	public SampleClass3() {
		construct();
	}
	
	private void construct(String name) {
		helper.setName(name);
	}
	
	private void construct() {
		construct("default");
	}
	
	public SampleHelper getHelper() {
		return helper;
	}
	
	public void setHelper(SampleHelper helper) {
		this.helper = helper;
	}
	
}