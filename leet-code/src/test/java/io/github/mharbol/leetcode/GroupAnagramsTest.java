
package io.github.mharbol.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * GroupAnagramsTest
 */
public class GroupAnagramsTest {

    private static GroupAnagrams cut;
    private List<List<String>> actual;
    private List<List<String>> expected;
    private String[] input;

    @BeforeClass
    public static void setupBeforeClass() {
        cut = new GroupAnagrams();
    }

    @Before
    public void setup() {
        expected = new ArrayList<>();
        actual = new ArrayList<>();
    }

    @Test
    public void testLeetCodeExample1() {
        input = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
        expected = Arrays.asList(Arrays.asList("bat"), Arrays.asList("nat", "tan"), Arrays.asList("ate", "eat", "tea"));
        actual = cut.groupAnagrams(input);
        checkLists(expected, actual);
    }

    @Test
    public void testLeetCodeExample2() {
        input = new String[] { "" };
        expected = Arrays.asList(Arrays.asList(""));
        actual = cut.groupAnagrams(input);
        checkLists(expected, actual);
    }

    @Test
    public void testLeetCodeExample3() {
        input = new String[] { "a" };
        expected = Arrays.asList(Arrays.asList("a"));
        actual = cut.groupAnagrams(input);
        checkLists(expected, actual);
    }

    /**
     * Verifes that actual and expected Lists contain the same elements even if they
     * are not in the same order.
     * 
     * @param expected the expected result
     * @param actual   the returned value from testing
     * @return true if the Lists are the same otherwise false
     */
    private boolean checkListsSame(List<List<String>> expected, List<List<String>> actual) {
        for (List<String> list : expected) {
            Collections.sort(list);
        }
        for (List<String> list : actual) {
            Collections.sort(list);
        }
        return expected.containsAll(actual) && actual.containsAll(expected);
    }

    private void checkLists(List<List<String>> expected, List<List<String>> actual) {
        Assert.assertTrue(checkListsSame(expected, actual));
    }

    // Tests for checkListsSame() support method
    @Test
    public void testCheckListsTrivial() {
        expected = Arrays.asList(Arrays.asList("a", "b", "c"), Arrays.asList("d", "e", "f"));
        actual = Arrays.asList(Arrays.asList("a", "b", "c"), Arrays.asList("d", "e", "f"));
        Assert.assertTrue(checkListsSame(expected, actual));
    }

    @Test
    public void testCheckListsStrings() {
        expected = Arrays.asList(Arrays.asList("abc", "def"), Arrays.asList("hi", "jklm", "nop"));
        actual = Arrays.asList(Arrays.asList("jklm", "nop", "hi"), Arrays.asList("def", "abc"));
        Assert.assertTrue(checkListsSame(expected, actual));
    }

    @Test
    public void testCheckListsSwapped() {
        expected = Arrays.asList(Arrays.asList("a", "b", "c"), Arrays.asList("d", "e", "f"));
        actual = Arrays.asList(Arrays.asList("d", "e", "f"), Arrays.asList("a", "b", "c"));
        Assert.assertTrue(checkListsSame(expected, actual));
    }

    @Test
    public void testCheckListsScrambled() {
        expected = Arrays.asList(Arrays.asList("c", "a", "b"), Arrays.asList("d", "e", "f"));
        actual = Arrays.asList(Arrays.asList("f", "e", "d"), Arrays.asList("a", "b", "c"));
        Assert.assertTrue(checkListsSame(expected, actual));
    }

    @Test
    public void testCheckListsDifferentLengths() {
        expected = Arrays.asList(Arrays.asList("c", "a", "b"), Arrays.asList("d", "e", "f"));
        actual = Arrays.asList(Arrays.asList("f", "e", "d"), Arrays.asList("a", "b", "c"), Arrays.asList("z"));
        Assert.assertFalse(checkListsSame(expected, actual));
    }
}
