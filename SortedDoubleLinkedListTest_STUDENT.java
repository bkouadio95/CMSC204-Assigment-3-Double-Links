import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Comparator;
import java.util.ListIterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;




public class SortedDoubleLinkedListTest_STUDENT {
	DoubleComparator comparatorD;
	SortedDoubleLinkedList<Double> sortedLinkedDouble;

	

	@Before
	public void setUp() throws Exception {
		
		comparatorD = new DoubleComparator();
		sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);
	}

	@After
	public void tearDown() throws Exception {
		comparatorD = null;
		sortedLinkedDouble = null;
	}

	
	@Test
	//test the add to end.
	
	public void testAddToEndSTUDENT() {
		
		try {
			sortedLinkedDouble.addToEnd(125.20);
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}
	
	

	@Test
	//test the add to front.
	
	public void testAddToFrontSTUDENT() {
		
		
		try {
			sortedLinkedDouble.addToFront(125.21);
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}

	}


	
	@Test
	//test the iterator next. 
	public void testIteratorSuccessfulDoubleNext_STUDENT() {
	
		
		sortedLinkedDouble.add(125.01);
		sortedLinkedDouble.add(74.0);
		sortedLinkedDouble.add(79.25);
		sortedLinkedDouble.add(25.30);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(25.30, iterator.next(),0.0001);
		assertEquals(74.0, iterator.next(),0.0001);
		assertEquals(79.25, iterator.next(),0.001);
		assertEquals(true, iterator.hasNext());
	}
	
	
	@Test
	//test the iterator previous.

	public void testIteratorSuccessfulDoublePrevious_STUDENT() {
		
		
		sortedLinkedDouble.add(584.0);
		sortedLinkedDouble.add(325.01);
		sortedLinkedDouble.add(213.15);
		sortedLinkedDouble.add(125.0);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(125.0, iterator.next(),0.0001);
		assertEquals(213.15, iterator.next(),0.0001);
		assertEquals(325.01, iterator.next(),0.0001);
		assertEquals(584.00, iterator.next(),0.001);
		assertEquals(true, iterator.hasPrevious());
		assertEquals(584.00, iterator.previous(),0.011);
		assertEquals(325.01, iterator.previous(),0.001);
		assertEquals(213.15, iterator.previous(),0.0001);
	}
	
	
	@Test
	//test the iterator next when at the last element in the list. 


	public void testIteratorNoSuchElementException_STUDENT() {
		
		
		sortedLinkedDouble.add(584.0);
		sortedLinkedDouble.add(325.01);
		sortedLinkedDouble.add(213.05);
		sortedLinkedDouble.add(125.50);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		try{
			//remove is not supported for the iterator
			iterator.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}
	
	
	@Test
	//test the iterator remove which is an unsupported operation. 
	
	public void testIteratorUnsupportedOperationExceptionString() {
		
		sortedLinkedDouble.add(584.0);
		sortedLinkedDouble.add(325.01);
		sortedLinkedDouble.add(213.05);
		sortedLinkedDouble.add(125.50);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		try{
			//remove is not supported for the iterator
			iterator.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
		
	}

	@Test
	//test the add method 
	public void testAdd_STUDENT() {
	
		
		sortedLinkedDouble.add(525.0);
		sortedLinkedDouble.add(235.0);
		sortedLinkedDouble.add(548.0);
		assertEquals(235, sortedLinkedDouble.getFirst(),0.0001);
		assertEquals(548, sortedLinkedDouble.getLast(),0.0001);
		sortedLinkedDouble.add(147.0);
		sortedLinkedDouble.add(236.0);
		assertEquals(147, sortedLinkedDouble.getFirst(),0.001);
		assertEquals(548, sortedLinkedDouble.getLast(),0.001);
		//deletes Elephant from linked list
		assertEquals(548,sortedLinkedDouble.retrieveLastElement(),0.001);
		assertEquals(525, sortedLinkedDouble.getLast(),0.001);
	}
	
	
	@Test
	//test the remove element at beginning of the list
	public void testRemoveFirst_STUDENT() {
		
		sortedLinkedDouble.add(645.0);
		sortedLinkedDouble.add(561.0);
		assertEquals(561.0, sortedLinkedDouble.getFirst(),0.001);
		assertEquals(645.0, sortedLinkedDouble.getLast(),0.001);
		sortedLinkedDouble.add(235.0);
		assertEquals(235.0, sortedLinkedDouble.getFirst(),0.001);
		// remove the first
		sortedLinkedDouble.remove(235.0, comparatorD);
		assertEquals(561.0, sortedLinkedDouble.getFirst(),0.0001);
	}
	
	@Test
	//test the remove element at end of the list
	public void testRemoveEnd_STUDENT() {
		sortedLinkedDouble.add(645.0);
		sortedLinkedDouble.add(561.0);
		assertEquals(561.0, sortedLinkedDouble.getFirst(),0.001);
		assertEquals(645.0, sortedLinkedDouble.getLast(),0.001);
		sortedLinkedDouble.add(235.0);
		assertEquals(235.0, sortedLinkedDouble.getFirst(),0.001);
		//remove from the end of the list
		sortedLinkedDouble.remove(645.0, comparatorD);
		assertEquals(561.0, sortedLinkedDouble.getLast(),0.0001);
	}
		
		
	
	
	@Test
	//test the remove element in middle of the list
	public void testRemoveMiddle_STUDENT() {
		
		sortedLinkedDouble.add(645.0);
		sortedLinkedDouble.add(561.0);
		assertEquals(561.0, sortedLinkedDouble.getFirst(),0.001);
		assertEquals(645.0, sortedLinkedDouble.getLast(),0.001);
		sortedLinkedDouble.add(235.0);
		assertEquals(235.0, sortedLinkedDouble.getFirst(),0.001);
		assertEquals(645, sortedLinkedDouble.getLast(),0.001);
		assertEquals(3,sortedLinkedDouble.getSize());
		//remove from middle of list
		sortedLinkedDouble.remove(645.0, comparatorD);
		assertEquals(235.0, sortedLinkedDouble.getFirst(),0.001);
		assertEquals(561.0, sortedLinkedDouble.getLast(),0.0001);
		assertEquals(3,sortedLinkedDouble.getSize());
	}

	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			return arg0.compareTo(arg1);
		}
		
	}
}
