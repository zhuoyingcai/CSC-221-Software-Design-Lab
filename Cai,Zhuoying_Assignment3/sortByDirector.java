/**
 * <h>sortByDirector</h>
 * sortByDirector class that implements Comparator interface.
 */

import java.util.Comparator;

public class sortByDirector implements Comparator<Item>
{
    /**
     * {@inheritDoc}
     * This method overrides the compare method from the Comparator interface with Item's
     * director.
     * <p>
     *     The purpose of overloading this method is to make sort method from Collections
     *     class sorts the specified list according to the order of Item's director name.
     * </p>
     * @param item1     The first Item to be compared.
     * @param item2     The second Item to be compared.
     * @return          A negative integer, zero, or a positive integer as the first
     *                  argument is less than, equal to, or greater than the second.
     */
    @Override
    public int compare(Item item1, Item item2)
    {
        if (item1 instanceof Video && item2 instanceof Video)
        {
            return ((Video) item1).getDirector().compareTo(((Video) item2).getDirector());
        }

        return 0;
    }
}
