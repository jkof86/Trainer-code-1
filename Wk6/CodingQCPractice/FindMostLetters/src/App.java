import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class App {

    public static String findTheMostOccuringLetters(String[] listOfString)
    {
         
            List<Character> sortedCharList = new ArrayList();
            Map<Character, Integer>  charMap = new HashMap<Character, Integer>();

            

            //we use this to determine the max occurrence
            int currentMax = 0;

        for (int i=0; i<listOfString.length; i++) {
            //we need to iterate through each string in the array
            
        
            //we convert the string into a List of Characters so we can sort easily
            for (int j=0; j<listOfString[i].length(); j++){
                String s = listOfString[i];
                char c = s.charAt(j);

                sortedCharList.add(c);
            }

            //we sort after each string is converted
            sortedCharList.sort(null);

            //for debugging
            System.out.println(sortedCharList.toString());
        }

        //we need to count the frequency of each letter
        for (int k=0; k<sortedCharList.size();k++) {
            char c = sortedCharList.get(k);

            Integer temp = charMap.get(c);

            //if the character key doesn't exist in the map, we add the first occurrence
            if (temp == null) {
                charMap.put(c, 1);
            } 
            //otherwise we increment the value of the key
            else {
                temp = temp.intValue()+1;
                charMap.put(c, temp);
            }
        }

        //our char map is created successfully
        System.out.println(charMap);

        //this will hold the final answer as a map entry
        Map.Entry<Character, Integer> answer = new Entry<Character,Integer>() {
            
        };

        //we need to find the max occurence in the map and return the correct answer
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
            
            //if the entry value is larger then the currentMax the answer is switched out
            if(entry.getValue() > currentMax) {
                answer = entry;

                //we remember to set the currentMax to the new  larger value
                currentMax = entry.getValue();
            }
        }

        //debugging
        System.out.println(answer.toString());

        //finally we return the correct answer
        return answer.getKey() + " - " + answer.getValue();
    }
    public static void main(String[] args) throws Exception {
        Map<String[], String> testcases = new HashMap<>();

        testcases.put(new String[]{"employ", "address", "liberal", "twin", "slump", "ton", "entitlement", "ruin", "offense", "normal"}, "e - 8");
        testcases.put(new String[]{"aa", "bb", "cc", "dd", "ee", "ff"}, "a - 2");
        testcases.put(new String[]{"screw", "is", "relinquish", "fragrant", "slump", "fling", "econobox", "mouse", "effort", "effort"}, "e - 6");
        testcases.put(new String[]{"prediction", "prediction", "prediction", "prediction"}, "i - 8");
        testcases.put(new String[]{"hemisphere", "hemisphere", "prediction", "accessible", "tournament", "leadership", "compliance", "understand", "dependence", "memorandum"}, "e - 19");

        long startTime = System.currentTimeMillis();

        for (Entry<String[], String> elemeEntry : testcases.entrySet()) {
            System.out.println(Arrays.toString(elemeEntry.getKey()));

            String actual = findTheMostOccuringLetters(elemeEntry.getKey());

            if (actual.equals(elemeEntry.getValue())) {
                System.out.println("\u001B[32m"+"Correct"+"\u001B[0m");
                System.out.println("most concurrent letter is " + elemeEntry.getValue());
            }else {
                System.out.println("\u001B[31m"+"Failed"+"\u001B[0m");
                System.out.println("Your method gave: " + actual);
                System.out.println("Expected output: " + elemeEntry.getValue());
            }
            
            System.out.println("===============================");
        }

        System.out.println("Time it took to finish " + (System.currentTimeMillis() - startTime) + "ms");
    }
}
