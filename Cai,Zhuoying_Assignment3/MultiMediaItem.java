/**
 * <h>Multimedia</h>
 * Abstract Multimedia class extends Item super class.
 */

import java.util.Date;

public abstract class MultiMediaItem extends Item
{
    // instance variable
    private final int playingTime;

    /**
     * Class constructor that initialized Multimedia with ID, title, added date and playing time.
     * @param id            This is Multimedia's ID.
     * @param title         This is Multimedia's title.
     * @param addedOn       This is Multimedia's added date.
     * @param playingTime   This is number of times that the multimedia is being played.
     *
     * @exception IllegalArgumentException  On playing time that is less than 0.
     * @see IllegalArgumentException
     */
    public MultiMediaItem(String id, String title, Date addedOn, int playingTime)
    {
        super(id, title, addedOn);

        if (playingTime < 0)
            throw new IllegalArgumentException("ILLEGAL PLAYING TIME");

        this.playingTime = playingTime;
    }

    /**
     * This method retrieves Multimedia's number of times being played.
     * @return int   This returns Multimedia's number of times being played.
     */
    public int getPlayingTime() { return playingTime; }

    /**
     * {@inheritDoc}
     * This method overrides the compareTo method from the Comparable interface with
     * Multimedia.
     * @param item      The object to be compared.
     * @return int      A negative integer, zero, or a positive integer as this
     *                  object is less than, equal to, or greater than the
     *                  specified object.
     */
    @Override
    public int compareTo(Item item)
    {
        // If the item type is Multimedia and their comparison values are the same,
        if (item instanceof MultiMediaItem && super.compareTo(item) == 0)
        {
            // return comparison value of playing time.
            return Integer.compare(this.getPlayingTime(), ((MultiMediaItem) item).getPlayingTime());
        }
        // If compared item type is not Multimedia, call its Item superclass compareTo method.
        else
            return super.compareTo(item);
    }

    /**
     * {@inheritDoc}
     * This method overrides the toString method from the Object superclass.
     * @return String   This prints out the ID, title, added date, and playing time of the item.
     */
    @Override
    public String toString()
    {
        return super.toString() +
                "Playing time: " + playingTime + "\n";
    }
}
