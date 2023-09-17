package github;

import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class HomeWorkOne {
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
    $$("[class='Link--primary']").findBy(text("3. Using JUnit5 extend test class:")).shouldBe(visible);

    //перейти на страницу
    $$("ul.mx-4 li").get(8).$("a").click();
    // проверка заголовка
    $$("h4").findBy(text("3. Using JUnit5 extend test class:")).shouldBe(visible);
    // проверка кода (скопирован по иконке)
    $$("pre").findBy(text("@ExtendWith({SoftAssertsExtension.class})\n" +
        "class Tests {\n" +
        "  @Test\n" +
        "  void test() {\n" +
        "    Configuration.assertionMode = SOFT;\n" +
        "    open(\"page.html\");\n" +
        "\n" +
        "    $(\"#first\").should(visible).click();\n" +
        "    $(\"#second\").should(visible).click();\n" +
        "  }\n" +
        "}")).shouldBe(visible);
  }
}
