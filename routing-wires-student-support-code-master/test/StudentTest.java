import org.junit.jupiter.api.Test;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class StudentTest {

    @Test
    public void testWire0() {
        assertTimeout(Duration.ofMillis(1000), () -> {
            Utilities.test("./test/inputs/wire0.in");
        });
    }

    @Test
    public void testWire1() {
        assertTimeout(Duration.ofMillis(1000), () -> {
            Utilities.test("./test/inputs/wire1.in");
        });
    }

    @Test
    public void testWireWithObstacle() {
        assertTimeout(Duration.ofMillis(1000), () -> {
            Utilities.test("./test/inputs/wire_obstacle.in");
        });
    }

    @Test
    public void testMultipleWires() {
        assertTimeout(Duration.ofMillis(1000), () -> {
            Utilities.test("./test/inputs/wire_multiple.in");
        });
    }

    @Test
    public void testNoPathExists() {
        assertTimeout(Duration.ofMillis(1000), () -> {
            Utilities.test("./test/inputs/wire_nopath.in");
        });
    }

    @Test
    public void testTightBoard() {
        assertTimeout(Duration.ofMillis(1000), () -> {
            Utilities.test("./test/inputs/wire_tight.in");
        });
    }
}

