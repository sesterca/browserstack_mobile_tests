package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

@Tag("android")
public class LanguageSettingsTests extends BaseTests {

    @Test
    @DisplayName("Проверка добавления русского языка")
    public void addLanguageTest(){
        step("Тап на Add or edit languages", () -> {
            $(AppiumBy.id("addLangContainer")).click();
        });
        step("Тап на Add language", () -> {
            $(AppiumBy.xpath("//android.widget.TextView[@text='ADD LANGUAGE']")).click();
        });
        step("Тап на Русский", () -> {
            $(AppiumBy.xpath("//android.widget.TextView[@text='Русский']")).click();
        });
        step("Проверка добавления нового языка", () -> {
            $(AppiumBy.xpath("//android.widget.TextView[@text='Русский']")).should(Condition.exist);
        });
    }

    static Stream<Arguments> methodSourceSearchLanguageTest() {
        return Stream.of(
                Arguments.of("valarin", 0),
                Arguments.of("french", 1),
                Arguments.of("english", 3)
        );
    }

    @MethodSource("methodSourceSearchLanguageTest")
    @ParameterizedTest
    @DisplayName("Проверка поиска языка в справочнике")
    public void searchForLanguageTest(String language, int numberOfSearchResults){
        step("Тап на Add or edit languages", () -> {
            $(AppiumBy.id("addLangContainer")).click();
        });
        step("Тап на Add language", () -> {
            $(AppiumBy.xpath("//android.widget.TextView[@text='ADD LANGUAGE']")).click();
        });
        step("Тап на Search", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/menu_search_language")).click();
        });
        step("Ввод названия языка и поиск", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys(language);
        });
        step("Проверка результатов поиска", () -> {
            $$(AppiumBy.id("org.wikipedia.alpha:id/localized_language_name"))
            .shouldHave(CollectionCondition.size(numberOfSearchResults));
        });
    }
}
