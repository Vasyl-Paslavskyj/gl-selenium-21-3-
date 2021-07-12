import application.LiteCartApplication;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class CommonTest {
    public static LiteCartApplication app;

    @BeforeAll
    public static void startApplication() {
        app = new LiteCartApplication();
    }

    @AfterAll
    static void stopApplication() {
        app.closeApp();
    }

}
