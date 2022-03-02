package apitests;
import io.restassured.http.ContentType;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ComputeTest {

    //Case#2 from README.md file
    @Test
    public void validateResponseContainsArraysForNonMultiplesOf3And5() {

        given().
            queryParam("value","1").
        when().
                get("http://localhost:8080/compute").
        then().
            assertThat().
            statusCode(200).
        and().
            contentType(ContentType.JSON).
            body("output",hasSize(1)).
            body("output[0].1", hasItems("Divided 1 by 3","Divided 1 by 5"));

    }

    //Case#3 from README.md file
    @Test
    public void validateResponseContainTwoItemsWhenSameSameInputIsProvidedTwice() {

        given().
            queryParam("value","1").
            queryParam("value","1").
        when().
            get("http://localhost:8080/compute").
        then().
            assertThat().
            statusCode(200).
        and().
            contentType(ContentType.JSON).
                body("output",hasSize(2)).
                body("output[0].1", hasItems("Divided 1 by 3","Divided 1 by 5")).
                body("output[1].1", hasItems("Divided 1 by 3","Divided 1 by 5"));

    }
    //Case#4 from README.md file
    @Test
    public void validateResponseIgnoresInvalidParameterAndReturnsResponseForValidParameter() {

        given().
            queryParam("valuex","1").
            queryParam("value","3").
        when().
            get("http://localhost:8080/compute").
        then().
            assertThat().
            statusCode(200).
        and().
            contentType(ContentType.JSON).
            body("output",hasSize(1)).
            body("output[0].3", is("Fizz"));

    }

    //Case#4 from README.md file
    @Test
    public void validateResponseIgnoresInvalidParameterAndReturnsExptyArray() {

        given().
            queryParam("valuex","1").
            queryParam("valuex","3").
        when().
            get("http://localhost:8080/compute").
        then().
            assertThat().
            statusCode(200).
        and().
            contentType(ContentType.JSON).
            body("output",hasSize(0));
    }

}
