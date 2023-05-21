package org.java.dev;
import org.java.dev.configuration.LoggingConfiguration;
import org.java.dev.service.HttpImageStatusCli;
public class Main {
    public static void main(String[] args) {
        new LoggingConfiguration();
        HttpImageStatusCli httpImageStatusCli = new HttpImageStatusCli();
        httpImageStatusCli.askStatus();
    }
}

