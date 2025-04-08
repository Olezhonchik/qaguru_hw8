package ru.vkusvillTests;

import com.github.javafaker.Faker;
import utils.RandomUtils;

import static utils.RandomUtils.*;

public class TestData {

    RandomUtils randomUtils = new RandomUtils();

    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            number = faker.phoneNumber().subscriberNumber(10),
            gender = getRandomGender(),
            randomDay = generateRandomDay(),
            randomMonth = generateRandomMonth(),
            randomYear = generateRandomYear(),
            randomAddress = faker.address().fullAddress(),
            randomSubject = getRandomSubject(),
            randomHobbies = getRandomHobbies(),
            randomState = getRandomState(),
            randomCity = getRandomCity(randomState);
}



