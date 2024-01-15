package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

public class HttpStatusImageDownloader {
    public static void downloadStatusImage(int code) throws CodeNotFoundException, URISyntaxException, IOException, InterruptedException {

        String url = HttpStatusChecker.getStatusImage(code);

        HttpRequest request = HttpRequest.newBuilder(new URI(url)).build();
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(Path.of("cat.jpg")));

    }
}