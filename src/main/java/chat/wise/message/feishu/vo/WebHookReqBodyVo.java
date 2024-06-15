package chat.wise.message.feishu.vo;

import chat.wise.message.feishu.entity.FeiShuCard;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

/**
 * @Author siberia.hu
 * @Package chat.wise.message.feishu.vo
 * @Date 2024/6/15 14:19
 */
@Data
public class WebHookReqBodyVo {

    @JsonProperty(value = "msg_type")
    private String msgType;

    private FeiShuCard card;

    private Map<String, Object> content;
}
