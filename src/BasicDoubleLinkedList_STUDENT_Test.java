import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BasicDoubleLinkedList_STUDENT_Test {
	BasicDoubleLinkedList<Double> linkedDouble;
	DoubleComparator comparatorD;

	@Before
	public void setUp() throws Exception {
		
		
		linkedDouble = new BasicDoubleLinkedList<Double>();
		//add doubles to the linkedDouble list
		
		
		linkedDouble.addToEnd(19.0);
		linkedDouble.addToEnd(105.0);
		linkedDouble.addToEnd(210.0);
		comparatorD = new DoubleComparator();
		
	}

	@After
	public void tearDown() throws Exception {
		linkedDouble = null;
		comparatorD = null;
	}

	@Test
	public void testGetSize() {
		
		
		assertEquals(3,linkedDouble.getSize());
	}
	
	@Test
	public void testAddToEndSTUDENT(){
		//test addToEnd for the linkedDouble
		
		
		assertEquals(210.0, linkedDouble.getLast(),0.001);
		linkedDouble.addToEnd(75.0);
		assertEquals(75.0, linkedDouble.getLast(),0.0001);
	}
	

	@Test
	public void testAddToFrontSTUDENT(){
		//test addToFront for the linkedDouble
		
		
		assertEquals(19.0, linkedDouble.getFirst(),0.001);
		linkedDouble.addToFront(125.0);
		assertEquals(125.0, linkedDouble.getFirst(),0.001);
	}



	@Test
	public void testGetFirstSTUDENT(){
		//test getFirst for the linkedDouble
		
		
		assertEquals(19.0, linkedDouble.getFirst(),0.0001);
		linkedDouble.addToFront(235.0);
		assertEquals(235.0, linkedDouble.getFirst(),0.001);
		
	}

	@Test
	public void testGetLastSTUDENT(){
		//test getLast for the linkedDouble
		
		
		
		assertEquals(210.0, linkedDouble.getLast(),0.001);
		linkedDouble.addToEnd(52.25);
		assertEquals(52.25, linkedDouble.getLast(),0.001);
	}
	
	@Test
	public void testToArraySTUDENT(){
		//test toArray for the linkedDouble
		
		
		
		ArrayList<Double> list;
		linkedDouble.addToFront(215.0);
		linkedDouble.addToEnd(154.0);
		list = linkedDouble.toArrayList();
		assertEquals(215.0, list.get(0),0.001);
		assertEquals(19.0, list.get(1),0.001);
		assertEquals(105.0, list.get(2),0.001);
		assertEquals(210.0, list.get(3),0.001);
		assertEquals(154.0, list.get(4),0.001);
	}
	
	@Test
	public void testIteratorSuccessfulNextSTUDENT(){
		//test the iterator for the linkedDouble
		
		linkedDouble.addToFront(451.0);
		linkedDouble.addToEnd(314.20);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(451.0, iterator.next(),0.001);
		assertEquals(19.0, iterator.next(),0.001);
		assertEquals(105.0, iterator.next(),0.001);
		assertEquals(true, iterator.hasNext());
		assertEquals(210.0, iterator.next(),0.001);
	}
	
	@Test
	public void testIteratorSuccessfulPreviousSTUDENT(){
		//test the iterator for the linkedDouble
		
		
		linkedDouble.addToFront(125.0);
		linkedDouble.addToEnd(213.0);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(125.0, iterator.next(),0.001);
		assertEquals(19.0, iterator.next(),0.001);
		assertEquals(105.0, iterator.next(),0.0001);
		assertEquals(true, iterator.hasPrevious());
		assertEquals(105.0, iterator.previous(),0.0001);
		assertEquals(19.0, iterator.previous(),0.0001);
	}
	
	
	@Test
	public void testIteratorNoSuchElementExceptionNextSTUDENT(){
		//test the iterator for the linkedDouble. 
		
		linkedDouble.addToFront(87.25);
		linkedDouble.addToEnd(251.25);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(87.25, iterator.next(), 0.0001);
		assertEquals(19.0, iterator.next(), 0.0001);
		assertEquals(105.0, iterator.next(), 0.0001);
		assertEquals(true, iterator.hasNext());
		assertEquals(210.0, iterator.next(), 0.0001);
		assertEquals(251.25, iterator.next(), 0.0001);
		try{
			
			iterator.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionPreviousSTUDENT(){
		//test the iterator for the linkedDouble. 
		
		linkedDouble.addToFront(124.0);
		linkedDouble.addToEnd(864.01);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(124.0, iterator.next(),0.001);
		assertEquals(19.0, iterator.next(),0.001);
		assertEquals(105.0, iterator.next(),0.001);
		assertEquals(210.0, iterator.next(),0.001);
		assertEquals(true, iterator.hasNext());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(210.0, iterator.previous(),0.001);
		assertEquals(105.0, iterator.previous(),0.001);
		assertEquals(19.0, iterator.previous(),0.001);
		assertEquals(124.0, iterator.previous(),0.001);
		try{
			//no more elements in list
			iterator.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}

	@Test
	public void testIteratorUnsupportedOperationExceptionSTUDENT(){
		//test the remove method for the iterator for the linkedDouble
		
		
		linkedDouble.addToFront(123.0);
		linkedDouble.addToEnd(125.14);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(123.0, iterator.next(),0.001);
		assertEquals(19.0, iterator.next(),0.0001);
		assertEquals(105.0, iterator.next(),0.001);
		assertEquals(true, iterator.hasNext());
		assertEquals(210.0, iterator.next(),0.001);
		
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
	public void testRemoveSTUDENT(){
		//test the remove method for the linkedDouble
		
		
		// remove the first
				assertEquals(19.0, linkedDouble.getFirst(),0.001);
				assertEquals(210.0, linkedDouble.getLast(),0.0001);
				linkedDouble.addToFront(351.21);
				assertEquals(351.21, linkedDouble.getFirst(),0.0001);
				linkedDouble.remove(351.21, comparatorD);
				assertEquals(19.0, linkedDouble.getFirst(),0.001);
				//remove from the end of the list
				linkedDouble.addToEnd(215.0);
				assertEquals(215.0, linkedDouble.getLast(),0.001);
				linkedDouble.remove(215.0, comparatorD);
				assertEquals(210.0, linkedDouble.getLast(),0.001);
				//remove from middle of list
				linkedDouble.addToFront(178.20);
				assertEquals(178.20, linkedDouble.getFirst(),0.001);
				assertEquals(210.0, linkedDouble.getLast(),0.001);
				linkedDouble.remove(178.20, comparatorD);
				assertEquals(19.0, linkedDouble.getFirst(),0.001);
				assertEquals(210.0, linkedDouble.getLast(),0.001);
				
	}
	
	@Test
	public void testRetrieveFirstElementSTUDENT(){
		//test retrieveLastElement for linkedDouble
		
		
		
		assertEquals(19.0, linkedDouble.getFirst(),0.001);
		linkedDouble.addToFront(125.01);
		assertEquals(125.01, linkedDouble.getFirst(),0.001);
		assertEquals(125.01, linkedDouble.retrieveFirstElement(),0.001);
		assertEquals(19.0,linkedDouble.getFirst(),0.001);
		assertEquals(19.0, linkedDouble.retrieveFirstElement(),0.001);
		assertEquals(105.0,linkedDouble.getFirst(),0.001);
		
	}
	
	@Test
	public void testRetrieveLastElementSTUDENT(){
		//test retrieveLastElement for linkedDouble
		
		
		
		assertEquals(210.0, linkedDouble.getLast(),0.0001);
		linkedDouble.addToEnd(421.0);
		assertEquals(421.0, linkedDouble.getLast(),0.0001);
		assertEquals(421.0, linkedDouble.retrieveLastElement(),0.001);
		assertEquals(210.0,linkedDouble.getLast(),0.0001);

	}

	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			
			
			return arg0.compareTo(arg1);
		}
		
	}
}
