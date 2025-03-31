package chat.wisechat.message.feishu;

import chat.wisechat.message.feishu.config.FeishuMsgTemplate;
import chat.wisechat.message.feishu.config.OkHttpInterceptor;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

/**
 * @Author siberia.hu
 * @Package chat.wise.message.feishu
 * @Date 2024/6/14 18:23
 */
// 读取配置文件
@EnableConfigurationProperties(FeishuProperties.class)
public class FeishuAutoConfiguration {

    private final FeishuProperties feishuProperties;

    public FeishuAutoConfiguration(FeishuProperties feishuProperties) {
        this.feishuProperties = feishuProperties;
    }

    @Bean
    @ConditionalOnMissingBean(name = "feishuMsgTemplate")
    public FeishuMsgTemplate feishuMsgTemplate() {
        return new FeishuMsgTemplate(feishuHttpClient(), feishuProperties);
    }

    @Bean(name = "feishuHttpClient")
    public OkHttpClient feishuHttpClient() {
        FeishuProperties.ClientConnection clientConnection = feishuProperties.getClientConnection();
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.retryOnConnectionFailure(true);
        client.writeTimeout(5, TimeUnit.SECONDS); // 主要是后续发送文件太大可能会导致超时
        client.readTimeout(3, TimeUnit.SECONDS);
        client.connectTimeout(2, TimeUnit.SECONDS);
        client.addInterceptor(new OkHttpInterceptor());
        client.connectionPool(new ConnectionPool(clientConnection.getMaxIdleConnections(),
                clientConnection.getKeepAliveDuration(), clientConnection.getTimeUnit()));
        return client.build();
    }

}
