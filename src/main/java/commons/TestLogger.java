package commons;

/**
 * Created By Alexandr Kolesov 26.11.2019
 */
public class TestLogger {

    private static StringBuilder instance = new StringBuilder();
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";


    public static synchronized String getResult()
    {
        return instance.toString();
    }

    public static synchronized void clear()
    {
        instance.setLength(0);
    }

    public static synchronized void message(String messageText, Boolean needDate, Boolean isBeginningMessage)
    {
        String msg = (needDate ? TestTools.getCurrentDataTime(DATE_FORMAT) + messageText :  messageText + "\n");

        if (isBeginningMessage)
            instance.insert(0, msg);
        else
            instance.append(msg);

        System.out.println(msg);
    }

    public static synchronized void warn(String messageText)
    {
        String msg = "WARN " + messageText;
        instance.append(msg);
        System.out.println(msg);
    }


    public static synchronized void error(String messageText)
    {
        String msg = "ERROR " + messageText;
        instance.append(msg);
        System.out.println(msg);
    }

}
