package com.ego.order.config;

import com.github.wxpay.sdk.WXPayConfig;
import lombok.Data;

import java.io.InputStream;


@Data
public class PayConfig implements WXPayConfig {

    private String appID;  //公众账号ID

    private String mchID;  //商户号

    private String key;  //生成签名的密钥

    private int httpConnectTimeoutMs;   //连接超时时间

    private int httpReadTimeoutMs;  //读取超时时间

    private String notifyUrl;// 下单通知回调地址


    @Override
    public InputStream getCertStream() {
        return null;
    }

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public String getMchID() {
        return mchID;
    }

    public void setMchID(String mchID) {
        this.mchID = mchID;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getHttpConnectTimeoutMs() {
        return httpConnectTimeoutMs;
    }

    public void setHttpConnectTimeoutMs(int httpConnectTimeoutMs) {
        this.httpConnectTimeoutMs = httpConnectTimeoutMs;
    }

    public int getHttpReadTimeoutMs() {
        return httpReadTimeoutMs;
    }

    public void setHttpReadTimeoutMs(int httpReadTimeoutMs) {
        this.httpReadTimeoutMs = httpReadTimeoutMs;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
}
