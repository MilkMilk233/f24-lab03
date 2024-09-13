package edu.cmu.cs.cs214.rec04;

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Zhixin Chen
 *
 */

public class InheritanceSortedIntList extends SortedIntList{
    private int totalAdded;

    public InheritanceSortedIntList() {
        totalAdded = 0;
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
      return super.add(num);
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
     * Fetch the number of the total adds.
     *
     * @return the number of total adds.
     */
   public int getTotalAdded(){
    System.out.printf("%d", this.totalAdded);
    return this.totalAdded;
}

}