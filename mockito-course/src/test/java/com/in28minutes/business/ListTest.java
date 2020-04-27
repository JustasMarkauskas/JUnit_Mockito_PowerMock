package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void mockListSizeMethod() {

		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
	}

	@Test
	public void mockListSizeMethod_ReturnMultipleValues() {

		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3).thenReturn(4);
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
		assertEquals(4, listMock.size());
	}

	@Test
	public void mockListGetMethodBDD() {

		//Given
		List <String> listMock = mock(List.class);		
		given(listMock.get(anyInt())).willReturn("in28minutes");
		//When listMock.get(0)
		String firstElement = listMock.get(0);
		//Then	
		assertThat(firstElement, is("in28minutes"));
		
	}

	@Test(expected = RuntimeException.class) // when testing exceptions we need to write what exception we expecting
	public void mockList_throwAnException() {

		List listMock = mock(List.class);
		// Argument matcher
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));

		listMock.get(0);

	}
	
	@Test(expected = RuntimeException.class) // when testing exceptions we need to write what exception we expecting
	public void mockList_mixingUp() {

		List listMock = mock(List.class);
		// Argument matcher
		when(listMock.subList(anyInt(), 5)).thenThrow(new RuntimeException("Something"));

		listMock.get(0);

	}

}
