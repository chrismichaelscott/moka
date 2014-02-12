public class SampleClass6ConstructorVisibility {
	
	private SampleHelper helper;
	
	private int size;
	
	protected SampleClass6ConstructorVisibility(String name) {
		construct(name);
	}
	
	public SampleClass6ConstructorVisibility() {
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