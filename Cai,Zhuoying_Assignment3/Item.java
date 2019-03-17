/**
 * <h1>Item</h1>
 * Abstract Item superclass that implements Comparable interface.
 *
 * @author Zhuoying Cai
 * @Since 2017-10-26
 */

import java.lang.Comparable;
import java.util.Date;

public abstract class Item implements Comparable<Item>
{
    /**
     * Instance variables ID, title, and added date.
     */
    private final String id;
    private final String title;
    private final Date addedOn;

    /**
     * Class constructor that initialized item with ID, title and added date.
     * @param id        This is item's ID.
     * @param title     This is item's title.
     * @param addedOn   This is item's added date.
     */
    public Item(String id, String title, Date addedOn)
    {
        this.id = id;
        this.title = title;
        this.addedOn = addedOn;
    }

    /**
     * This method retrieves item's ID.
     * @return String   This returns item's ID.
     */
    public String getId() { return id; }

    /**
     * This method retrieves item's title.
     * @return String   This returns item's title.
     */
    public String getTitle() { return title; }

    /**
     * This method retrieves item's added date.
     * @return      This returns item's added date.
     */
    public Date getAddedOn() { return addedOn; }

    /**
     * {@inheritDoc}
     * This method overrides the compareTo method from the Comparable interface with Item.
     * <p>
     *     The purpose of overriding this method is to make sure all items in the list are
     *     comparable and able to be sorted by the sort method from the Collections class.
     * </p>
     * @param item      The object to be compared.
     * @return int      A negative integer, zero, or a positive integer as this
     *                  object is less than, equal to, or greater than the
     *                  specified object.
     */
    @Override
    public int compareTo(Item item)
    {
        int idEq, titleEq, addedOnEq;

        // Each variable gets the return value after comparing to ID, title and added date.
        idEq = this.getId().compareTo(item.getId());
        titleEq = this.getTitle().compareTo(item.getTitle());
        addedOnEq = this.getAddedOn().compareTo(item.getAddedOn());

        // Returns desired comparison value.
        if (idEq == 0 && titleEq == 0)
            return addedOnEq;
        else if (idEq == 0)
            return titleEq;
        else
            return idEq;
    }

    /**
     * {@inheritDoc}
     * This method overrides the toString method from the Object superclass.
     * @return String   This prints out the ID, title, and added date of the item.
     */
    @Override
    public String toString()
    {
        return "ID: " + id + "\n" +
                "Title: " + title + "\n" +
                "Added Date: " + addedOn + "\n";
    }

}
