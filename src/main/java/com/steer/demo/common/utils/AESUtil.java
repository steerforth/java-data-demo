package com.steer.demo.common.utils;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.util.Base64;

/**
 * @Program: medusha
 * @Author: Steerforth
 * @Description: AES加密解密工具
 * @Date: 2018-07-11 18:13
 */
public class AESUtil {
    /**
     * @param text 加密的内容
     * @param key 加密key
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] text, String key) throws Exception {
        Cipher cipher = initCipher(key, Cipher.ENCRYPT_MODE);
        return cipher.doFinal(text);
    }


    /**
     * base64 二次加密
     * @param text
     * @param key
     * @return
     * @throws Exception
     */
    public static String base64Encrypt(byte[] text, String key) throws Exception {
        Cipher cipher = initCipher(key, Cipher.ENCRYPT_MODE);
        return Base64.getEncoder().encodeToString(cipher.doFinal(text));
    }


    /**
     * @param text 加密内容
     * @param key 加密key
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] text,String key) throws Exception{
        Cipher cipher = initCipher(key, Cipher.DECRYPT_MODE);
        return cipher.doFinal(text);
    }


    /**
     * @param text
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] base64Decrypt(String text,String key) throws Exception{
        Cipher cipher = initCipher(key, Cipher.DECRYPT_MODE);
        return cipher.doFinal(Base64.getDecoder().decode(text));
    }

    public static byte[] base64DecryptCBC(String text,byte[] key,byte[] iv) throws Exception{
        Cipher cipher = initCipher(key, Cipher.DECRYPT_MODE,iv);
        return cipher.doFinal(Base64.getDecoder().decode(text));
    }

    public static byte[] encryptCBC(byte[] text,byte[] key,byte[] iv) throws Exception{
        Cipher cipher = initCipher(key, Cipher.ENCRYPT_MODE,iv);
        return cipher.doFinal(text);
    }

    public static byte[] base64Decrypt(byte[] text,String key) throws Exception{
        Cipher cipher = initCipher(key, Cipher.DECRYPT_MODE);
        return cipher.doFinal(Base64.getDecoder().decode(text));
    }

    private static Cipher initCipher(String key,int mode) throws Exception{
        // 判断Key是否正确
        if (key == null) {
            throw new Exception("AES密钥key不能为空");
        }
        // 判断Key是否为16位
        if (key.length() != 16) {
            throw new Exception("AES密钥key长度不是16位");
        }
        byte[] raw = key.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        //NoPadding/PKCS5Padding
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(mode, skeySpec);
        return cipher;
    }

    private static Cipher initCipher(byte[] key,int mode,byte[] iv) throws Exception{
        SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
        //让java支持PKCS7Padding
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(mode, skeySpec,generateIV(iv));
        return cipher;
    }

    public static AlgorithmParameters generateIV(byte[] iv) throws Exception {
        AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
        params.init(new IvParameterSpec(iv));
        return params;
    }
}
