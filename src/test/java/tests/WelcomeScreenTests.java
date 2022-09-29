package tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WelcomeScreenTests extends BaseTests {

    static Stream<Arguments> methodSourceWelcomeScreensContentTest() {
        return Stream.of(
                Arguments.of(0, "The Free Encyclopedia\n" +
                        "…in over 300 languages", "We’ve found the following on your device:"),
                Arguments.of(1, "New ways to explore", "Dive down the Wikipedia rabbit hole with a constantly updating Explore feed. \n" +
                        "Customize the feed to your interests – whether it’s learning about historical events On this day, or rolling the dice with Random."),
                Arguments.of(2, "Reading lists with sync", "You can make reading lists from articles you want to read later, even when you’re offline. \n" +
                        "Login to your Wikipedia account to sync your reading lists. Join Wikipedia"),
                Arguments.of(3, "Send anonymous data", "Help make the app better by letting us know how you use it. Data collected is anonymous. Learn more")
        );
    }

    @MethodSource("methodSourceWelcomeScreensContentTest")
    @ParameterizedTest
    @DisplayName("Проверка текста {0} экрана приветствия")
    public void welcomeScreensContentTest(int screenNumber, String heading, String text){
        step("Тап на навигационную точку {0} слайда", () -> {
            $(AppiumBy.xpath("//android.widget.HorizontalScrollView[@content-desc='Page 1 of 4']/android.widget.LinearLayout" +
                    "/android.widget.LinearLayout[@index='"+screenNumber+"']")).click();
        });
        step("Проверка заголовка {0} слайда", () -> {
            assertEquals(heading, $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).getText());
        });
        step("Проверка текста {0} слайда", () -> {
            assertEquals(text, $(AppiumBy.id("org.wikipedia.alpha:id/secondaryTextView")).getText());
        });
    }

    @ValueSource(ints = {
            0, 1, 2, 3
    })

    @ParameterizedTest
    @DisplayName("Проверка загрузки изображений на слайде {0} экрана приветствия")
    public void welcomeScreensPicturesDisplayed(int screenNumber){
        step("Тап на навигационную точку {0} слайда", () -> {
            $(AppiumBy.xpath("//android.widget.HorizontalScrollView[@content-desc='Page 1 of 4']/android.widget.LinearLayout" +
                    "/android.widget.LinearLayout[@index='"+screenNumber+"']")).click();
        });
        step("Проверка изображения слайда", () -> {
            assertThat($(AppiumBy.id("org.wikipedia.alpha:id/imageViewCentered")).isDisplayed());
        });
    }
}
