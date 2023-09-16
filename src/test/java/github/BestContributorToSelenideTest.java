package github;

import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class BestContributorToSelenideTest {

  @Test
  void andreiSolntsevShouldBeFirstContributor(){
    open("https://github.com/selenide/selenide");
    $("div.Layout-sidebar").$(byText("Contributors")).closest("h2").sibling(0).$$("li").first().hover();
    $$(".Popover").findBy(Condition.visible).shouldHave(Condition.text("Andrei Solntsev"));
    sleep(5000);
  }
}
