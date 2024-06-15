package chat.wise.message.feishu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

/**
 * @Author siberia.hu
 * @Package chat.wise.message.feishu.dto
 * @Date 2024/6/15 14:19
 */
@Data
public class WebHookResponseDto {

    @JsonProperty("StatusCode")
    private Integer statusCode;

    @JsonProperty("StatusMessage")
    private String statusMessage;

    @JsonProperty("code")
    private Integer code;

    @JsonProperty("data")
    private Map<String, Object> data;

    @JsonProperty("msg")
    private String msg;

}
