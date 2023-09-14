package it.sysagent.recommended.recommendedwebapp.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
public class POSTClient {

    private String host;

    private HttpRequest request;

    private HttpClient client;

    public POSTClient(String host) {
        this.host = host;
        this.client = HttpClient.newBuilder().build();
    }

    public void createRequest(String jsonStr, String service) throws URISyntaxException {
        this.request = HttpRequest.newBuilder(new URI(host+service))
                .headers("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonStr))
                .build();
    }

    public String call() {
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response != null && response.statusCode() == 200 && StringUtils.isNotBlank(response.body())) {
                return response.body();
            }
        } catch (IOException | InterruptedException ex) {
            log.error(ExceptionUtils.getMessage(ex));
        }
        return "";
    }

}
