/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import org.junit.Test;

import java.util.UUID;
import java.util.stream.IntStream;

public class DummyTest {
    @Test
    public void generateUUIDs() {
        IntStream.range(1, 10).forEach(i -> {
            System.out.println(UUID.randomUUID());
        });
    }
}
