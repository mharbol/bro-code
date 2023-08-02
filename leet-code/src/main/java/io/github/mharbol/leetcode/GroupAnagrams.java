
package io.github.mharbol.leetcode;

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

        Map<AnagramComparitor, List<String>> anagramMap = new HashMap<>();

        for (String word : strings) {

            AnagramComparitor key = new AnagramComparitor(word);

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

    /**
     * Class to quickly(ish) compare {@link String}s as anagrams.
     *
     * Using {@link Comparable} is not totally necessary, it is just there in case
     * an orderd {@link Map} is considered useful in the furture
     */
    class AnagramComparitor implements Comparable<AnagramComparitor> {

        /**
         * The number of lowercase letters
         */
        private static final int NUM_LOWER_CASE_LETTERS = 26;

        /**
         * Keeps count of the instances of any given lowercase English letter
         */
        private int[] charCounts = new int[NUM_LOWER_CASE_LETTERS];

        public AnagramComparitor(String word) {
            for (char letter : word.toCharArray()) {
                charCounts[letter - 'a']++;
            }
        }

        /**
         * Compares this AnagramComparitor with another AnagramComparitor
         * 
         * @param other the other AnagramComparitor to compare to
         * @return a negative integer, zero, or positive integer if this
         *         AnagramComparitor is less than, equal to, or greater than other
         */
        @Override
        public int compareTo(AnagramComparitor other) {

            int thisLetter, otherLetter;

            for (int index = 0; index < NUM_LOWER_CASE_LETTERS; index++) {
                thisLetter = this.charCounts[index];
                otherLetter = other.charCounts[index];
                if (thisLetter < otherLetter) {
                    return -1;
                }
                if (thisLetter > otherLetter) {
                    return 1;
                }
            }
            return 0;
        }

        /**
         * Checks for equality.
         * 
         * @param other the other AnagramComparitor to check equality against
         * @return true if the AnagramComparitors are equal otherwise false
         */
        @Override
        public boolean equals(Object other) {
            if (other == null) {
                return false;
            }
            if (!(other instanceof AnagramComparitor)) {
                return false;
            }
            return this.compareTo((AnagramComparitor) other) == 0;
        }

        /**
         * Hash code for this AnagramComparitor
         *
         * @return the hash code for this AnagramComparitor
         */
        @Override
        public int hashCode() {
            return Arrays.hashCode(charCounts);
        }
    }
}
