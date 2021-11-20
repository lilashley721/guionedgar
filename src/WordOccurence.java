import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordOccurence {
    static void countEachWords(String fileName, Map<String, Integer> words) throws FileNotFoundException {

        Scanner file = new Scanner(new File(fileName));
        while (file.hasNext()) {
            String word = file.next();
            Integer count = words.get(word);
            if (count != null)
                count++;
            else
                count = 1;
            words.put(word, count);
        }
        file.close();
    }


    public static void main(String[] args) throws FileNotFoundException {

        Map<String, Integer> words = new HashMap<String, Integer>();
        countEachWords("eap.txt", words);
        //System.out.println("\n" + words + "\n");
        System.out.println("Top Twenty Words");
        System.out.println("\n" +  getMaxTwenty(words) + "\n");
    }

     static Map<String, Integer> getMaxTwenty(Map<String, Integer> words) {
        Map<String, Integer> maxTwenty = new HashMap<String, Integer>();
        String[] arrKey = new String[words.size()];
        int[] arrVal = new int[words.size()];
        int counter1 = 0;
        for (int a : words.values()) {
            arrVal[counter1] = a;
            counter1++;
        }
        counter1 = 0;
        for (String a : words.keySet()) {
            arrKey[counter1] = a;
            counter1++;
        }

        int counter = 0;
        List<String> arr = new ArrayList<>(Arrays.asList());
        List<Integer> arr1 = new ArrayList<>(Arrays.asList());
        while (counter <= 20) {
            counter++;
            int temp = 0;
            int indexing = 0;
            for (int a = 0; a < arrVal.length; a++) {
                if (!arr.contains(arrKey[a])) {
                    if (temp < arrVal[a]) {
                        temp = arrVal[a];
                        indexing = a;
                    }
                }
            }
            arr.add(arrKey[indexing]);
            arr1.add(arrVal[indexing]);
        }
        for (int a =0 ;a<arr1.size();a++){
            maxTwenty.put(arr.get(a),arr1.get(a));
        }
//        for (int a : arr1) {
//            System.out.println(a);
//        }
//        for (String a : arr) {
//            System.out.println("Max"+maxTwenty);
//        }

        return maxTwenty;

    }
}