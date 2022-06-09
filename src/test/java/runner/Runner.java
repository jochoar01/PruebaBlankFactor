package runner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)


@CucumberOptions(
/*Ruta donde estan los features*/  features = "src/test/resources/features",
/*Donde se implementan los escenarios de prueba*/  glue={"seleniumgluecode"},
plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:resources/cucumber-reports/report.html"}
)
public class Runner {
}
