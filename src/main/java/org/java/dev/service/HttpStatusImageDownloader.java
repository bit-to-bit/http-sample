package org.java.dev.service;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.java.dev.exception.DatasourceException;
import org.java.dev.properties.Constant;
import org.java.dev.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.InputStream;
public class HttpStatusImageDownloader {
    private static final Logger LOG = LoggerFactory.getLogger(HttpStatusChecker.class);
    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient();
    private static final Request.Builder HTTP_REQUEST_BUILDER = new Request.Builder();
    public void downloadStatusImage(int code) throws Exception {
        try {
            HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
            String url = httpStatusChecker.getStatusImage(code);
            Request request = HTTP_REQUEST_BUILDER.get().url(url).build();
            Call call = HTTP_CLIENT.newCall(request);
            Response response = call.execute();
            InputStream inputStream = response.body().byteStream();
            String path = Constant.FILE_STORAGE.getValue() + File.separator + code + ".jpg";
            FileUtils.saveFile(path, inputStream);
        } catch (DatasourceException e) {
            String error = "HttpStatusImageDownloader.downloadStatusImage: There is not image for HTTP status <" + code + ">";
            LOG.error(error);
            throw new DatasourceException(error);
        }
    }
}
