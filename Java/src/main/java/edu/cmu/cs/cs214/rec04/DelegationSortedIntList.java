package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Zhixin Chen
 *
 */

public class DelegationSortedIntList extends SortedIntList {
    // Write your implementation below with API documentation
    private final SortedIntList sortedlist;
    private int totalAdded;

    public DelegationSortedIntList(){
        this.totalAdded = 0;
        this.sortedlist = new SortedIntList();
    }

    /**
     * Adds the specified int to the list, meanwhile record the number of the adds.
     *
     * @param num an integer to be added to the list
     * @return true if the list is changed as a result of the call
     */
    @Override
    public boolean add(int num) {
        this.totalAdded++;
        return this.sortedlist.add(num);
    }

    /**
     * Adds all of the elements of the IntegerList to the list.
     *
     * @param list IntegerList containing elements to be added to the list
     * @return true if the list changed as a result of the call
     */
    @Override
    public boolean addAll(IntegerList list) {
        boolean status = true;
        for (int i = 0; i < list.size(); i++) {
            status &= this.add(list.get(i));
            if(!status) return false;  
        }
        return true;    
    }

    /**
     * Returns the integer at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    @Override
    public int get(int index) {
        return this.sortedlist.get(index);
    }

    /**
     * Removes the first occurrence of the specified element from the list,
     * if it is present (optional operation).
     *
     * @param num an integer to be removed from the list, if present
     * @return true if an element was removed as a result of this call
     */
    @Override
    public boolean remove(int num) {
        return this.remove(num);
    }

    /**
     * Removes from the list all of its elements that are contained in the
     * specified IntegerList.
     *
     * @param list IntegerList containing elements to be removed from
     * the list
     * @return true if the list changed as a result of the call
     */
    @Override
    public boolean removeAll(IntegerList list) {
        return this.sortedlist.removeAll(list);
    }
    
    /**
     * Returns the number of elements in this list. If this list contains
     * more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
     *
     * @return number of elements in the list
     */
    @Override
    public int size() {
        return this.sortedlist.size();
    }

    /**
     * Fetch the number of the total adds.
     *
     * @return the number of total adds.
     */
    public int getTotalAdded(){
        return this.totalAdded;
    }


}