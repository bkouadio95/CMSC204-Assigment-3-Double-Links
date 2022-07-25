import java.util.*;

/**
 * 
 * @author Betty Kouadio
 * CMSC 204
 * Assignment 3
 *
 * @param T
 */
public class BasicDoubleLinkedList<T> extends Object implements Iterable<T>
{
    
    protected Node<T> headNode;
    protected Node<T> tailNode;
    protected int listSize;
    

    public BasicDoubleLinkedList()
    {
        headNode = null;
        tailNode = null;
        listSize = 0;
    }

  /**
   * This method just returns the value of the instance variable you use to keep track of size
   * @return the size of the linked list
   */
    public int getSize()
    {
        return listSize;
    }
/**
 * Adds an element to the end of the list 
 * @param data - the data for the Node within the linked list
 * @return reference to the current object
 */
    public BasicDoubleLinkedList<T> addToEnd(T data)
    {
        Node<T> newNode = new Node<T>(data);
        if (listSize == 0) {
            headNode = newNode;
            tailNode = newNode;
        } else {
            tailNode.nextNode = newNode;
            tailNode = newNode;
        }
        listSize++;
        return this;
    }
    /**
     * Adds an element to the front of the list
     * @param data - the data for the Node within the linked list
     * @return reference to the current object
     */
    public BasicDoubleLinkedList<T> addToFront(T data)
    {
        Node<T> newNode = new Node<T>(data);
        if (listSize == 0) {
            headNode = newNode;
            tailNode = newNode;
        } else {
            newNode.nextNode = headNode;
            headNode = newNode;
        }
        listSize++;
        return this;
    }
    /**
     * Returns but does not remove the first element from the list. 
     * If there are no elements the method returns null. 
     * @return the data element or null
     */
    
    public T getFirst()
    {
        if (listSize > 0) {
            return headNode.nodeData;
        } else {
            return null;
        }
    }

  /**
   * Removes and returns the first element from the list. 
   * If there are no elements the method returns null. 
   * @return data element or null
   */
    public T retrieveFirstElement()
    {
        if (listSize > 0) {
            Node<T> currentNode = headNode;
            headNode = headNode.nextNode;
            
            listSize--;
            return currentNode.nodeData;
        } else {
            return null;
        }
    }
/**
 * Returns but does not remove the last element from the list. 
 * If there are no elements the method returns null.
 * @return the data element or null
 */
    public T getLast()
    {
        if (listSize > 0) {
            return tailNode.nodeData;
        } else {
            return null;
        }
    }

/**
 * Removes and returns the last element from the list. 
 * If there are no elements the method returns null. 
 * @return data element or null
 */
    public T retrieveLastElement()
    {
      
        if (listSize > 0) {
            Node<T> currentNode = headNode;
            Node<T> previousNode = null;
            while (currentNode != null) {
                if (currentNode.equals(tailNode)) {
                    tailNode = previousNode;
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.nextNode;
            }

            listSize--;
            return currentNode.nodeData;
            
        } else {
            return null;
        }
    }
/**
 * Returns an arraylist of the items in the list from head of list to tail of list
 * @return an arraylist of the items in the list
 */
    public ArrayList<T> toArrayList()
    {
        ArrayList<T> newList = new ArrayList<T>();
        BasicDoubleLinkedList<T>.Node<T> currentNode = headNode;

        while (currentNode != null) {
            newList.add((T) currentNode.nodeData);
            currentNode = currentNode.nextNode;
        }
        return newList;
    }
    /**
     * 
     * @param ip
     * @param ipPrev
     *
     */

    public class DoubleLinkedListIterator implements ListIterator<T>
    {
    private Node<T> ip;
    private Node<T> ipPrev;
    /**
     * @param ip
     * @param ipPrev
     */
    public DoubleLinkedListIterator()
    {
    ip = headNode;
    ipPrev = null;
    }
    /**
     * @param T
     * @return boolean 
     */
    public T next()
    {
    if(ip != null)
    {
    T returnData = (T) ip.nodeData;
    ipPrev = ip;
    ip = ip.nextNode;
    if(ip != null) ip.prev = ipPrev;
    return returnData;
    }
    else
    throw new NoSuchElementException();
    }
    /**
     * @param next
     * @return boolean 
     */
    public boolean hasNext()
    {
    if(ip==null)
    return false;
    else
    return true;
    }
    /**
     * @param T
     * @return data
     */
    public T previous()
    {
    if(ipPrev != null)
    {
    //T returnData = ip.data;
    ip = ipPrev;
    ipPrev= ip.prev;
    T returnData = ip.nodeData;
    return returnData;
    }
    else
    throw new NoSuchElementException();
    }
    /**
     * @param previous 
     * return boolean
     */
    public boolean hasPrevious()
    {
    if(ipPrev==null)
    return false;
    else
    return true;
    }
    @Override
    /**
     * @param T
     */
    public void add(T arg0) throws UnsupportedOperationException{
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException();
    }
    @Override
    /**
     * @param next index
     */
    public int nextIndex() throws UnsupportedOperationException{
    // TODO Auto-generated method stub
    //return 0;
    throw new UnsupportedOperationException();
    }
    @Override
    /**
     * @param previous index
     */
    public int previousIndex() throws UnsupportedOperationException{
    // TODO Auto-generated method stub
    //return 0;
    throw new UnsupportedOperationException();
    }
    @Override
    /**
     * @param T
     */
    public void remove() throws UnsupportedOperationException{
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException();
    }
    @Override
    /**
     * @param T
     */
    public void set(T arg0) throws UnsupportedOperationException{
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException();
    }
    }
    /**
     * @param T
     * @return new list iterator
     */

    public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException
    {
        // Return new list iterator
        return new DoubleLinkedListIterator();
    }
    /**
     * Removes the first instance of the targetData from the list. Notice that you must remove the elements by performing a single traversal over the list.
     * @param element - the data element to be removed
     * @param comparator the comparator to determine equality of data elements
     * @return data element or null
     */
    public void remove(T element, Comparator<T> comparator)
    {
        // Initialize node pointers
        Node<T> currentNode = headNode;
        Node<T> previousNode = null;

        // Iterate through node list
        while (currentNode != null) {
            // Check if current node data matches query
            if (comparator.compare(currentNode.nodeData, element) == 0) {
                // Check if current node is first/last/middle node
                if (currentNode.equals(headNode)) {
                    headNode = headNode.nextNode;
                } else if (currentNode.equals(tailNode)) {
                    tailNode = previousNode;
                } else {
                    previousNode.nextNode = currentNode.nextNode;
                }
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
        }
    }

   

/**
 *
 * @param <T>
 */
	@SuppressWarnings("hiding")
	protected class Node<T>
    {
        protected Node<T> prev;
		protected T nodeData;
        protected Node<T> nextNode;
/**
 * @param noteData
 * @param nextNode
 */
        public Node()
        {
            nodeData = null;
            nextNode = null;
        }
/**
 * 
 * @param data
 */
        public Node(T data)
        {
            nodeData = data;
        }
/**
 * 
 * @param data
 * @param node
 */
        public Node(T data, Node<T> node)
        {
            nodeData = data;
            nextNode = node;
        }
    }
}