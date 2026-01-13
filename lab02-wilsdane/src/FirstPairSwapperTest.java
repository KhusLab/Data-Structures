import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FirstPairSwapperTest {

    @Test
    public void testIntegerSwap() {
        Integer[] nums = {1, 2, 3, 4};
        FirstPairSwapper<Integer> swapper = new FirstPairSwapper<>(nums);
        assertArrayEquals(new Integer[]{2, 1, 3, 4}, swapper.getArray());
    }

    @Test
    public void testStringSwap() {
        String[] words = {"orange", "banana", "apple"};
        FirstPairSwapper<String> swapper = new FirstPairSwapper<>(words);
        assertArrayEquals(new String[]{"banana", "orange", "apple"}, swapper.getArray());
    }
}
