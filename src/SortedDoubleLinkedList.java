import java.util.Comparator;
import java.util.ListIterator;


/**
 * 
 * @author Betty Kouadio
 * CMSC 204
 * Assignment 3
 *
 * @param <T>
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>
{
    
    private Comparator<T> comparator;
/**
 * Creates an empty list that is associated with the specified comparator
 * @param c - comparator to compare data element
 */
    public SortedDoubleLinkedList(Comparator<T> c)
    {
        comparator = c;
    }

    /**
     * Inserts the specified element at the correct
     * position in the sorted list. Notice we can insert 
     * the same element several times. Your implementation
     * must traverse the list only once in order to perform the insertion
     * @param data - the data to be added to the list
     * @return a reference to the current object
     */
    public SortedDoubleLinkedList<T> add(T data)
    {
        Node<T> testNode = new Node<T>(data);

        if (listSize > 0) {
            
            Node<T> currentNode = headNode;
            Node<T> previousNode = null;

            int comparison;

            while (currentNode != null) {
                comparison = comparator.compare(testNode.nodeData, currentNode.nodeData);
                if (comparison == 0) {
                    testNode.nextNode = currentNode.nextNode;
                    currentNode.nextNode = testNode;
                    break;
                    
                } else if (comparison < 0) {
                    if (currentNode.equals(headNode)) {
                        testNode.nextNode = currentNode;
                        headNode = testNode;
                    } else {
                        testNode.nextNode = currentNode;
                        previousNode.nextNode = testNode;
                    }

                    break;
                } else if (comparison > 0) {
                    if (currentNode.equals(tailNode)) {
                        tailNode.nextNode = testNode;
                        tailNode = testNode;

                        
                        break;
                    } else {
                       
                        previousNode = currentNode;
                        currentNode = currentNode.nextNode;
                    }
                }
            }
        } 
        
        else {

            headNode = testNode;
            tailNode = testNode;
        }
        listSize++;
        return this;
    }

    /**
     * This operation is invalid for a sorted list. An UnsupportedOperationException will be generated using the message "Invalid operation for sorted list."
     * @param data - the data for the Node within the linked list
     */
    public SortedDoubleLinkedList<T> addToEnd(T data)
    {
        // Throw exception
        throw new UnsupportedOperationException("addToEnd() is unsupported for a sorted list");
    }

  /**
   * This operation is invalid for a sorted list. An UnsupportedOperationException will be generated using the message "Invalid operation for sorted list."
   * @param data - the data for the node within the linked list
   * @return reference to the current object
   * @throws UnsupportedOperationException
   */
    public BasicDoubleLinkedList<T> addToFront(T data)
    {
        throw new UnsupportedOperationException("addToFront() is unsupported for a sorted list");
    }

    /**
     * Creates and returns new list iterator
     *
     * @return New iterator
     */
    
    public ListIterator<T> iterator()
    {
        return super.iterator();
    }
}
	


