package com.tuenti.util.list;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The Class SortedList.
 * A sorted list implementation
 * @param <E> the element type
 */
public class SortedList<E> extends AbstractList<E> {

    /** The internal list. */
    private ArrayList<E> internalList = new ArrayList<E>();
   
    /* (non-Javadoc)
     * @see java.util.AbstractList#add(int, java.lang.Object)
     */
    @Override 
    public void add(int position, E e) {
        internalList.add(e);
        //Collections.sort(internalList, null);
    }

    /* (non-Javadoc)
     * @see java.util.AbstractList#get(int)
     */
    @Override
    public E get(int i) {
        return internalList.get(i);
    }

    /* (non-Javadoc)
     * @see java.util.AbstractCollection#size()
     */
    @Override
    public int size() {    	
        return internalList.size();
    }

	@Override
	public E remove(int index) {		
		return internalList.remove(index);
	}
	
	public void sort(){
		Collections.sort(internalList, null);
		
	}
    
    
    

}