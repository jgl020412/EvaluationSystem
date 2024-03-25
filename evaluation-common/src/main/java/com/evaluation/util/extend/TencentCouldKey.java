package com.evaluation.util.extend;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author 小亮
 **/

@Component
@PropertySource("classpath:tencentcould.properties")
@ConfigurationProperties(prefix = "tencent.could")
public class TencentCouldKey {
    private String id;
    private String key;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
