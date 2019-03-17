/**
 * <h1>Target-Heart-Rate Calculator</h1>
 * The HeartRate program implements an application that records user's
 * information, such as first name, last name, and date of birth, and using
 * this information to calculate user's age, maximum heart rate, and target
 * heart rate.
 *
 * @author Zhuoying Cai
 * @since  2017-09-22
 */

public class HeartRates
{
    private String FirstName, LastName, Month, Day, Year; // instance variable

    /**
     * This is default constructor.
     */
    public HeartRates() {}

    /**
     * This constructor initializes object with first name, last name, month,
     * day, and year of the user.
     * @param FirstName This is user's first name.
     * @param LastName  This is user's last name.
     * @param Month     This is user's month of birthday.
     * @param Day       This is user's day of birthday.
     * @param Year      This is user's year of birthday.
     * @exception IllegalArgumentException On invalid input of month (> 12 or <= 0)
     *                                     On invalid input of day (> 31 or <= 0)
     *                                     On invalid input of year (> 2017 or <= 0)
     * @see IllegalArgumentException
     */
    public HeartRates(String FirstName, String LastName, String Month, String Day, String Year)
    {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Month = Month;
        this.Day = Day;
        this.Year = Year;

        if (Integer.parseInt(Month) > 12 || Integer.parseInt(Month) <= 0)
            throw new IllegalArgumentException("INVALID MONTH");

        if (Integer.parseInt(Day) > 31 || Integer.parseInt(Day) <= 0)
            throw new IllegalArgumentException("INVALID DAY");

        if (Integer.parseInt(Year) > 2017 || Integer.parseInt(Year) <= 0)
            throw new IllegalArgumentException("INVALID YEAR");
    }

    /**
     * This method is used to set the first name.
     * @param FirstName This is user's first name.
     */
    public void setFirstName(String FirstName) { this.FirstName = FirstName; }

    /**
     * This method is used to set the last name.
     * @param LastName This is user's last name.
     */
    public void setLastName(String LastName) { this.LastName = LastName; }

    /**
     * This method is used to set the month of birthday (eg.MM).
     * @param Month This is user's month of birthday.
     * @exception IllegalArgumentException On input greater than 12 or
     *                                     less or equal to 0.
     * @see IllegalArgumentException
     */
    public void setMonth(String Month)
    {
        if (Integer.parseInt(Month) > 12 || Integer.parseInt(Month) <= 0)
            throw new IllegalArgumentException("INVALID MONTH");
        this.Month = Month;
    }

    /**
     * This method is used to set the day of birthday (eg. DD).
     * @param Day This is user's day of birthday.
     * @exception IllegalArgumentException On input greater than 31 or
     *                                     less or equal tp 0.
     * @see IllegalArgumentException
     */
    public void setDay(String Day)
    {
        if (Integer.parseInt(Day) > 31 || Integer.parseInt(Day) <= 0)
            throw new IllegalArgumentException("INVALID DAY");
        this.Day = Day;
    }

    /**
     * This method is used to set the year of birthday (eg. YYYY).
     * @param Year This is user's year of birthday.
     * @exception IllegalArgumentException On input greater than 2017 or
     *                                     less or equal to 0.
     * @see IllegalArgumentException
     */
    public void setYear(String Year)
    {
        if (Integer.parseInt(Year) > 2017 || Integer.parseInt(Year) <= 0)
            throw new IllegalArgumentException("INVALID YEAR");
        this.Year = Year;
    }

    /**
     * This method is used to retrieve the first name.
     * @return String This returns user's first name.
     */
    public String getFirstName() { return FirstName; }

    /**
     * This method is used to retrieve the last name.
     * @return String This returns user's last name.
     */
    public String getLastName() { return LastName; }

    /**
     * This method is used to retrieve the month of birthday.
     * @return String This returns user's month of birthday.
     */
    public String getMonth() { return Month; }

    /**
     * This method is used to retrieve the day of birthday.
     * @return String This returns user's day of birthday.
     */
    public String getDay() { return Day; }

    /**
     * This method is used to retrieve the year of birthday.
     * @return String This returns user's year of birthday.
     */
    public String getYear() { return Year; }

    /**
     * This method is used to calculate user's age. Use current year, 2017,
     * minus the year of user's birthday.
     * @return int This returns user's age.
     */
    public int Age()
    {
        int value = Integer.valueOf(Year);
        int result = 2017 - value;
        return result;
    }

    /**
     * This method is used to calculate user's maximum heart rate. Use 220
     * minus user's age in years.
     * @return int This returns user's maximum heart rate.
     */
    public int MaxHeartRate()
    {
        int Maximum = 220 - Age();
        return Maximum;
    }

    /**
     * This method is used to calculate user's target heart rate, which is
     * 50% - 85% of user's maximum heart rate.
     * @return double[] This returns the lower and upper range of user's target
     *                  heart rate.
     */
    public double[] TargetHeartRate()
    {
        double[] Range = new double[2];
        Range[0] = MaxHeartRate() * 0.5;
        Range[1] = MaxHeartRate() * 0.85;
        return Range; // returning two values at once
    }
}
