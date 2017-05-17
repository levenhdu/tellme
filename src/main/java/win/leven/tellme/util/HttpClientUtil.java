package win.leven.tellme.util;

import okhttp3.*;

import java.io.IOException;

/**
 * http客户端
 * Created by leven on 2017/5/17.
 */
public class HttpClientUtil {
    private static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    private static final OkHttpClient client = new OkHttpClient();


    public static String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

}
