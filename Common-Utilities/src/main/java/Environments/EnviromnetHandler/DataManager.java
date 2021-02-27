package Environments.EnviromnetHandler;

public class DataManager {
    ConfigurationManager configurationManager = ConfigurationManager.getConfigurationManager();

    public String getUIUrl() {
        String Sauce_Demo_ui_URL = configurationManager.environmentProperties.getProperty("Sauce_Demo_ui_URL");
        return Sauce_Demo_ui_URL;
    }
    public String getUIUrl_Bank() {
        String Para_Bank_URL = configurationManager.environmentProperties.getProperty("Para_Bank_URL");
        return Para_Bank_URL;
    }
}
