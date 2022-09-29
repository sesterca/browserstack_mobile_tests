package tests;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Tag("android")
public class LoginFormTests extends BaseTests {

    Faker faker = new Faker();

    @Test
    @DisplayName("Проверка показа капчи при регистрации")
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
            $(AppiumBy.xpath("//android.widget.EditText[@text='Username']")).sendKeys("tycanity1");
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

    @Test
    @DisplayName("Проверка видимости пароля после тапа на значок глаза")
    public void showPasswordByClickOnEyeTest(){

        String password = faker.internet().password();

        back();

        step("Тап на Saved в меню", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/nav_tab_reading_lists")).click();
        });
        step("Тап на меню Saved", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/positiveButton")).click();
        });
        step("Ввод значения Password", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/create_account_password_input")).click();
            $(AppiumBy.xpath("//android.widget.EditText[@text='Password']")).sendKeys(password);
        });
        step("Ввод значения Repeat password", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/create_account_password_repeat")).click();
            $(AppiumBy.xpath("//android.widget.EditText[@text='Repeat password']")).sendKeys(password);
        });
        step("Тап на иконку глаза поля Пароль", () -> {
           $(AppiumBy.id("text_input_end_icon")).click();
        });
    }

    @Test
    @DisplayName("Проверка авторизации")
    public void loginTest(){
        back();
        step("Тап на More в меню", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/nav_more_container")).click();
        });
        step("Тап на Log in в меню", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/main_drawer_login_button")).click();
        });
        step("Тап на кнопку Log in", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/create_account_login_button")).click();
        });
        step("Ввод значения Username", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/login_username_text")).click();
            $(AppiumBy.xpath("//android.widget.EditText[@text='Username']")).sendKeys("tycanity");
        });
        step("Ввод значения Password", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/login_password_input")).click();
            $(AppiumBy.xpath("//android.widget.EditText[@text='Password']")).sendKeys("1A?a&S5l");
        });
        step("Тап на кнопку Log in", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/login_button")).click();
        });
        step("Проверка изменения названия кнопки Log in", () -> {
            assertThat($(AppiumBy.id("org.wikipedia.alpha:id/login_button")).getText()).isEqualTo("LOGGING YOU IN…");
        });
        step("Проверка успешной авторизации", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/nav_more_container")).click();
            assertThat($(AppiumBy.id("org.wikipedia.alpha:id/main_drawer_account_name")).getText())
                    .isEqualTo("Tycanity");
        });
    }
}