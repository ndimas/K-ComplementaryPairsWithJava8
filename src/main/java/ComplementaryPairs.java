import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by emrah.bektas on 20/01/17.
 */
public class ComplementaryPairs {

    public static Map getKComplementaryPairs(Integer sum, Integer[] listOfIntegers) {

        //First fill up the pairs with the complementary numbers
        Map<Integer, Integer> pairs = Arrays.stream(listOfIntegers).collect(Collectors.toMap(number -> number, number -> sum-number));

        //Then filter out the pairs that have corresponding complementary number and complementary number is not equla to that element of the array
        Map<Integer, Integer> map = Arrays.stream(listOfIntegers)
                .filter(number -> pairs.containsKey(sum-number) && number != sum - number)
                .collect(Collectors.toMap(pair -> pairs.get(pair), pair -> pair));

        //Because of two stream of array(listOfIntegers), Total complexity O(n)+O(n) ==> O(n)
        return map;
    }

    public static void main(String[] args) {
        Integer[] arrayOfIntegers = new Integer[] {4,5,6,3,1,8,-7,-6};
        Integer k = 9;
        Map<Integer, Integer> pairs = getKComplementaryPairs(k, arrayOfIntegers);
        for (Integer key : pairs.keySet()) {
            System.out.println(" Pairs are "+key + " and " + pairs.get(key));
        }
    }

}