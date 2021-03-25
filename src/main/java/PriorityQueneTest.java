import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PriorityQueneTest {
    private static Stream<Arguments> param_input(){
        return Stream.of(
                Arguments.of(new int []{1,4,3,2}, new int []{1,2,3,4}),
                Arguments.of(new int []{3,7,4,2}, new int []{2,3,4,7}),
                Arguments.of(new int []{5,8,6,7}, new int []{5,6,7,8}),
                Arguments.of(new int []{7,6,9,8}, new int []{6,7,8,9}),
                Arguments.of(new int []{9,4,6,8}, new int []{4,6,8,9}),
                Arguments.of(new int []{1,8,4,3}, new int []{2,5,7,9}),
                Arguments.of(new int []{8,6,2,4}, new int []{4,3,2,8})
        );
    }

    @ParameterizedTest
    @MethodSource("param_input")
    public void Parameter_Quene_Test(int[] queneInput, int[] excepted){
        PriorityQueue PQT = new PriorityQueue();
        for (int a:queneInput){
            assertTrue(PQT.offer(a));
        }
        for (int b:excepted){
            assertEquals(b,PQT.poll());
        }
    }

    @Test
    public void IllegalException(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->{
            new PriorityQueue(0, null);
        });
    }

    @Test
    public void nullException(){
        Exception exception = assertThrows(NullPointerException.class, () ->{
            new PriorityQueue().add(null);
        });
    }

    @Test
    public void nullexception(){
        Exception exception = assertThrows(NullPointerException.class, () ->{
            new PriorityQueue().removeIf(null);
        });
    }
}
