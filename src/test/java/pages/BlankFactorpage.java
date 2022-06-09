package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import util.BaseSelenium;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;


public class BlankFactorpage extends BaseSelenium {

    final Logger LOG = Logger.getLogger(String.valueOf(BlankFactorpage.class));

    public static final By INSIGHTS = By.id("menu-item-4436");
    public static final By BLOG = By.cssSelector("img[src=\"https://blankfactor.com/wp-content/uploads/2021/11/1-3.jpg\"]");
    public static final By COOKIES_CONFIRMATION = By.id("hs-eu-confirmation-button");
    public static final By ARTICLE = By.xpath("//a[contains(text(),'Why Fintech in Latin America Is Having a Boom')]");
    public static final By LOAD_MORE = By.cssSelector(".load-more-btn-wrap button");
    public static final By RESULTS_TEXT = By.cssSelector("div[class=\"results\"]");
    public static final By ARTICLE_LIST = By.cssSelector(".posts-list article h2 a");
    public static final By ARTICLE_TITTLE = By.cssSelector("article h2 a");



    public BlankFactorpage(WebDriver driver) {
        super(driver);

    }

    public ArticlesBlankFactorPage go_and_scroll() throws InterruptedException {
        click(COOKIES_CONFIRMATION);
        click(INSIGHTS);
        click(BLOG);
        scrollElement(RESULTS_TEXT);


        boolean present = true;


        while (present) {

            try {
                scrollElement(LOAD_MORE);
                click(LOAD_MORE);
                scrollElement(ARTICLE);
                if (isDisplayed(ARTICLE)) {
                    present = true;

                }

                scrollElement(LOAD_MORE);
            } catch (Exception e) {
                scrollElement(By.cssSelector(".results"));
                if (isDisplayed(ARTICLE)) {
                    present = false;
                    click(ARTICLE);
                }

            }


        }
        return new ArticlesBlankFactorPage(getDriver());

    }

    public void printArticles() {


        for (WebElement webElement : getElementList(ARTICLE_LIST)) {

            LOG.info("-----Title: "+getText(webElement)+"  Link:"+webElement.getAttribute("href"));

        }

    }


}
