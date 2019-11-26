package commons;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class TestTools {

    private static final String RUS_UPPER = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String RUS_LOWER = RUS_UPPER.toLowerCase();

    public static String getCurrentDataTime(String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String generateAlphabeticUpperString(int length) {
        return RandomStringUtils.randomAlphabetic(length).toUpperCase();
    }

    public static String generateAlphabeticLowerString(int length) {
        return RandomStringUtils.randomAlphabetic(length).toLowerCase();
    }

    public static String generateEmailLowerString(int length) {
        return RandomStringUtils.randomAlphabetic(length).toLowerCase() + "@mail.ru";
    }

    public static String generateAlphaNumericString(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public static String generateNumber(int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += String.valueOf(RandomUtils.nextInt(0, 10));
        }
        return result;
    }

    public static String generatePassword() {
        String result = "";
        for (int i = 0; i < 5; i++) {
            result += generateNumber(1);
            result += generateAlphabeticLowerString(1);
            result += generateAlphabeticUpperString(1);
        }
        return result;
    }

    public static UUID generateUUID() {
        return UUID.randomUUID();
    }

    public static String generateUUIDasString() {
        return UUID.randomUUID().toString();
    }

    public static URI getUriFromUrl(String urlStr) {
        Objects.requireNonNull(urlStr, "urlStr is null");
        URI uri = null;
        try {
            URL url = new URL(urlStr);
            uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(),
                    url.getPort(), url.getPath(), url.getQuery(), url.getRef());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return uri;
    }

    public static void sleepTime(long time) {
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String generateRusLowerString(int length) {
        return nextString(length, RUS_LOWER);
    }

    public static String generateRusUpperString(int length) {
        return nextString(length, RUS_UPPER);
    }

    private static String nextString(int length, String string) {
        char[] symbols = string.toCharArray();
        char[] buf = new char[length];
        Random random = new Random();
        for (int idx = 0; idx < buf.length; ++idx)
            buf[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buf);
    }

    public static String replaceString(String text) {
        return text
                .replace("**random_email**", generateEmailLowerString(8))
                .replace("**random_string**", generateAlphabeticLowerString(8))
                .replace("**random_password**", generatePassword())
                .replace("**random_number**", generateNumber(8))
                .replace("**random_uuid**", generateUUIDasString())
                .replace("**current_data**", getCurrentDataTime("yyyy-MM-dd HH:mm:ss"));
    }
}

