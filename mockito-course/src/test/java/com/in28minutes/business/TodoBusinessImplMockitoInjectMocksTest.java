package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.in28minutes.data.api.TodoServise;

public class TodoBusinessImplMockitoInjectMocksTest {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	
	@Mock // toks uzrasymas perdaro TodoServise todoServiceMock = mock(TodoServise.class); i viena eilute.
	TodoServise todoServiceMock;

	@InjectMocks // perdaro TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock); i viena eilute
	TodoBusinessImpl todoBusinessImpl;
	
	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;

	@Test
	public void testretrieveTodosRelatedToSpring_usingAMock() {

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		// Nurodome kad padavus tam tikrus duomenis i metoda (when) atiduotu pasirinktus
		// duomenis (then)
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		assertEquals(2, filteredTodos.size());
	}

	@Test
	public void testretrieveTodosRelatedToSpring_usingBDD() {

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		// When
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		// Then
		assertThat(filteredTodos.size(), is(2));
	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD() {

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		// When

		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

		// Then
		verify(todoServiceMock).deleteTodo("Learn to Dance");

		verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");
	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCapture() {	

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		// When

		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

		// Then //Define Argument captor on specific method call
		then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());

		// Capture argument
		assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));

	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCaptureMultiple() {

		// Declare argument capture
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

		List<String> todos = Arrays.asList("Learn to rock and roll", "Learn Spring", "Learn to Dance");

		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		// When

		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

		// Then //Define Argument captor on specific method call
		then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());

		// Capture argument
		assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
	}
}
