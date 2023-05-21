package org.java.dev.service;
import java.util.Scanner;
public class HttpImageStatusCli{
    public void askStatus(){
        boolean answerIsNotInteger = true;
        while (answerIsNotInteger) {
            System.out.print( "Enter HTTP status code: " );
            Scanner myInput = new Scanner(System.in );
            if (myInput.hasNextInt()) {
                int code = myInput.nextInt();
                try {
                    HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
                    httpStatusChecker.getStatusImage(code);
                    HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
                    httpStatusImageDownloader.downloadStatusImage(code);
                    System.out.println("\nThe image for HTTP status <" + code + "> has downloaded");
                    return;
                    }
                catch (Exception e) {
                    System.out.println("\nThere is not image for HTTP status <" + code + ">");
                }
            } else {
                System.out.println("\nPlease enter valid number!");
            }
        }
    }
}
