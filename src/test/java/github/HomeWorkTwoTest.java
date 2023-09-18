package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class HomeWorkTwoTest {
  @Test
  void enterprisePageCheck(){
    open("https://github.com/");

    $("div.header-menu-wrapper").$(byText("Solutions")).hover();
    $$(".border-bottom ul li").get(0).$("a").click();
    $$(".position-relative h1").findBy(text("Build like the best")).shouldBe(visible);

    sleep(5000);
  }
}
