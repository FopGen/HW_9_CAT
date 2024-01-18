package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {
    private static final String URL_CAT = "https://http.cat/";
    private static final int CODE_404 = 404;

    public static String getStatusImage(int code) throws URISyntaxException, CodeNotFoundException, InterruptedException, IOException {

        HttpRequest request = HttpRequest.newBuilder(new URI(URL_CAT+ code)).build();

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();


        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if(response.statusCode()== CODE_404){
            throw new CodeNotFoundException("There is not image for HTTP status ");
        }

        String result = String.valueOf(response.uri());
        return result;

    }
}
