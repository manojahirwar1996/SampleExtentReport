package runner;
import com.cucumber.listener.ExtentCucumberFormatter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cucumber.api.SnippetType;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


@CucumberOptions(
        features="src/test/resources/Feature",
        glue= "steps",
        plugin= {"pretty","html:target/cucumber-reports/report.html",
                "com.cucumber.listener.ExtentCucumberFormatter"},

        monochrome= true,
        snippets = SnippetType.CAMELCASE
)


public class MyTestRunner extends AbstractTestNGCucumberTests {
    private TestNGCucumberRunner testNGCucumberRunner;
    @BeforeClass(alwaysRun = true)
    public void setUpCucumber() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
    @BeforeSuite(alwaysRun = true)
    public static void setup() {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss");
        Date curdate = new Date();
        String strDate = sdf.format(curdate);
        String filename = System.getProperty("user.dir") + "\\target\\Exten_Report" + strDate + ".html";
        File newFile = new File(filename);

        ExtentCucumberFormatter.initiateExtentCucumberFormatter(newFile, false);
        ExtentCucumberFormatter.loadConfig(new File("configs/extent-config.xml"));


        ExtentCucumberFormatter.addSystemInfo("Browser Name", "Chrome");
        ExtentCucumberFormatter.addSystemInfo("Browser Version", "v57.0");
        ExtentCucumberFormatter.addSystemInfo("Selenium Version", "v3.9.1");


        Map systemInfo = new HashMap();
        systemInfo.put("Cucumber version", "v1.2.3");
        systemInfo.put("Extent Cucumber  Report version", "v1.1.0");
        ExtentCucumberFormatter.addSystemInfo(systemInfo);


    }

}
