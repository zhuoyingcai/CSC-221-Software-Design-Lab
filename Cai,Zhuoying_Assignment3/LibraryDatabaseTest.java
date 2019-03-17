import java.util.*;
import org.apache.commons.collections4.comparators.ComparatorChain;

public class LibraryDatabaseTest
{
    public static void main(String args[])
    {
        Database library = new Database();
        Calendar cal = Calendar.getInstance();

        cal.set(2002, Calendar.FEBRUARY, 29);
        Date date = (Date) cal.getTime();
        Textbook book = new Textbook("U", "Text9", date, "John Doe");
        Textbook book2 = new Textbook("TEXT01", "Text", date, "John Doe");
        Textbook book3 = new Textbook("TEXT01", "Text", date, "Zoey");
        CD cd = new CD("CD01", "myF", date, 3, "GUN&ROSE");
        Video video = new Video("V01", "myF", date, 2, "Jack");

        System.out.println("----- compareTo() Testing -----\n");
        System.out.println("book2 compare to book3: " + book2.compareTo(book3));
        System.out.println("book compare to cd: " + book.compareTo(cd));
        System.out.println("video compare to book3: " + video.compareTo(book3));
        System.out.println("cd compare to video: " + cd.compareTo(video) + "\n");

        System.out.println("----- Invalid Playing Time Testing -----\n");
        try
        {
            library.addItem( new CD("CD01", "myF", date, -1, "GUN&ROSE"));
        } catch (Exception e)
        {
            System.out.println("ERROR: Invalid playing time. Please check again\n");
        }

        // if an error is caught, the item will not able to add into the library.
        library.list();


        ComparatorChain<Item> chain = new ComparatorChain<>();

        // adding database entries
        cal.set(1890, Calendar.AUGUST, 10);
        date = (Date) cal.getTime();
        library.addItem(new Textbook("TB15", "TextX", date, "John Doe"));

        cal.set(1954, Calendar.JANUARY, 18);
        date = (Date) cal.getTime() ;
        library.addItem(new Video("V09", "VideoB", date, 70000, "J. Smith"));

        cal.set(2000, Calendar.FEBRUARY, 29);
        date = (Date) cal.getTime() ;
        library.addItem(new Textbook("TB01", "TextY", date, "John Doe"));

        cal.set(2000, Calendar.FEBRUARY, 29);
        date = (Date) cal.getTime() ;
        library.addItem(new CD("CD07", "CD1", date, 1000, "B.D."));

        cal.set(1990, Calendar.APRIL, 30);
        date = (Date) cal.getTime() ;
        library.addItem(new CD("CD10", "CD1", date, 800, "X.Y."));

        cal.set(2000, Calendar.FEBRUARY, 29);
        date = (Date) cal.getTime();
        library.addItem(new CD("CD05", "CD1", date, 1000, "B.C."));

        cal.set(1890, Calendar.JULY, 2);
        date = (Date) cal.getTime();
        library.addItem(new Video("V12", "VideoA", date, 7000, "Joe Smith"));

        // print unsorted database
        System.out.println("----- DATABASE BEFORE SORTING: -----\n");
        library.list();

        // sort and print sorted database (by id)
        Collections.sort(library.getItem());
        System.out.println("----- DATABASE AFTER SORTING BY ID (default): -----\n");
        library.list();
        // sort by other fields
        System.out.println("----- DATABASE AFTER SORTING BY OTHER FIELDS: -----");
        System.out.println("------------ (title, addedOn, director) -----------\n");
        chain.addComparator(new sortByTitle());
        chain.addComparator(new sortByAddedOn());
        chain.addComparator(new sortByDirector());
        Collections.sort(library.getItem(), chain);
        library.list();
    }
}
