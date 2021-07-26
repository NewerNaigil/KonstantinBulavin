package ru.training.at.hw9;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasProperty;
import static ru.training.at.hw9.TrelloBoardObj.badResponseSpecification;
import static ru.training.at.hw9.TrelloBoardObj.getAnswer;
import static ru.training.at.hw9.TrelloBoardObj.getListOfAnswers;
import static ru.training.at.hw9.TrelloBoardObj.goodResponseSpecification;
import static ru.training.at.hw9.TrelloBoardObj.requestBuilder;
import static ru.training.at.hw9.constants.EndPoints.ALL_BOARDS;
import static ru.training.at.hw9.constants.EndPoints.BASE_BOARD;
import static ru.training.at.hw9.constants.TestData.CREATE_BOARD_NAME;
import static ru.training.at.hw9.constants.TestData.KEY;
import static ru.training.at.hw9.constants.TestData.TOKEN;
import static ru.training.at.hw9.constants.TestData.*;

import io.restassured.http.Method;
import java.net.URI;
import java.util.List;
import org.testng.annotations.Test;
import ru.training.at.hw9.beans.TrelloBoard;

public class TrelloTests {

    @Test
    public void createBoard() {
        TrelloBoard answer = getAnswer(
            requestBuilder()
                .setMethod(Method.POST)
                .setCredentials(KEY, TOKEN)
                .setName(CREATE_BOARD_NAME)
                .buildRequest()
                .sendRequest(BASE_BOARD));
        assertThat(answer, allOf(hasProperty("id"), hasProperty("name")));
    }

    @Test
    public void deleteBoard() {
        TrelloBoard createAnswer = getAnswer(
            requestBuilder()
                .setMethod(Method.POST)
                .setCredentials(KEY, TOKEN)
                .setName(CREATE_BOARD_NAME)
                .buildRequest()
                .sendRequest(BASE_BOARD));

        requestBuilder()
            .setMethod(Method.DELETE)
            .setCredentials(KEY, TOKEN)
            .setId(createAnswer.getId())
            .buildRequest()
            .sendRequest(URI.create(BASE_BOARD + createAnswer.getId()))
            .then().assertThat()
            .spec(goodResponseSpecification());
    }

    @Test
    public void checkAllBoards() {
        List<TrelloBoard> answers = getListOfAnswers(
            requestBuilder()
                .setMethod(Method.GET)
                .setCredentials(KEY, TOKEN)
                .buildRequest()
                .sendRequest(ALL_BOARDS));
        assertThat(answers.size(), greaterThan(0));
        assertThat(answers.get(0), allOf(hasProperty("id"), hasProperty("name")));
    }

    @Test
    public void checkBoardFields() {
        TrelloBoard answer = getAnswer(
            requestBuilder()
                .setMethod(Method.GET)
                .setId(DEFAULT_BOARD_ID)
                .setCredentials(KEY, TOKEN)
                .buildRequest()
                .sendRequest(URI.create(BASE_BOARD + DEFAULT_BOARD_ID)));
        assertThat(answer.getName(), equalTo(DEFAULT_BOARD_NAME));
        assertThat(answer.getId(), equalTo(DEFAULT_BOARD_ID));
    }

    @Test(dataProvider = "nameProvider", dataProviderClass = DataProviderForTrello.class)
    public void checkChangeName(String name) {
        TrelloBoard answer = getAnswer(
            requestBuilder()
                .setMethod(Method.PUT)
                .setId(DEFAULT_BOARD_ID)
                .setCredentials(KEY, TOKEN)
                .setName(name)
                .buildRequest()
                .sendRequest(URI.create(BASE_BOARD + DEFAULT_BOARD_ID)));
        assertThat(answer.getName(), equalTo(name));
    }

    @Test
    public void checkCorrectBoardId() {
        requestBuilder()
            .setMethod(Method.GET)
            .setId(DEFAULT_BOARD_ID)
            .setCredentials(KEY, TOKEN)
            .buildRequest()
            .sendRequest(URI.create(BASE_BOARD + DEFAULT_BOARD_ID))
            .then().assertThat()
            .spec(goodResponseSpecification());
    }

    @Test
    public void checkIncorrectBoardId() {
        requestBuilder()
            .setMethod(Method.GET)
            .setId(INCORRECT_BOARD_ID)
            .setCredentials(KEY, TOKEN)
            .buildRequest()
            .sendRequest(URI.create(BASE_BOARD + INCORRECT_BOARD_ID))
            .then().assertThat()
            .spec(badResponseSpecification());
    }
}
