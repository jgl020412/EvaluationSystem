package com.evaluation.util.extend;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author 小亮
 **/
@Component
@PropertySource("classpath:tencent.properties")
@ConfigurationProperties(prefix = "tencent")
public class TencentResource {

    private String secretId;
    private String appId;

    public String getSecretId() {
        return secretId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
