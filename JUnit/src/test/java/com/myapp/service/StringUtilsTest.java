package com.myapp.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StringUtilsTest {
	
	
	@Mock
	Calculator calculator1;
	@InjectMocks
	StringUtils mockObject ;//= Mockito.mock(StringUtils.class);
	
	
	/*
	 * @Before public void init(){ MockitoAnnotations.initMocks(this); //
	 * MockMvcBuilders.standaloneSetup(controllers) }
	 */
	
	@Test
	public void test() {
		Mockito.when(calculator1.add(1,2)).thenReturn(7);
		//StringUtils spyObject = spy(StringUtils.class);
		//mockObject = new StringUtils();
		//when(mockObject.isPalendrome("MADAM",1)).thenReturn(true);
		//when(spyObject.isPalendrome("DUD",1)).thenReturn(true);
		//assertEquals(true, spyObject.isPalendrome("DUD",1));
		System.out.println(mockObject.isPalendrome("MADAM",1));
		assertEquals (true, mockObject.isPalendrome("MADAM",1));
		
	}

}
