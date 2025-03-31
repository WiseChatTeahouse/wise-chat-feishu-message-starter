package chat.wisechat.message.feishu;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.concurrent.TimeUnit;

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
    private String url = "https://open.feishu.cn/open-apis/bot/v2/hook/";  // 先实现自定义机器人消息功能  鉴权后面再看看
    /**
     * 应用appID  ---后续可以配置获取认证信息用---
     */
    private String appId;
    /**
     * 应用appSecret  ---后续可以配置获取认证信息用---
     */
    private String appSecret;
    /**
     * 发送消息客户端连接池配置（使用okhttp作为客户端）
     */
    private ClientConnection clientConnection = new ClientConnection();

    @Data
    public static class ClientConnection {

        private int maxIdleConnections = 10;

        private long keepAliveDuration = 5;

        private TimeUnit timeUnit = TimeUnit.MINUTES;

    }

}
