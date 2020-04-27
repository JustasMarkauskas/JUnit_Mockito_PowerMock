package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.in28minutes.data.api.TodoServise;

public class TodoBusinessImplMockTest {

	@Test
	public void testretrieveTodosRelatedToSpring_usingAMock() {
		// MOCKas 
		TodoServise todoServiceMock = mock(TodoServise.class);
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		
		// Nurodome kad padavus tam tikrus duomenis i metoda (when) atiduotu pasirinktus duomenis (then)
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		assertEquals(2, filteredTodos.size());
	}
	
	@Test
	public void testretrieveTodosRelatedToSpring_usingBDD() {
		
		//Given
		TodoServise todoServiceMock = mock(TodoServise.class);
		
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");		
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		// When
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		//Then	
		assertThat(filteredTodos.size(), is(2));
	}
	
	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD() {
		
		//Given
		TodoServise todoServiceMock = mock(TodoServise.class);
		
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");		
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		// When
		
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
		
		//Then
		verify(todoServiceMock).deleteTodo("Learn to Dance");
		
		verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");
		
		
	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCapture() {
		
		//Declare argument capture
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);		
		
		//Given
		TodoServise todoServiceMock = mock(TodoServise.class);
		
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");		
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		// When
		
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
		
		//Then //Define Argument captor on specific method call
		then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
		
		//Capture argument
		assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));		
		
	}
	
	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCaptureMultiple() {
		
		//Declare argument capture
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);		
		
		//Given
		TodoServise todoServiceMock = mock(TodoServise.class);
		
		List<String> todos = Arrays.asList("Learn to rock and roll", "Learn Spring", "Learn to Dance");		
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		// When
		
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
		
		//Then //Define Argument captor on specific method call
		then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
		
		//Capture argument
		assertThat(stringArgumentCaptor.getAllValues().size(), is(2));		
		
	}
}
