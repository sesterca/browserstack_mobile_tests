package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("android")
public class WikipediaAndroidTests extends TestBase{

    Faker faker = new Faker();

    @Test
    public void searchTest(){
        back();

        step("Type search", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });

        step("Verify search results", () -> {
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                .shouldHave(CollectionCondition.sizeGreaterThan(0));
        });
    }

    @Test
    public void registerThroughCaptchaTest(){

        String password = faker.internet().password();

        back();

        step("Тап на Saved в меню", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/nav_tab_reading_lists")).click();
        });

        step("Тап на меню Saved", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/positiveButton")).click();
        });

        step("Ввод значения Username", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/create_account_username")).click();
            $(AppiumBy.xpath("//android.widget.EditText[@text='Username']")).sendKeys("tycanity");
        });

        step("Ввод значения Password", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/create_account_password_input")).click();
            $(AppiumBy.xpath("//android.widget.EditText[@text='Password']")).sendKeys(password);
        });

        step("Ввод значения Repeat password", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/create_account_password_repeat")).click();
            $(AppiumBy.xpath("//android.widget.EditText[@text='Repeat password']")).sendKeys(password);
        });

        step("Ввод значения Email", () -> {
            $(AppiumBy.xpath("//android.widget.EditText[@text='Email (Optional)']")).click();
            $(AppiumBy.xpath("//android.widget.EditText[@text='Email (Optional)']")).sendKeys(faker.internet().emailAddress());
        });

        step("Тап по кнопке Next", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/create_account_submit_button")).click();
        });

        step("Проверка отображения капчи", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/captcha_image")).shouldBe(Condition.exist);
        });
    }
}