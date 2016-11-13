package support.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by wx on 2016-03-15.
 */
public class SHA1Utils {
    public static String sha1(String text) {
        MessageDigest md = null;
        String outStr = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(text.getBytes());
            outStr = byteToString(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return outStr;
    }

    private static String byteToString(byte[] digest) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            String tempStr = Integer.toHexString(digest[i] & 0xff);
            if (tempStr.length() == 1) {
                buf.append("0").append(tempStr);
            } else {
                buf.append(tempStr);
            }
        }
        return buf.toString().toLowerCase();
    }


}
