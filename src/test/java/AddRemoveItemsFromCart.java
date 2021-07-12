import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static units.TestUtils.getCOUNT;

public class AddRemoveItemsFromCart extends CommonTest{
    @Test
    public void add_remove_items() {
        app.openPage();
        for (int i = 1; i <= Integer.parseInt(getCOUNT()); i++){
            app.selectProduct();
            app.addProduct(i);
        }
        Assertions.assertEquals(app.getDucksCountInCart(), getCOUNT());
        app.selectCart();
        app.removeProducts();
        app.navigateOnHome();
        Assertions.assertEquals(app.getDucksCountInCart(), "");
    }
}
