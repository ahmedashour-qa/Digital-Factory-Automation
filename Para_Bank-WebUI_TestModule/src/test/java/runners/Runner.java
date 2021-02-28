package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/featureFiles"
        , glue = {"stepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:testOutput"},
        monochrome = true
        ,tags = {"@login or @registration or @cartCheckout or @account or @update_info or @logout"}
)

public class Runner {
}
