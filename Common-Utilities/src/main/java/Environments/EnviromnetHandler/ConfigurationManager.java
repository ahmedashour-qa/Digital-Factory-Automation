package Environments.EnviromnetHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationManager {
    String environment = null;
    Properties environmentProperties = null;

    private static ConfigurationManager configurationManager;

    public ConfigurationManager() {
        setEnvironment();
        setEnvironmentProperties();
    }

    public static ConfigurationManager getConfigurationManager() {
        if (configurationManager == null) {
            configurationManager = new ConfigurationManager();
        }
        return configurationManager;
    }

    private void setEnvironment() {

        try {
            this.environment = System.getenv("DOMAIN");

            if (this.environment == null) {
                this.environment = "testing";
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.environment = "testing";
        }

    }


    private void setEnvironmentProperties() {
        String localDirectory = System.getProperty("user.dir");
        File file;
        FileInputStream fileInput = null;

        if (environment.equals("staging")) {
            file = new File(localDirectory + "/src/../../common-utilities/src/main/java/Environments/TestingEnv/Domain.properties");
        } else {
            file = new File(localDirectory + "/src/../../common-utilities/src/main/java/Environments/TestingEnv/Domain.properties");
        }


        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.environmentProperties = new Properties();
        try {
            this.environmentProperties.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
