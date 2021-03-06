package org.doInjava.mockito;

import static org.junit.Assert.*;

import java.util.List;

import org.doInjava.data.api.TodoService;
import org.doInjava.data.api.TodoServiceStub;
import org.doInjava.data.business.TodoBusinessImpl;
import org.junit.Test;

public class TodoServiceStubTest {

	@Test
	public void test() {
		TodoService serviceStubbed = new TodoServiceStub();
		TodoBusinessImpl impl = new TodoBusinessImpl(serviceStubbed);
		List<String> filteredList = impl.retrieveTodosRelatedToSpring("Dhiren");
		assertEquals(3,filteredList.size());
	}

}
