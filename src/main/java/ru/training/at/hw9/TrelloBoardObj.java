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
        private Map<String, String> parameters = new HashMap<>();
        private Method requestMethod = Method.GET;

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
        switch (requestMethod) {
            case GET:
                return RestAssured
                    .given(getRequestSpecification().log().all())
                    .queryParams(parameters)
                    .request(requestMethod, uri)
                    .prettyPeek();
            case POST:
                return RestAssured
                    .given(postRequestSpecification().log().all())
                    .body(parameters)
                    .request(requestMethod, uri)
                    .prettyPeek();
            case PUT:
                return RestAssured
                    .given(putRequestSpecification().log().all())
                    .queryParams(parameters)
                    .request(requestMethod, uri)
                    .prettyPeek();
            case DELETE:
                return RestAssured
                    .given(deleteRequestSpecification().log().all())
                    .queryParams(parameters)
                    .request(requestMethod, uri)
                    .prettyPeek();
            default:
                return null;
        }
    }

    public RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
            .build();
    }

    public RequestSpecification postRequestSpecification() {
        return new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setAccept(ContentType.JSON)
            .build();
    }

    public RequestSpecification putRequestSpecification() {
        return new RequestSpecBuilder()
            .build();
    }

    public RequestSpecification deleteRequestSpecification() {
        return new RequestSpecBuilder()
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

    public static TrelloBoard getAnswer(Response response) {
        TrelloBoard answer = new Gson()
            .fromJson(response.asString().trim(), new TypeToken<TrelloBoard>() {
            }.getType());
        return answer;
    }

    public static List<TrelloBoard> getListOfAnswers(Response response) {
        List<TrelloBoard> answers = new Gson()
            .fromJson(response.asString().trim(), new TypeToken<List<TrelloBoard>>() {
            }.getType());
        return answers;
    }
}
