package chat.wise.message.feishu.clients;

import chat.wise.message.feishu.config.FeishuReqInterceptor;
import chat.wise.message.feishu.dto.WebHookResponseDto;
import chat.wise.message.feishu.vo.WebHookReqBodyVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author siberia.hu
 * @Package chat.wise.message.feishu.clients
 * @Date 2024/6/15 14:07
 */
@FeignClient(name = "FeishuRobotClient", url = "${wise.chat.message.feishu.url}", configuration = FeishuReqInterceptor.class)
public interface FeishuRobotClient {

    /**
     * 飞发送书机器人自定义卡片消息
     *
     * @param webHookCode 飞书机器人webhook ID
     * @param vo          消息内容
     * @return 请求结果
     */
    @PostMapping("/bot/v2/hook/{webHookCode}")
    WebHookResponseDto sendCustomBotsMsg(@PathVariable(value = "webHookCode") String webHookCode, @RequestBody WebHookReqBodyVo vo);

}
