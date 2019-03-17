import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.ArrayList;

public class SaveFile
{
    private static ObjectOutputStream output;

    /**
     * This method is used to choose the path and open the file
     * @param path This is the path where the user want to save the file
     */
    public static void openFile(Path path)
    {
        try
        {
            FileOutputStream file = new FileOutputStream(path.toString() + ".ser");
            output = new ObjectOutputStream(file);
        }
        catch (IOException ioException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
    }

    /**
     * This method is used to save the arralist of myShape to the file.
     * @param myShape This is the Arraylist that contains all the shapes that the user draws.
     */
    public static void addRecords(ArrayList<MyShape> myShape)
    {
        try
        {
            output.writeObject(myShape);
        } catch (IOException ioException)
        {
            System.err.println("Error writing to file. Terminating.");
        }
    }

    /**
     * This method is used to close the file when the user is finishing saving the file.
     */
    public static void closeFile()
    {
        try
        {
            if (output != null)
                output.close();
        }
        catch (IOException ioException)
        {
            System.err.println("Error closing file. Terminating");
        }
    }
}
