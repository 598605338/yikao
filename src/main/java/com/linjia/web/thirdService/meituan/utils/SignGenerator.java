package com.linjia.web.thirdService.meituan.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.linjia.web.thirdService.meituan.constants.ErrorEnum;
import com.linjia.web.thirdService.meituan.exception.ApiSysException;

/**
 * Created by yangzhiqi on 15/10/15.
 * 签名生成器
 */
public class SignGenerator {


    public static String genSig(String baseUrl) throws ApiSysException{
        String str = null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            str = byte2hex(md.digest(baseUrl.getBytes("utf-8")));
        }catch(NoSuchAlgorithmException e){
            throw new ApiSysException(ErrorEnum.SYS_ERR);
        } catch (UnsupportedEncodingException e) {
            throw new ApiSysException(ErrorEnum.SYS_ERR);
        }
        return str;
    }



    private static String byte2hex(byte[] b) {
        StringBuffer buf = new StringBuffer();
        int i;

        for (int offset=0; offset<b.length; offset++) {
            i = b[offset];
            if(i<0)
                i += 256;
            if(i<16)
                buf.append("0");
            buf.append(Integer.toHexString(i));
        }

        return buf.toString();
    }
}
