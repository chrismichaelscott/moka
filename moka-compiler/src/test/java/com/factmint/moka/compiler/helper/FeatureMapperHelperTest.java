package com.factmint.moka.compiler.helper;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.factmint.moka.compiler.model.MokaClass;
import com.factmint.moka.compiler.model.MokaMethod;
import com.factmint.moka.compiler.model.MokaVariable;

public class FeatureMapperHelperTest {

	private FeatureMapperHelper helperUnderTest;
	private MokaClass mockMokaClass = mock(MokaClass.class);
	private List<MokaMethod> mockMethodsList = mock(ArrayList.class);
	private Iterator<MokaMethod> mockIterator = mock(Iterator.class);

	@Before
	public void setUp() {
		this.helperUnderTest = new FeatureMapperHelper(mockMokaClass);
		
		MokaVariable testMokaVariable = new MokaVariable();
		testMokaVariable.setName("imADependency");
		testMokaVariable.setType("String");
		List<MokaVariable> testDependenciesList = new ArrayList<MokaVariable>();
		testDependenciesList.add(testMokaVariable);
		
		when(mockMokaClass.getDependencies()).thenReturn(testDependenciesList);
		
		when(mockMokaClass.getMethods()).thenReturn(mockMethodsList);
		
		when(mockMethodsList.contains(any(MokaMethod.class))).thenReturn(false);
		
		when(mockMethodsList.iterator()).thenReturn(mockIterator);
		when(mockIterator.hasNext()).thenReturn(false);
	}

	@Test
	public void testBuildGettersAndSetters() {
		helperUnderTest.buildGettersAndSetters();
		
		// TODO: this should test  for the explicit getter and setter (using a matcher)
		verify(mockMethodsList, times(2)).add(any(MokaMethod.class));
	}

}
