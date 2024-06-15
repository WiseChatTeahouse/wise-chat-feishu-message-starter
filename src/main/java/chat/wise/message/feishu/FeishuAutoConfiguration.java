package chat.wise.message.feishu;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author siberia.hu
 * @Package chat.wise.message.feishu
 * @Date 2024/6/14 18:23
 */
@EnableFeignClients
// 读取配置文件
@EnableConfigurationProperties(FeishuProperties.class)
// 属性不存在，则不加载
@ConditionalOnProperty(name = "wise.chat.message.feishu.url", matchIfMissing = false)
public class FeishuAutoConfiguration {
}
