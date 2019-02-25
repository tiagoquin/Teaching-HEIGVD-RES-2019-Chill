package ch.heigvd.res.chill.domain.yoannsim;
import ch.heigvd.res.chill.domain.Bartender;
import ch.heigvd.res.chill.protocol.OrderRequest;
import ch.heigvd.res.chill.protocol.OrderResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TequilaTest {
    @Test
    void thePriceAndNameForTequilaTestShouldBeCorrect() {
        Tequila beer = new Tequila();
        assertEquals(beer.getName(), Tequila.NAME);
        assertEquals(beer.getPrice(), Tequila.PRICE);
    }

    @Test
    void aBartenderShouldAcceptAnOrderForTequilaTest() {
        Bartender jane = new Bartender();
        String productName = "ch.heigvd.res.chill.domain.yoannsim.Tequila";
        OrderRequest request = new OrderRequest(3, productName);
        OrderResponse response = jane.order(request);
        BigDecimal expectedTotalPrice = Tequila.PRICE.multiply(new BigDecimal(3));
        assertEquals(expectedTotalPrice, response.getTotalPrice());
    }

}