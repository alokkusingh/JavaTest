package alok.test.logic.maxoccurances;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void getTopBrokers() {
        int[] data = {1, 2, 3, 4, 5, 2, 1, 2, 5, 9, 10, 12, 11, 10};
        int k = 3;
        int[] result = App.getTopBrokers(data,k);
        System.out.println(Arrays.toString(result));
    }
}