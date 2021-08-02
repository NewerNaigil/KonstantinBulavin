package ru.training.at.hw9;

import static org.hamcrest.Matchers.lessThan;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.http.HttpStatus;
import ru.training.at.hw9.beans.TrelloBoard;

public class TrelloBoardObj {

    private Method requestMethod;
    private Map<String, String> parameters;

    public TrelloBoardObj(Method requestMethod, Map<String, String> parameters) {
        this.requestMethod = requestMethod;
        this.parameters = parameters;
    }

    public static ApiRequestBuilder requestBuilder() {
        return new ApiRequestBuilder();
    }

    // Start Builder
    public static class ApiRequestBuilder {
        private ConfigFileReader configFileReader = new ConfigFileReader();
        private Method requestMethod = Method.GET;
        private Map<String, String> parameters = new HashMap<>();

        {
            parameters.put("key", configFileReader.getKey());
            parameters.put("token", configFileReader.getToken());
        }

        public ApiRequestBuilder setMethod(Method method) {
            requestMethod = method;
            return this;
        }

        public ApiRequestBuilder setCredentials(String key, String token) {
            parameters.put("key", key);
            parameters.put("token", token);
            return this;
        }

        public ApiRequestBuilder setName(String name) {
            parameters.put("name", name);
            return this;
        }

        public ApiRequestBuilder setId(String id) {
            parameters.put("id", id);
            return this;
        }

        public TrelloBoardObj buildRequest() {
            return new TrelloBoardObj(requestMethod, parameters);
        }
    }
    //End Builder

    public Response sendRequest(URI uri) {
        return RestAssured
            .given(requestSpecification().log().all())
            .queryParams(parameters)
            .body(parameters)
            .request(requestMethod, uri)
            .prettyPeek();
    }

    public RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setAccept(ContentType.JSON)
            .build();
    }

    public static ResponseSpecification goodResponseSpecification() {
        return new ResponseSpecBuilder()
            .expectContentType(ContentType.JSON)
            .expectResponseTime(lessThan(10000L))
            .expectStatusCode(HttpStatus.SC_OK)
            .build();
    }

    public static ResponseSpecification badResponseSpecification() {
        return new ResponseSpecBuilder()
            .expectContentType(ContentType.TEXT)
            .expectResponseTime(lessThan(10000L))
            .expectStatusCode(HttpStatus.SC_BAD_REQUEST)
            .build();
    }

    public static TrelloBoard getBoard(Response response) {
        return new Gson()
            .fromJson(response.asString().trim(), new TypeToken<TrelloBoard>() {
            }.getType());
    }

    public static List<TrelloBoard> getListOfBoards(Response response) {
        return new Gson()
            .fromJson(response.asString().trim(), new TypeToken<List<TrelloBoard>>() {
            }.getType());
    }
}
