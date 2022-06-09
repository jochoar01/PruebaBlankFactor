package seleniumgluecode;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ArticlesBlankFactorPage;
import pages.BlankFactorpage;

public class BlankFactorTest {

    private WebDriver driver;
    BlankFactorpage mainPage;

    ArticlesBlankFactorPage articlesPage;

    @Given("^User can navegate to principal Blankfactor Page$")
    public void user_can_navegate_to_principal_blankfactor_Page() throws Throwable {
        mainPage = new BlankFactorpage(driver);
        driver = mainPage.conexionConChrome();
        mainPage.visit("https://blankfactor.com/");
        driver.manage().window().maximize();
    }

    @When("^Open Blog section and scroll down to post$")
    public void scroll_down_to_post() throws Throwable {
        articlesPage = mainPage.go_and_scroll();
    }

    @Then("^Verify the page is in \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\"$")
    public void verify_tets_url(String url, String authorName, String date) throws Throwable {
        mainPage = articlesPage.validate_url_and_texts(url, authorName, date);

    }

    @Then("^Returns to blog page page and print$")
    public void Returns_to_blog_page_and_print() throws Throwable {
        mainPage.returnPage();
        mainPage.printArticles();
        mainPage.close();
    }


}
