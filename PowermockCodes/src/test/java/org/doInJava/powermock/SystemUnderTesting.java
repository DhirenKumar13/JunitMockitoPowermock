package org.doInJava.powermock;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.doInjava.data.business.Dependency;
import org.doInjava.data.business.SystemUnderTest;
import org.doInjava.data.business.UtilityClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityClass.class)
public class SystemUnderTesting {
	
	@Rule
	public MockitoRule rule = MockitoJUnit.rule();
	
	@Mock
	Dependency dependency;
	
	@InjectMocks
	private SystemUnderTest systemUnderTest;
	
	@Test
	public void testMethod() {
		List<Integer> intList = Arrays.asList(1,2,3,4,5,6);
		when(dependency.retrieveAllStats()).thenReturn(intList);
		
		PowerMockito.mockStatic(UtilityClass.class);
		systemUnderTest.methodCallingAStaticMethod();
	}

}
