package examples;


import org.junit.Test;
import org.junit.runner.RunWith;
import com.tngtech.java.junit.dataprovider.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(DataProviderRunner.class)
public class Chapter3Test {

    @DataProvider
    public static Object[][] zipCodesAndPlaces(){
        return new Object[][]{
                {"us","90210", "Beverly Hills", "gogogo"},
                {"us", "12345", "Schenectady", "ffwefwe"},
                {"ca", "B2R", "Waverley", "wfwefwefwefw"}
        };
    }

    @Test
    @UseDataProvider("zipCodesAndPlaces")
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectSpecifiedPlaceNAme(String countryCode, String zipCode, String expectedPlaceName, String koko){
        given().
                pathParam("countryCode", countryCode).pathParam("zipCode", zipCode).
                when().
                get("http://zippopotam.us/{countryCode}/{zipCode}").
                then().
                assertThat().
                body("places[0].'place name'",equalTo(expectedPlaceName));
    }

    @Test
    @UseDataProvider("zipCodesAndPlaces")
    public void testTwoDimensionObjectArray(String countryCode, String zipCode, String expectedPlaceName, String koko){

        System.out.println(countryCode);
        System.out.println(zipCode);
        System.out.println(expectedPlaceName);
        System.out.println(koko);

    }
}
