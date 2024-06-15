package chat.wise.message.feishu.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @Author siberia.hu
 * @Package chat.wise.message.feishu.config
 * @Date 2024/6/15 13:58
 */
public class FeishuReqInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Content-Type", "application/json; charset=utf-8");
    }
}
