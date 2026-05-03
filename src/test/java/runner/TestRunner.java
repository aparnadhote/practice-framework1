package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(commonUtil.RetryTransformer.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinition","commonUtil"},
        plugin={"pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true
)


public class TestRunner extends AbstractTestNGCucumberTests {
        @Override
        @Test(dataProvider = "scenarios", retryAnalyzer = commonUtil.RetryAnalyzer.class)
        public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
                super.runScenario(pickleWrapper, featureWrapper);
        }
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
