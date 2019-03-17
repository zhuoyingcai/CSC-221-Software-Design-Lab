/**
 * <h>sortByAddedOn</h>
 * sortByAddedOn class that implements Comparator interface.
 */

import java.util.Comparator;

public class sortByAddedOn implements Comparator<Item>
{
    /**
     * {@inheritDoc}
     * This method overrides the compare method from the Comparator interface with Item's
     * added date.
     * <p>
     *     The purpose of overloading this method is to make sort method from Collections
     *     class sorts the specified list according to the order of Item's added date.
     * </p>
     * @param item1     The first Item to be compared.
     * @param item2     The second Item to be compared.
     * @return          A negative integer, zero, or a positive integer as the first
     *                  argument is less than, equal to, or greater than the second.
     */
    @Override
    public int compare(Item item1, Item item2)
    {
        return item1.getAddedOn().compareTo(item2.getAddedOn());
    }

}
