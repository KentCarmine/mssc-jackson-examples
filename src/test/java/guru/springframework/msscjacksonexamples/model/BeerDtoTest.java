package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class BeerDtoTest extends  BaseTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializedDto() throws Exception {
        BeerDto dto = getDto();

        String jsonString = objectMapper.writeValueAsString(dto);

        System.out.println(jsonString);
    }

    @Test
    void testDeserializeDto() throws Exception {
        String json = "{\"id\":\"177dd726-12a5-46c0-86a7-d611de05c8ee\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123123123123,\"price\":12.99,\"createdDate\":\"2020-09-25T15:44:03.6168255-05:00\",\"lastUpdatedDate\":\"2020-09-25T15:44:03.6178267-05:00\"}";

        BeerDto dto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(dto);
    }
}