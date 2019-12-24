package com.wzs.alipay.config;
import org.springframework.context.annotation.Configuration;

import java.io.FileWriter;
import java.io.IOException;
@Configuration
public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101100657681";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQCj9Cg++89vN4HCPfecfD61H4Z6MgQ/nvbj4Fcko7dTIqTmNMnTRRIrOHfuwAcmcOqP7RGVHUUNMw158GumTT2IxIwug5atGTMUShMdn8pzolooy29CkGyVl7kUKo8VTDWACHs5D8KxmgwKrDjODsulZ5JgiBbUDFkb7UVWqk9643reW3TgU9gN8A6ntH3VRJIMvLkTVAtU+WkL0H1lAzyhiD+QX+3O1xjkdWW6rp7fj6Uotybed+s2Sh0YIXOScbx0VNvLp12ITOBW5C6YokKtZug1zkGA06THqkAGkGnN2jwRc1Cae/vf4jBDgD4KOdprZg6BSUM5ZGB3Eqry6+m5AgMBAAECggEBAIkPfHGiyreb/ILokM4l47pAv4f5timFd7nqeo8ruf7q8FVufeZ7UIQHMePKbm/JZ52oPtGcZXRyYGq2/RdKbQ2f2dysrtLIRTZJ8o8KXRGsAJkn8DwCRnQMIXHlXjYcvoDpFjIOpeEY+cYWUWqZXc9JtUmzmvnr1LaO9S9NMyJ0HzUxxFHLQkmFlIfJK9L09WagjVu3YWTG9tIEsld4vZxjUGnV579CAr7/qEsm7dPIALo0EKclIqRf4MK1jjORjwDjdXAkq0esdIxoT7URUK68rBuJwCOmTBqpblXLN1uDCUg1xq/wtKNHbtx2ewmDc0um+v0/dJda+3zfSD+6sPECgYEA3pNESAgdAGt/e5W7Xi8vMPhyxjhG/j91liI/mLBV0VPsaQi0ilYgKsE/hCWwDMlDrM2ckypOFtC7a3/PXsjFk+HlR05ywM9I9T185JlRjGiXg809LyUQAHwFtH1WigdbANx0yYoyy8NHAViPT/mPpMofgV8ZzAXVm9jvcxypVV0CgYEAvJM7RzzbBRYaLVcl+AKZIJlG8bgN2rK+M3j7H8uSrpHlI387342CSvueBz/CfWveHSziDX2RuhLGQpksm2a9YkNV0XgKr/HBpS7iXt0S9aOPbw+kbpXORL161Risb+6rp7DJSIfuhG38DRfNM1nebowEuYz0BDCcenHktiz/pA0CgYEA0Vt6lbqz9Ooorsmnxa7iV9DKvPLArHRqmX67jVcIUe7758xdbeYXOcAui5GbqFtEQe3hgnf/nexW7oX5O/HkDvcj4E/FFuGjgbKFoM0qbMURB9Ps4kSdaac/AogG96x1iDjVzaElqI6VYom3vAVFfT72JY2byVIPnBmRGhjymq0CgYEAqRboB3ek+ImaDV/gluNVhSqLt8EPAzRVYngvzZHPxCLkMREskccktrGqQNvGPIpVjxmo1Onsmsms5xjMK8hTNuIj+IDILH394m0I5IEdOA9iVPbUvagsXez9UEkgjfmYB/R4eEYS9MJeSSs3f70suzloHy0pvPwNw6mOqF/vFp0CgYEAjkfpnUaLq0fzmoYjj/v5I/Hfyv5Bc4bgZCMwIiZBPPjEjnc8MIVMt0iQzQjsqcrxbhiCZdwjgY0oe4kCuL5T3EgE5HI3/45CD9XD56/cGlekIsHFieOtmK/kdqxHyR3/bC7pwlphnKt2EVN9EWSeFKyQZBxIkZLtsriZqkFOemY=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAidX4kHArr2AfAP/lbDEzy8PDiX+/GJR07g3bHDB4LyKnVvS8nPLpTIzqJ6FR8AeU23cDiDrSqJE7PMx/9tQM3DF92BxKlf76a5nMgCJVGIwk7nOq63/9VoVYyCgsJLD1At2VOSmymsH1pM6/eHAGjqhU7HuElrM/AknxcvptUjrNQatD/kCSVvYDUeftTGDszncEPaQXMvPlCgwukckIa5xHF5Vjyo1IC+XzfCU3xCgJmEvamnPA71N50B80+GP8Zz4d5wVoSEz+d4DmeDi2snDvXjj20Duzmx03miyhrkKVA+5Uo+XZwbYxKMxUS9CnQv7p02BtBNxhIrBpevKizwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://127.0.0.1:8081/skipPage/indexFood";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://127.0.0.1:8081/skipPage/indexFood";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
