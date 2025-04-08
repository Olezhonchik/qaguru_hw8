package ru.vkusvillTests;

import org.junit.jupiter.api.Test;
import pages.PageObject;

import static com.codeborne.selenide.Selenide.open;

public class PracticeFormWithFaker extends TestBase {

    PageObject pageObject = new PageObject();
    TestData testData = new TestData();

    @Test
    void succesfullRegistrationTest() {


        pageObject.openPage()//Открытие страницыgit
                .setFirstName(testData.firstName) //Ввод имени
                .setLastName(testData.lastName)//Ввод фамилии
                .setEmail(testData.email)//Ввод email
                .setGender(testData.gender) //Выбор гендера
                .setUserNumber(testData.number)  //Ввод номера телефона
                .setDateOfBirth(testData.randomDay, testData.randomMonth, testData.randomYear) //Ввод даты рождения
                .setAddress(testData.randomAddress)//Ввод адреса
                .setSubjects(testData.randomSubject)//Выбор предмета
                .setHobbies(testData.randomHobbies)//Выбор хобби
                .setFile("1.png")//Загрузка файла
                .scrollDown()//Скролл до выбора штата
                // setTimeout(function() {debugger},4000); // Скрипт для холда devtools
                .setState(testData.randomState) //Выбор штата
                .setCity(testData.randomCity)//Выбор города
                .submit()//Нажатие на кнопку "Submit"
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)//Проверка правильности заполнения формы
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.number)
                .checkResult("Date of Birth", testData.randomDay + " " + testData.randomMonth + "," + testData.randomYear)
                .checkResult("Subjects", testData.randomSubject)
                .checkResult("Hobbies", testData.randomHobbies)
                .checkResult("Picture", "1.png")
                .checkResult("Address", testData.randomAddress)
                .checkResult("State and City", testData.randomState + " " + testData.randomCity);
    }

        @Test
        void minimalDataRegistrationTest() {
            pageObject.openPage()//Открытие страницы
                    .setFirstName(testData.firstName) //Ввод имени
                    .setLastName(testData.lastName)//Ввод фамилии
                    .setGender(testData.gender)//Выбор гендера
                    .setUserNumber(testData.number)//Ввод номера телефона
                    .submit()//Нажатие на кнопку "Submit"
                    .checkMinimalDataResult("Student Name", testData.firstName + " " + testData.lastName)
                    .checkMinimalDataResult("Mobile", testData.number)
                    .checkMinimalDataResult("Gender",testData.gender);
        }

        @Test
    void negativeRegistrationTest() {
        pageObject.openPage()//Открытие страницы
                .submit()//Нажатие на кнопку "Submit"
                .checkNegativeResult("border-color", "rgb(220, 53, 69)");//Проверка незаполненных полей
    }
}