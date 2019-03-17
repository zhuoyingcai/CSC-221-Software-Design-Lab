/**
 * <h>Video</h>
 * Concrete Video subclass extents Multimedia superclass.
 */

import java.util.Date;

public class Video extends MultiMediaItem
{
    // instance variable
    private final String director;

    /**
     * Class constructor that initialized Video with ID, title, added date, playing time
     * and director's name.
     * @param id            This is Video's ID.
     * @param title         This is Video's title.
     * @param addedOn       This is Video's added date.
     * @param playingTime   This is number of times that the Video is being played.
     * @param director      This is director's name of Video.
     *
     * @exception IllegalArgumentException  On playing time that is less than 0.
     * @see IllegalArgumentException
     */
    public Video(String id, String title, Date addedOn, int playingTime, String director)
    {
        super(id, title, addedOn, playingTime);

        if (playingTime < 0)
            throw new IllegalArgumentException("ILLEGAL PLAYING TIME");

        this.director = director;
    }

    /**
     * This method retrieves Video's director name.
     * @return String   This returns Video's director name.
     */
    public String getDirector() { return director; }

    /**
     * {@inheritDoc}
     * This method overrides the compareTo method from the Comparable interface with Video.
     * @param item      The object to be compared.
     * @return int      A negative integer, zero, or a positive integer as this
     *                  object is less than, equal to, or greater than the
     *                  specified object.
     */
    @Override
    public int compareTo(Item item)
    {
        // If the item type is Video, do comparison and get return value.
        if (item instanceof Video)
        {
            // If all comparison values for ID, title, added date, and playing time are the same
            if (super.compareTo(item) == 0)
                // return comparison value of director name.
                return this.getDirector().compareTo(((Video) item).getDirector());
            else
                return super.compareTo(item);
        }
        // If compared item type is not Video, call its Multimedia superclass compareTo method.
        else
        {
            return super.compareTo(item);
        }
    }

    /**
     * {@inheritDoc}
     * This method overrides the toString method from the Object superclass.
     * @return String   This prints out the ID, title, added date, playing time and director
     *                  name of the item.
     */
    @Override
    public String toString()
    {
        return super.toString() +
                "Director: " + director + "\n\n";
    }
}
