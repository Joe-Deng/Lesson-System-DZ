import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class test {
    @Test
    void test(){
        List<String> strings = Arrays.asList("abc","123");
        strings.forEach(System.out::println);
    }
}
