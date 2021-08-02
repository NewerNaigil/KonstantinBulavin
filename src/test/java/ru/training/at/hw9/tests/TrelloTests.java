package ru.training.at.hw9.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasProperty;
import static ru.training.at.hw9.TrelloBoardObj.badResponseSpecification;
import static ru.training.at.hw9.TrelloBoardObj.goodResponseSpecification;
import static ru.training.at.hw9.TrelloBoardObj.requestBuilder;
import static ru.training.at.hw9.constants.EndPoints.ALL_BOARDS;
import static ru.training.at.hw9.constants.EndPoints.BASE_BOARD;
import static ru.training.at.hw9.constants.TestData.INCORRECT_BOARD_ID;
import static ru.training.at.hw9.constants.TestData.INCORRECT_KEY;
import static ru.training.at.hw9.constants.TestData.INCORRECT_TOKEN;

import io.restassured.http.Method;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpStatus;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.training.at.hw9.DataProviders.DataProviderForTrello;
import ru.training.at.hw9.beans.TrelloBoard;
import ru.training.at.hw9.steps.BoardSteps;

public class TrelloTests extends AbstractTest {

    private TrelloBoard firstTestBoard;
    private TrelloBoard secondTestBoard;
    private List<String> idList = new ArrayList<>();

    @BeforeTest
    public void createTestBoards() {
        firstTestBoard = BoardSteps.createBoardStep();
        secondTestBoard = BoardSteps.createBoardStep();
        idList.add(firstTestBoard.getId());
        idList.add(secondTestBoard.getId());
    }

    @AfterTest
    public void deleteTestBoards() {
        for (String id : idList) {
            BoardSteps.deleteBoardStep(id);
        }
    }

    @Test
    public void createBoard() {
        TrelloBoard board = BoardSteps.createBoardStep();
        assertThat(board, allOf(hasProperty("id"), hasProperty("name")));
        BoardSteps.deleteBoardStep(board.getId());
    }

    @Test
    public void deleteBoard() {
        BoardSteps.deleteBoardStep(secondTestBoard.getId());

        requestBuilder()
            .setMethod(Method.GET)
            .setId(secondTestBoard.getId())
            .buildRequest()
            .sendRequest(URI.create(BASE_BOARD + secondTestBoard.getId()))
            .then().assertThat()
            .body(containsString("The requested resource was not found."));
    }

    @Test
    public void checkAllBoards() {
        List<TrelloBoard> boardList = BoardSteps.getBoardsListStep();
        assertThat(boardList.size(), greaterThan(0));
        for (int i = 0; i < boardList.size(); i++) {
            assertThat(boardList.get(0), allOf(hasProperty("id"), hasProperty("name")));
        }
    }

    @Test
    public void checkBoardFields() {
        TrelloBoard createdBoard = BoardSteps.createBoardStep();
        TrelloBoard getBoard = BoardSteps.getBoardStep(createdBoard.getId());

        assertThat(createdBoard.getName(), equalTo(getBoard.getName()));
        assertThat(createdBoard.getId(), equalTo(getBoard.getId()));

        BoardSteps.deleteBoardStep(createdBoard.getId());
    }

    @Test(dataProvider = "nameProvider", dataProviderClass = DataProviderForTrello.class)
    public void checkChangeName(String name) {
        TrelloBoard changedBoard = BoardSteps.changeBoardNameStep(firstTestBoard.getId(), name);
        assertThat(changedBoard.getName(), equalTo(name));
    }

    @Test
    public void checkBoardWithCorrectId() {
        requestBuilder()
            .setMethod(Method.GET)
            .setId(firstTestBoard.getId())
            .buildRequest()
            .sendRequest(URI.create(BASE_BOARD + firstTestBoard.getId()))
            .then().assertThat()
            .spec(goodResponseSpecification());

    }

    @Test
    public void checkBoardWithIncorrectId() {
        requestBuilder()
            .setMethod(Method.GET)
            .setId(INCORRECT_BOARD_ID)
            .buildRequest()
            .sendRequest(URI.create(BASE_BOARD + INCORRECT_BOARD_ID))
            .then().assertThat()
            .spec(badResponseSpecification());
    }

    @Test
    public void checkIncorrectKey() {
        requestBuilder()
            .setMethod(Method.GET)
            .setCredentials(INCORRECT_KEY, configFileReader.getToken())
            .buildRequest()
            .sendRequest(ALL_BOARDS)
            .then().assertThat()
            .statusCode(HttpStatus.SC_UNAUTHORIZED);
    }

    @Test
    public void checkIncorrectToken() {
        requestBuilder()
            .setMethod(Method.GET)
            .setCredentials(configFileReader.getKey(), INCORRECT_TOKEN)
            .buildRequest()
            .sendRequest(ALL_BOARDS)
            .then().assertThat()
            .statusCode(HttpStatus.SC_UNAUTHORIZED);
    }
}
