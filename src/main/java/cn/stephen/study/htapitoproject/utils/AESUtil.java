package cn.stephen.study.htapitoproject.utils;

import com.alibaba.fastjson.JSON;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class AESUtil {

    private static final String SECRET = "AES";
    private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS7Padding";

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    /**
     * AES加密ECB模式PKCS7Padding填充方式
     * @param str 字符串
     * @param key 密钥
     * @return 加密字符串
     * @throws Exception 异常信息
     */
    public static String aes256ECBPkcs7PaddingEncrypt(String str, String key) throws Exception {
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(keyBytes, SECRET));
        byte[] doFinal = cipher.doFinal(str.getBytes(StandardCharsets.UTF_8));
        return new String(Base64.getEncoder().encode(doFinal));
    }

    /**
     * AES解密ECB模式PKCS7Padding填充方式
     * @param str 字符串
     * @param key 密钥
     * @return 解密字符串
     * @throws Exception 异常信息
     */
    public static String aes256ECBPkcs7PaddingDecrypt(String str, String key) throws Exception {
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(keyBytes, SECRET));
        byte[] doFinal = cipher.doFinal(Base64.getDecoder().decode(str));
        return new String(doFinal);
    }

    public static void main(String[] args) throws Exception {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("token","59B828ED6C4E7BDC81B2688CEC99772B");
        parameters.put("date","2021-12-23");
//        String content = "111";
//        final byte[] iv = new byte[16];
//        Arrays.fill(iv, (byte) 0x00);
        System.out.println(aes256ECBPkcs7PaddingEncrypt(JSON.toJSONString(parameters),"1234567887654321"));
//        System.out.println(aes256ECBPkcs7PaddingDecrypt(aes256ECBPkcs7PaddingEncrypt("1111111111111","1221111111111111"),"1221111111111111"));
    }

}
