package chat.wisechat.message.feishu.entity;

import chat.wisechat.message.feishu.constant.MessageType;
import lombok.Data;

/**
 * @Author Siberia.Hu
 * @Date 2025/3/31 14:21
 */
@Data
public class MessageContent {
    private MessageType type;
    private String webhookId;
    private FeishuMessageContent messageContent;
}
