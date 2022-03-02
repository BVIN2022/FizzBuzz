package apitests;
import io.restassured.http.ContentType;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ComputeTest {

    //Case#2 from README.md file
    @Test
    public void test_ResponseContainsArraysForNonMultiplesOf3And5() {

        given().
            param("value","1").
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

}
