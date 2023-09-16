package github;

import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class HomeWorkNewVariant {
  @Test
  void findJUnit5OnWiki() {
    //открыть selenide
    open("https://github.com/selenide/selenide");
    // перейти в вики
    $("#wiki-tab").click();
    // убедиться что есть SA
    $$(". js-wiki-sidebar-toggle-display").findBy(Condition.exactText("SoftAssertions"));
    // перейти к SA
    $("[placeholder='Find a page…']").click();
    $("[id='wiki-pages-filter']").setValue("Soft");
    $$("ul.m-0 li").findBy(text("SoftAssertions")).click();
    $$("[class='Link--primary']").findBy(Condition.exactText("JUnit5"));

  }
}
