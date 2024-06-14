package chat.wise.message.feishu;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author siberia.hu
 * @Package chat.wise.message.feishu
 * @Date 2024/6/14 18:10
 */
@ConfigurationProperties(prefix = "wise.chat.message.feishu")
public class FeishuProperties {

    /**
     * 飞书服务地址
     */
    private String url;
    /**
     * 应用appID
     */
    private String appId;
    /**
     * 应用appSecret
     */
    private String appSecret;

}
