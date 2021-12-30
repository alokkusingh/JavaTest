package alok.test.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class HoldingDTO {

    public static String getUniqueId(HoldingDTO hDto) {
        return hDto.hashCode() + "";
    }

    @Override
    public String toString() {
        return hashCode() + "";
    }
}

public class TestMapParallelStream {

    public static void test() {
        HoldingDTO nonUniqueDto = new HoldingDTO();
        List<HoldingDTO> holdingDTOs = Arrays.asList(
                new HoldingDTO(),
                new HoldingDTO(),
                new HoldingDTO(),
                new HoldingDTO(),
                new HoldingDTO(),
                new HoldingDTO(),
                new HoldingDTO(),
                new HoldingDTO(),
                new HoldingDTO(),
                new HoldingDTO(),
                new HoldingDTO(),
                new HoldingDTO(),
                new HoldingDTO(),
                new HoldingDTO(),
                new HoldingDTO(),
                new HoldingDTO(),
                new HoldingDTO(),
                nonUniqueDto,
                nonUniqueDto // this duplicate entry will lead to throw exception from
                // Collectors.toMap method. If we dont handle mergeFunction (3rd optional argument)

        );
        Map<String, HoldingDTO> holdingDTOByUniqueId;
        try {
            holdingDTOByUniqueId = holdingDTOs.parallelStream()
                    .collect(Collectors.toMap(HoldingDTO::getUniqueId, Function.identity(), (x,y) -> {
                        // Need to handle the conflict here
                        System.out.println("Duplicate keys, so returning the 1st one");
                        return x;
                    }));

            System.out.println(holdingDTOByUniqueId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
