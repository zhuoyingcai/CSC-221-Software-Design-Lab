/**
 * <h1>Database</h1>
 * The library database holds the information of material resources in use for
 * students in that school.
 *
 * @author Zhuoying Cai
 * @since 2017-10-26
 */

import java.util.*;

public class Database
{
    private List<Item> item; // instance list

    /**
     * Class constructor creates an arrayList to hold the items in the library.
     */
    public Database()
      {
          item = new ArrayList<>();
      }

    /**
     * This method is used to retrieve all the items in the arrayList.
     * @return List     This returns all the items that store in the arrayList.
     */
    public List<Item> getItem() { return item; }

    /**
     * This method is used to add item to the arrayList.
     * @param source    This is the item to add to the arrayList.
     */
    public void addItem(Item source) { item.add(source); }

    /**
     * This method is used to print out all the items in the arrayList.
     */
    public void list()
    {
        for(Item source : item)
        {
            System.out.printf("%s",source);
        }
    }
}
