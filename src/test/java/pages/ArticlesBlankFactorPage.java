package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.BaseSelenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ArticlesBlankFactorPage extends BaseSelenium {

    public static final By AUTOR_NAME = By.cssSelector(".author-name a[title=\"Sofia Gonzalez\"]");
    public static final By POST_DATE = By.cssSelector("div .post-date");


    public ArticlesBlankFactorPage(WebDriver driver) {
        super(driver);

    }


    public BlankFactorpage validate_url_and_texts(String url, String authorName, String date) throws InterruptedException {


        assertEquals(getURL(), url);
        assertEquals(getText(AUTOR_NAME), authorName);
        assertTrue(getText(POST_DATE).contains(date));

        return new BlankFactorpage(getDriver());
    }


}
