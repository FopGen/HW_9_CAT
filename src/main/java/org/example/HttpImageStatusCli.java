package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class HttpImageStatusCli {

    static void askStatus() throws CodeNotFoundException, URISyntaxException, IOException, InterruptedException {

        Scanner console = new Scanner(System.in);

        System.out.println("Enter HTTP status code");
        if (console.hasNextInt()){

            int inputCode = console.nextInt();

            try {
                HttpStatusImageDownloader.downloadStatusImage(inputCode);
            }catch(CodeNotFoundException ex){
                System.out.println("There is not image for HTTP status "+ inputCode);
            }

        }else{
            System.out.println("Please enter valid number");
        }

    }
}
