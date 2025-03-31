package chat.wisechat.message.feishu.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

/**
 * @Author Siberia.Hu
 * @Date 2025/3/31 15:17
 */
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class FeishuMessageContent {

    @JsonProperty(value = "msg_type")
    private String msgType;

    private FeiShuCard card;

    private Map<String, Object> content;
}
