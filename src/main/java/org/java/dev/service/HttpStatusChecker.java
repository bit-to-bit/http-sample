package org.java.dev.service;

import okhttp3.*;
import org.java.dev.exception.DatasourceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpStatusChecker {
    private static final Logger LOG = LoggerFactory.getLogger(HttpStatusChecker.class);
    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient();
    private static final Request.Builder HTTP_REQUEST_BUILDER = new Request.Builder();
    private static final String HTTP_URL = "https://http.cat/";

    public String getStatusImage(int code) throws Exception {
        Request request = HTTP_REQUEST_BUILDER.get().url(urlBuilder(code)).build();
        Call call = HTTP_CLIENT.newCall(request);
        Response response = call.execute();
        int answer = response.code();
        if (answer == 200) {
            return urlBuilder(code);
        } else {
            String error = "HttpStatusChecker.getStatusImage error: code " + code + " does not exists!";
            LOG.error(error);
            throw new DatasourceException(error);
        }
    }
    private static String urlBuilder(int httpCode) {
        return HTTP_URL + httpCode + ".jpg";
    }
}
