package ru.training.at.hw9.steps;

import static ru.training.at.hw9.TrelloBoardObj.getBoard;
import static ru.training.at.hw9.TrelloBoardObj.getListOfBoards;
import static ru.training.at.hw9.TrelloBoardObj.requestBuilder;
import static ru.training.at.hw9.constants.EndPoints.ALL_BOARDS;
import static ru.training.at.hw9.constants.EndPoints.BASE_BOARD;
import static ru.training.at.hw9.constants.TestData.CREATE_BOARD_NAME;

import io.restassured.http.Method;
import java.net.URI;
import java.util.List;
import java.util.Random;
import ru.training.at.hw9.beans.TrelloBoard;

public class BoardSteps {

    public static TrelloBoard createBoardStep() {
        return getBoard(
            requestBuilder()
                .setMethod(Method.POST)
                .setName(CREATE_BOARD_NAME + new Random().nextInt())
                .buildRequest()
                .sendRequest(BASE_BOARD));
    }

    public static void deleteBoardStep(String id) {
        requestBuilder()
            .setMethod(Method.DELETE)
            .setId(id)
            .buildRequest()
            .sendRequest(URI.create(BASE_BOARD + id));
    }

    public static TrelloBoard getBoardStep(String id) {
        return getBoard(
            requestBuilder()
                .setMethod(Method.GET)
                .setId(id)
                .buildRequest()
                .sendRequest(URI.create(BASE_BOARD + id)));
    }

    public static List<TrelloBoard> getBoardsListStep() {
        return getListOfBoards(
            requestBuilder()
                .setMethod(Method.GET)
                .buildRequest()
                .sendRequest(ALL_BOARDS));
    }

    public static TrelloBoard changeBoardNameStep(String id, String name) {
        return getBoard(
            requestBuilder()
                .setMethod(Method.PUT)
                .setId(id)
                .setName(name)
                .buildRequest()
                .sendRequest(URI.create(BASE_BOARD + id)));
    }
}
