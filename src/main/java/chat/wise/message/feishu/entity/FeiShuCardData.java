package chat.wise.message.feishu.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

/**
 * @Author siberia.hu
 * @Package chat.wise.message.feishu.entity
 * @Date 2024/6/15 14:17
 */
@Data
public class FeiShuCardData {
    /*飞书消息卡片模板id*/
    @JsonProperty(value = "template_id")
    private String templateId;
    /*飞书消息卡片模板版本*/
    @JsonProperty(value = "template_version_name")
    private String templateVersionName;
    /*飞书消息卡片-卡片详情（内容）*/
    @JsonProperty(value = "template_variable")
    private Map<String, Object> templateVariable;
}
