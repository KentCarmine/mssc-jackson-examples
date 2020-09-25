package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("snake")
@JsonTest
public class BeerDtoSnakeTest extends BaseTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSnakeSerialize() throws Exception {
        BeerDto dto = getDto();

        String json = objectMapper.writeValueAsString(dto);

        System.out.println(json);
    }

    @Test
    void testSnakeDeserialize() throws Exception {
        String json = "{\"id\":\"890d582c-4887-464a-a15b-15c5d7f375e6\",\"beer_name\":\"BeerName\",\"beer_style\":\"Ale\",\"upc\":123123123123,\"price\":12.99,\"created_date\":\"2020-09-25T16:57:26.3858823-05:00\",\"last_updated_date\":\"2020-09-25T16:57:26.3858823-05:00\"}";

        BeerDto dto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(dto);
    }
}
