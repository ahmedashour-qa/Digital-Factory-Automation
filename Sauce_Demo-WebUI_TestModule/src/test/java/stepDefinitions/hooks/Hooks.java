package stepDefinitions.hooks;

import Utilities.MethodHelper;
import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java8.En;

public class Hooks extends Base implements En {
    MethodHelper methodHelper = new MethodHelper();
    private Base base;

    public Hooks(Base base) {
        this.base = base;
    }


    @Before
    public void getStart(Scenario scenario) {
        base.startBrowser();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            methodHelper.captureScreenshot(base.driver, scenario.getName());
        }
        base.tearBrowser();
    }
}
