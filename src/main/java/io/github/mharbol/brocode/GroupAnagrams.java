
package io.github.mharbol.brocode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GroupAnagrams
 * Wrapper class for LeetCode problem 49.
 */
public class GroupAnagrams {

    /**
     * Groups {@link String}s by anagrams
     *
     * @param strings an array of {@link String}s
     * @return a {@link List} of all groupings of anagrams
     */
    public List<List<String>> groupAnagrams(String[] strings) {

        Map<String, List<String>> anagramMap = new HashMap<>();
        
        for (String word : strings) {
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String key = new String(letters);

            // attempt to add the word to a list in the Map
            try {
                anagramMap.get(key).add(word);
            }
            // if none found, make a new list, add word, and add the list to the map
            catch (NullPointerException e) {
                List<String> stringList = new ArrayList<>();
                stringList.add(word);
                anagramMap.put(key, stringList);
            }
        }

        return new ArrayList<List<String>>(anagramMap.values());
    }
}
