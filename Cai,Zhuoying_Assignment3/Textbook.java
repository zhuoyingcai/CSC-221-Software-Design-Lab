/**
 * <h>Textbook</h>
 * Concrete Textbook subclass extents Item superclass.
 */

import java.util.Date;

public class Textbook extends Item
{
    // instance variable
    private final String author;

    /**
     * Class constructor that initialized Textbook with ID, title, added date and author name.
     * @param id        This is Textbook's ID.
     * @param title     This is Textbook's title.
     * @param addedOn   This is Textbook's added date.
     * @param author    This is Textbook's author name.
     */
    public Textbook(String id, String title, Date addedOn, String author)
    {
        super(id, title, addedOn);

        this.author = author;
    }

    /**
     * This method retrieves Textbook's author name.
     * @return String   This returns Textbook's author name.
     */
    public String getAuthor() { return author; }

    /**
     * {@inheritDoc}
     * This method overrides the compareTo method from the Comparable interface with
     * Textbook.
     * @param item      The object to be compared.
     * @return int      A negative integer, zero, or a positive integer as this
     *                  object is less than, equal to, or greater than the
     *                  specified object.
     */
    @Override
    public int compareTo(Item item)
    {
        // If the item type is Textbook, do comparison and get return value.
        if (item instanceof Textbook)
        {
            // If all comparison values for ID, title, and added date are the same,
            if (super.compareTo(item) == 0)
                // return comparison value of author name.
                return this.getAuthor().compareTo(((Textbook) item).getAuthor());
            else
                return super.compareTo(item);
        }
        // If compared item type is not Textbook, call its Item superclass compareTo method.
        else
        {
            return super.compareTo(item);
        }
    }

    /**
     * {@inheritDoc}
     * This method overrides the toString method from the Object superclass.
     * @return String   This prints out the ID, title, added date, and author of the item.
     */
    @Override
    public String toString()
    {
        return super.toString() +
                "Author: " + author + "\n\n";
    }
}