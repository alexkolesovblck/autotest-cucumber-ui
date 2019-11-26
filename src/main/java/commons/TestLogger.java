package commons;

public class TestLogger {

    private static StringBuilder _instance = new StringBuilder();
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";


    public static synchronized String getResult()
    {
        return _instance.toString();
    }

    public static synchronized void clear()
    {
        _instance.setLength(0);
    }

    public static synchronized void message(String messageText, Boolean needDate, Boolean isBeginningMessage)
    {
        String msg = (needDate ? TestTools.getCurrentDataTime(DATE_FORMAT) + messageText :  messageText + "\n");

        if (isBeginningMessage)
            _instance.insert(0, msg);
        else
            _instance.append(msg);

        System.out.println(msg);
    }

    public static synchronized void warn(String messageText)
    {
        String msg = "WARN " + messageText;
        _instance.append(msg);
        System.out.println(msg);
    }


    public static synchronized void error(String messageText)
    {
        String msg = "ERROR " + messageText;
        _instance.append(msg);
        System.out.println(msg);
    }

}
