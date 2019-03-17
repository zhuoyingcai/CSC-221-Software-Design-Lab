/**
 * <h>CD</h>
 * Concrete Textbook subclass extents Multimedia superclass.
 */

import java.util.Date;

public class CD extends MultiMediaItem
{
    // instance variable
    private final String artist;

    /**
     * Class constructor that initialized CD with ID, title, added date, playing time
     * and artist name.
     * @param id            This is CD's ID.
     * @param title         This is CD's title.
     * @param addedOn       This is CD's added date.
     * @param playingTime   This is number of times that the CD is being played.
     * @param artist        This is artist's name of CD.
     *
     * @exception IllegalArgumentException  On playing time that is less than 0.
     * @see IllegalArgumentException
     */
    public CD(String id, String title, Date addedOn, int playingTime, String artist)
    {
        super(id, title, addedOn, playingTime);

        if (playingTime < 0)
            throw new IllegalArgumentException("ILLEGAL PLAYING TIME");

        this.artist = artist;
    }

    /**
     * This method retrieves CD's artist name.
     * @return String   This returns CD's artist name.
     */
    public String getArtist() { return artist; }


    /**
     * {@inheritDoc}
     * This method overrides the compareTo method from the Comparable interface with CD.
     * @param item      The object to be compared.
     * @return int      A negative integer, zero, or a positive integer as this
     *                  object is less than, equal to, or greater than the
     *                  specified object.
     */
    @Override
    public int compareTo(Item item)
    {
        // If the item type is CD, do comparison and get return value.
        if (item instanceof CD)
        {
            // If all comparison values for ID, title, added date, and playing time are the same,
           if (super.compareTo(item) == 0)
               // return comparison value of artist name.
               return this.getArtist().compareTo(((CD) item).getArtist());
           else
               return super.compareTo(item);
        }
        // If compared item type is not CD, call its Multimedia superclass compareTo method.
        else
        {
            return super.compareTo(item);
        }
    }

    /**
     * {@inheritDoc}
     * This method overrides the toString method from the Object superclass.
     * @return String   This prints out the ID, title, added date, playing time and artist
     *                  name of the item.
     */
    @Override
    public String toString()
    {
        return super.toString() +
                "Artist: " + artist + "\n\n";
    }
}
