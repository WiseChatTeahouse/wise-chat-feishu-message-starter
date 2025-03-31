package chat.wisechat.message.feishu.config;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.time.Duration;

/**
 * @Author Siberia.Hu
 * @Date 2025/3/31 10:17
 */
public class OkHttpInterceptor implements Interceptor {

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        long startTime = System.nanoTime();
        Request request = chain.request();
        long cost = Duration.ofNanos(System.nanoTime() - startTime).toMillis();
        LogFactory.getLog(this.getClass())
                .debug(String.format("url: %s cost: %dms", request.url().url().getPath(), cost / 1000));
        return chain.proceed(request);
    }
}