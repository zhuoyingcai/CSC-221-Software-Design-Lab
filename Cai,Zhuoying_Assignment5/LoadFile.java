import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.util.ArrayList;

public class LoadFile
{
    private static ObjectInputStream input;

    /**
     * This method is used to choose the path and open the file
     * @param path This is the path where the user want to open the file
     */
    public static void openFile(Path path)
    {
        try
        {
            FileInputStream file = new FileInputStream(path.toString());
            input = new ObjectInputStream(file);
        } catch (IOException ioExpection)
        {
            System.err.println("Error opening file.");
            System.exit(1);
        }
    }

    /**
     * This method is used to read the arralist of myShape.
     */
    public static ArrayList<MyShape> readRecords()
    {
        ArrayList<MyShape> myShapes = null;

        try
        {
            myShapes = (ArrayList<MyShape>) input.readObject();
        } catch (EOFException endOfFileException)
        {
            System.out.printf("No more records%n");
        } catch (ClassNotFoundException classNotFoundException)
        {
            System.err.println("Invalid object type. Terminating.");
        } catch (IOException ioException)
        {
            System.err.println("Error reading from file. Terminating.");
        }

        return myShapes;
    }

    /**
     * This method is used to close the file when the user is finishing saving the file.
     */
    public static void closeFile()
    {
        try
        {
            if (input != null)
                input.close();
        } catch (IOException ioException)
        {
            System.err.println("Error closing file. Terminating");
        }
    }
}

