package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class CardDeliveryNegativeTests {
    int days = 4;
    MeetingData meetingData = new MeetingData();

    @BeforeEach
    void setUp() {

        open( "http://localhost:9999/" );

    }


    @Test
    public void notFoundCity() {

        $x( "//input[@placeholder='Город']" ).setValue( "Moscow" );
        $x( "//input[@placeholder='Дата встречи']" ).doubleClick().sendKeys( Keys.BACK_SPACE );
        $x( "//input[@placeholder='Дата встречи']" ).setValue( meetingData.generateDate( days ) );
        $( "[data-test-id='name'] input" ).setValue( "Иванов Иван" );
        $( "[data-test-id='phone'] input" ).setValue( "+79261234567" );
        $( "[data-test-id='agreement']" ).click();
        $x( "//*[text()='Забронировать']" ).click();
        $( "[data-test-id='city'] span.input__sub" ).shouldHave( exactText( "Доставка в выбранный город недоступна" ) ).shouldBe( Condition.visible );

    }

    @Test
    public void EmptyCity() {

        $x( "//input[@placeholder='Дата встречи']" ).doubleClick().sendKeys( Keys.BACK_SPACE );
        $x( "//input[@placeholder='Дата встречи']" ).setValue( meetingData.generateDate( days ) );
        $( "[data-test-id='name'] input" ).setValue( "Иванов Иван" );
        $( "[data-test-id='phone'] input" ).setValue( "+79261234567" );
        $( "[data-test-id='agreement']" ).click();
        $x( "//*[text()='Забронировать']" ).click();
        $( "[data-test-id='city'] span.input__sub" ).shouldHave( exactText( "Поле обязательно для заполнения" ) ).shouldBe( Condition.visible );

    }


    @Test
    public void EmptyData() {


        $x( "//input[@placeholder='Город']" ).setValue( "Москва" );
        $x( "//input[@placeholder='Дата встречи']" ).doubleClick().sendKeys( Keys.BACK_SPACE );
        $( "[data-test-id='name'] input" ).setValue( "Иванов Иван" );
        $( "[data-test-id='phone'] input" ).setValue( "+79261234567" );
        $( "[data-test-id='agreement']" ).click();
        $x( "//*[text()='Забронировать']" ).click();
        $( "[data-test-id='date'] span.input__sub" ).shouldHave( exactText( "Неверно введена дата" ) ).shouldBe( Condition.visible );

    }

    @Test
    public void EmptyName() {

        $x( "//input[@placeholder='Город']" ).setValue( "Москва" );
        $x( "//input[@placeholder='Дата встречи']" ).doubleClick().sendKeys( Keys.BACK_SPACE );
        $x( "//input[@placeholder='Дата встречи']" ).setValue( meetingData.generateDate( days ) );
        $( "[data-test-id='phone'] input" ).setValue( "+79261234567" );
        $( "[data-test-id='agreement']" ).click();
        $x( "//*[text()='Забронировать']" ).click();
        $( "[data-test-id='name'] span.input__sub" ).shouldHave( exactText( "Поле обязательно для заполнения" ) ).shouldBe( Condition.visible );
    }

    @Test
    public void EmptyPhone() {

        $x( "//input[@placeholder='Город']" ).setValue( "Москва");
        $x( "//input[@placeholder='Дата встречи']" ).doubleClick().sendKeys( Keys.BACK_SPACE );
        $x( "//input[@placeholder='Дата встречи']" ).setValue( meetingData.generateDate( days ) );
        $( "[data-test-id='name'] input" ).setValue( "Иванов Иван" );
        $( "[data-test-id='agreement']" ).click();
        $x( "//*[text()='Забронировать']" ).click();
        $( "[data-test-id='phone'] span.input__sub" ).shouldHave( exactText( "Поле обязательно для заполнения" ) ).shouldBe( Condition.visible );

    }

    @Test
    public void EmptyCheckBox() {

        $x( "//input[@placeholder='Город']" ).setValue( "Москва" );
        $x( "//input[@placeholder='Дата встречи']" ).doubleClick().sendKeys( Keys.BACK_SPACE );
        $x( "//input[@placeholder='Дата встречи']" ).setValue( meetingData.generateDate( days ) );
        $( "[data-test-id='name'] input" ).setValue( "Иванов Иван" );
        $( "[data-test-id='phone'] input" ).setValue( "+79261234567" );
        $x( "//*[text()='Забронировать']" ).click();
        $( ".checkbox__text" ).shouldHave( exactText( "Я соглашаюсь с условиями обработки и использования моих персональных данных" ) ).shouldBe( Condition.visible );

    }


    @Test
    public void InvalidName() {

        $x( "//input[@placeholder='Город']" ).setValue( "Москва" );
        $x( "//input[@placeholder='Дата встречи']" ).doubleClick().sendKeys( Keys.BACK_SPACE );
        $x( "//input[@placeholder='Дата встречи']" ).setValue(meetingData.generateDate( days ) );
        $( "[data-test-id='name'] input" ).setValue( "123456" );
        $( "[data-test-id='phone'] input" ).setValue( "+79261234567" );
        $( "[data-test-id='agreement']" ).click();
        $x( "//*[text()='Забронировать']" ).click();
        $( "[data-test-id='name'] span.input__sub" ).shouldHave( exactText( "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы." ) ).shouldBe( Condition.visible );

    }

    @Test
    public void InvalidPhoneWithoutPlus() {

        $x( "//input[@placeholder='Город']" ).setValue( "Москва" );
        $x( "//input[@placeholder='Дата встречи']" ).doubleClick().sendKeys( Keys.BACK_SPACE );
        $x( "//input[@placeholder='Дата встречи']" ).setValue( meetingData.generateDate( days ) );
        $( "[data-test-id='name'] input" ).setValue( "Иванов Иван" );
        $( "[data-test-id='phone'] input" ).setValue( "79261234567" );
        $( "[data-test-id='agreement']" ).click();
        $x( "//*[text()='Забронировать']" ).click();
        $( "[data-test-id='phone'] span.input__sub" ).shouldHave( exactText( "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678." ) ).shouldBe( Condition.visible );

    }

    @Test
    public void InvalidPhone() {

        $x( "//input[@placeholder='Город']" ).setValue( "Москва" );
        $x( "//input[@placeholder='Дата встречи']" ).doubleClick().sendKeys( Keys.BACK_SPACE );
        $x( "//input[@placeholder='Дата встречи']" ).setValue( meetingData.generateDate( days ) );
        $( "[data-test-id='name'] input" ).setValue( "Иванов Иван" );
        $( "[data-test-id='phone'] input" ).setValue( "89261234567" );
        $( "[data-test-id='agreement']" ).click();
        $x( "//*[text()='Забронировать']" ).click();
        $( "[data-test-id='phone'] span.input__sub" ).shouldHave( exactText( "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678." ) ).shouldBe( Condition.visible );

    }

}
