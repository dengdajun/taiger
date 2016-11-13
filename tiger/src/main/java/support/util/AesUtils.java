package support.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.Security;

/**
 * Created by wxp on 2016-03-23.
 */
public class AesUtils {
    static final String algorithmStr ="AES/ECB/PKCS5Padding";

    private static final String TAG = "AES";

    public static Key toKey(byte[] key){

        //实例化DES密钥

        //生成密钥

        SecretKey secretKey=new SecretKeySpec(key,TAG);

        return secretKey;

    }

    private static boolean isIsInited=false;
    private static byte[] encrypt(String content, String password) {
        try {
            if(!isIsInited) {
                Security.addProvider(new BouncyCastleProvider());
                isIsInited=true;
            }

            password= MD51.crypt(password).substring(8,24);
            Key k=toKey(password.getBytes());
            Cipher cipher=Cipher.getInstance(algorithmStr);
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, k);//   ʼ
            byte[] result = cipher.doFinal(byteContent);
            return result; //
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    private static byte[] decrypt(byte[] content, String password) {
        try {
            if(!isIsInited) {
                Security.addProvider(new BouncyCastleProvider());
                isIsInited=true;
            }

            password= MD51.crypt(password).substring(8,24);
            byte[] keyStr = getKey(password);
            Cipher cipher = Cipher.getInstance(algorithmStr);
            SecretKeySpec keySpec = new SecretKeySpec(keyStr, "AES"); //生成加密解密需要的Key
            cipher.init(Cipher.DECRYPT_MODE, keySpec);//   ʼ
            byte[] result = cipher.doFinal(content);
            return result; //
        } catch (Exception e) {

        }
        return null;
    }

    private static byte[] getKey(String password) {
        byte[] rByte = null;
        if (password!=null) {
            rByte = password.getBytes();
        }else{
            rByte = new byte[24];
        }
        return rByte;
    }

    /**
     * 将二进制转换成16进制
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
                    16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }


    /**
     *加密
     */
    public static String encode(String content,String keyBytes){
        //加密之后的字节数组,转成16进制的字符串形式输出
        return Base64Utils.encodeToString(encrypt(content, keyBytes),Base64Utils.DEFAULT);
    }

    /**
     *解密
     */
    public static String decode(String content,String keyBytes){
        //解密之前,先将输入的字符串按照16进制转成二进制的字节数组,作为待解密的内容输入
        byte[] b = decrypt(Base64Utils.decode((content),Base64Utils.DEFAULT), keyBytes);
        return new String(b);
    }

    //测试用例
    public static void test1(){
       String content="12312123";
        String key="11";
        String iv="22";
        String code=encode(content,key);

        String decode=decode(code,key);
    }

    public static void main(String[] args) {
        test1();
    }

}
