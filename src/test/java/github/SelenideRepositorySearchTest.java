package github;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;


public class SelenideRepositorySearchTest {

  @BeforeAll
  static void setUp() {
    System.out.println("__setUp()");
    Configuration.browserSize = "1024x800";
    Configuration.pageLoadStrategy = "eager";
    Configuration.baseUrl = "https:github.com";

  }
  @Test

  void shouldFindSelenideRepositoryAtTheTop(){

    open("https:github.com");
    $("[placeholder='Search or jump to...']").click();
    $("[id='query-builder-test']").setValue("selenide").pressEnter();

    $$("[class='Link__StyledLink-sc-14289xe-0 fIqerb']").first().click();

// по ссылке $$("[class='Link__StyledLink-sc-14289xe-0 fIqerb']").first().$("a").click();

    sleep(5000);

    $("#repository-container-header").shouldHave(Condition.text("selenide / selenide"));

  }



}
