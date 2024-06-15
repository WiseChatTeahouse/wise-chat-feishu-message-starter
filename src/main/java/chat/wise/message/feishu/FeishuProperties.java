package chat.wise.message.feishu;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author siberia.hu
 * @Package chat.wise.message.feishu
 * @Date 2024/6/14 18:10
 */
@Data
@ConfigurationProperties(prefix = "wise.chat.message.feishu")
public class FeishuProperties {

    /**
     * 飞书服务地址
     */
    private String url = "https://open.feishu.cn/open-apis";
    /**
     * 应用appID
     */
    private String appId;
    /**
     * 应用appSecret
     */
    private String appSecret;

}
