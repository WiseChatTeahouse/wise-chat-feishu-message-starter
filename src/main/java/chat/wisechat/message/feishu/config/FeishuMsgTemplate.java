package chat.wisechat.message.feishu.config;

import chat.wisechat.message.feishu.FeishuProperties;
import chat.wisechat.message.feishu.entity.MessageContent;
import lombok.AllArgsConstructor;
import lombok.Data;
import okhttp3.*;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;

/**
 * @Author Siberia.Hu
 * @Date 2025/3/31 10:10
 */
@Data
@AllArgsConstructor
public class FeishuMsgTemplate {

    private OkHttpClient feishuHttpClient;

    private FeishuProperties feishuProperties;

    public String send(MessageContent messageContent) {
        String result = "";
        try {
            result = doPost(feishuProperties.getUrl() + messageContent.getWebhookId(), messageContent.getContentJson());
        } catch (IOException e) {
            LogFactory.getLog(this.getClass()).warn("飞书消息发送失败！", e);
        }
        return result;
    }


    private String doPost(String url, String json) throws IOException {
        MediaType mediaType = MediaType.parse("application/json;charset=UTF-8");
        RequestBody body = RequestBody.create(json, mediaType);
        Request.Builder request = new Request.Builder();
        request.url(url);
        request.post(body);
        Response response = feishuHttpClient.newCall(request.build()).execute();
        if (null == response.body()) {
            return "";
        }
        String respStr = response.body().string();
        response.close();
        return respStr;
    }

}
