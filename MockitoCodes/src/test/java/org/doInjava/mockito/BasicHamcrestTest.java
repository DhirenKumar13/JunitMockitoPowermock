package org.doInjava.mockito;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class BasicHamcrestTest {
	
	@Test
	public void hamcrestmatchersTest() {
		List<Integer> scores = Arrays.asList(99,100,105,104,213);
		assertThat(scores,hasSize(5));
		assertThat(scores,hasItem(99));
		assertThat(scores,hasItems(99,100));
		assertThat(scores,everyItem(greaterThan(98)));
	}
	
}
