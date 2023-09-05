import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

//    With times stored in the format "HH:MM:SS", find the number of "interesting" times that can be displayed between two given times S and T (inclusive).
//
//    An "interesting" time is one that can be displayed with at most 2 characters.
//
//    For example S "15:15:00" and T "15:15:12" would return the count of 1 as the only "interesting" time between S and T (inclusive) is "15:15:11".
//
//    Another example, S "22:22:21" and T "22:22:23" would return the count of 3 because of the following times: "22:22:21", "22:22:22", "22:22:23"

    public int solution(String S, String T) {

        LocalTime time1 = splitTime(S);
        LocalTime time2 = splitTime(T);

        int countOfInteresting = 0;

        do {
            String[] array = time1.toString().split("");
            Set<String> set = new HashSet<>(Arrays.asList(array));
            if (set.size()<4) {
                countOfInteresting++;
            }

            time1 = time1.plusSeconds(1);

        } while (!time1.isAfter(time2));

        return countOfInteresting;
    }

    LocalTime splitTime(String time) {
        String[] array = time.split(":");
        LocalTime localTime = LocalTime.of(parseInt(array[0]), parseInt(array[1]), parseInt(array[2]));
        return localTime;
    }

    int parseInt(String a) {
        return Integer.parseInt(a);
    }
}
