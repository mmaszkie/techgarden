package com.techgarden.tasks.payu.client.request;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class LogHttpRequestAndResponseInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LogHttpRequestAndResponseInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] requestBody, ClientHttpRequestExecution execution) throws IOException {
        logger.info("Request body: " + preparePrettyJSON(new String(requestBody)));
        ClientHttpResponse response = execution.execute(request, requestBody);
        String responseBody = convertResponseBodyToString(response.getBody());
        logger.info("Response body: " + preparePrettyJSON(responseBody));
        return response;
    }

    private String preparePrettyJSON(String body) {
        return new JSONObject(new String(body)).toString(4);
    }

    private String convertResponseBodyToString(InputStream body) throws IOException {
        return IOUtils.toString(body, Charset.defaultCharset());
    }
}