# Bro Code
A collection of [LeetCode](https://leetcode.com/) and similar problems solved with the [best java build tool](https://gradle.org/) on the market.

To keep the project available to many problems with reusable components (and just to learn), I turned this into a
[multi-project build](https://docs.gradle.org/current/userguide/multi_project_builds.html).
The project currently has a `leet-code` subproject for LeetCode problems specifically and a `utilities` subproject for utils available to anyone.

## [LeetCode 19 - Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)
[My solution](https://github.com/mharbol/bro-code/blob/master/leet-code/src/main/java/io/github/mharbol/leetcode/EndOfLinkedList.java)
traverses the entire length of the linked list while maintaining an offset (`n`) from which to progress the dropped node.
After walking the length of the linked list, the method can drop the correct node in a simple step.
Maintaining the offset lets this solution achieve a $O(n)$ runtime while iterating over the list only once.

## [LeetCode 21 - Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)
[My solution](https://github.com/mharbol/bro-code/blob/master/leet-code/src/main/java/io/github/mharbol/leetcode/MergeTwoSortedLists.java)
follows pretty easy steps.
We first find an item to assign as the first spot in out return `ListNode` then iteratively compare the two nexts heads to find the next item while progressing
the respective list head as needed.
Once one (or both) have been exhaused, we fill the remainder of our merge with the surviving list.

## [LeetCode 49 - Group Anagrams](https://leetcode.com/problems/group-anagrams/)
[My solution](https://github.com/mharbol/bro-code/blob/master/leet-code/src/main/java/io/github/mharbol/leetcode/GroupAnagrams.java)
uses a `Map<String, List<String>>` to find the anagrams.
The keys are the alphabatized version of the input String and the values are the words whose letters match the keys.

Note: updated solution uses an inner `AnagramComparitor` class and therefore `Map<AnagramComparitor, List<String>>` that works *slightly* better.

## [LeetCode 94 - Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)
[My solution](https://github.com/mharbol/bro-code/blob/master/leet-code/src/main/java/io/github/mharbol/leetcode/InorderTreeTraversal.java)
follows basic priciples from CS class.
We use recursion to traverse left, own value, then right and return the result at each node; at each step we just add the current `val`.
Sometimes basic is fast.

## [LeetCode 128 - Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/)
[Our solution](https://github.com/mharbol/bro-code/blob/master/leet-code/src/main/java/io/github/mharbol/leetcode/LongestConsecutiveSequence.java)
was originally inspired and come up with by my colleague.
In this case we put all the numbers into a set, pop a number from the set, and see how far right and left we can go (removing visited items each time).
This outperformed [the Neet Code solution](https://www.youtube.com/watch?v=P6RZZMu_maU), but the LeetCode servers might have been a little stressed
when I ran it because after a few more runs they were about neck and neck.

## [LeetCode 150 - Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/)
[My solution](https://github.com/mharbol/bro-code/blob/master/leet-code/src/main/java/io/github/mharbol/leetcode/EvaluateReversePolishNotation.java)
makes easy use of a `Stack` to keep track of the calculation.
When we encounter a number, we push it onto the stack, when we encounter an operator, we pop the top two values, execute the operation,
and push the result back on the stack.

## [LeetCode 155 - MinStack](https://leetcode.com/problems/min-stack/)
[My solution](https://github.com/mharbol/bro-code/blob/master/leet-code/src/main/java/io/github/mharbol/leetcode/MinStack.java)
uses two parallel stacks to make the `MinStack` data structure.
One stack is a traditional stack to keep track of the integers while the other keeps track of the minimum value at the current position of the two stacks.
Doing it this way allows the structure to have $O(1)$ complexity for `push()`, `pop()`, `top()`, and `getMin()` operations.

## [LeetCode 189 - Rotate Array](https://leetcode.com/problems/rotate-array/)
[My solution](https://github.com/mharbol/bro-code/blob/master/leet-code/src/main/java/io/github/mharbol/leetcode/ShiftArray.java)
uses the classic solution of making a `temp` array to shift the elements right by `k` and then replaces them in the original (can't reassign the object).
This gives me a $O(n)$ runtime and $O(n)$ space complexity, but I want to do it inplace as well.
Working on a solution where I don't have to iterate over the array `k` times to shift everything to the right/left one at a time.

On a small redux, made the `rotateArrayByOne()` method to do a poor attempt of running the code in constant space.
While this works, it is terribly efficient as the code has to shift right up to `length - 1` times.
This ultimately timed out the massive case in LeetCode. Time to work on the one pass in place approach.

Hopefully the final installment. This came from one of my coworkers.
For this solution we reverse the array so that the "chunks" that need to be on the left and right hand sides of the array are on the
correct sides but just in the reverse order of what they should be.
From there we reverse the two slices (all in place) and our rotation is made in two passes.
<details>
    <summary>More complete example:</summary>

For this example we will use an array of length 5 and `k = 2` (if `k > nums.length` then we just mod it down to size).
First we reverse the entire array.
```
[ 1 2 3 4 5 ]
  <--------
[ 5 4 3 2 1 ]
```
Then we reverse the the chunk of the first `k` followed by the remaining elements.
```
[ 5 4 3 2 1 ]
  <-- <----
[ 4 5 1 2 3 ]
```
And there we have an array rotated by `k`.
</details>

## [LeetCode 224 - Basic Calculator](https://leetcode.com/problems/basic-calculator/)
[My solution](https://github.com/mharbol/bro-code/blob/master/leet-code/src/main/java/io/github/mharbol/leetcode/BasicCalculator.java)
is able to execute the calculation in one pass from left to right.
The `calculate()` method keeps an accumulator which is added to an subtracted from as the index moves from left to right.
Whenever the index reaches an open parenthesis, we kick off a new calculation to evaluate that quantity.
Returns are only ever called when the index reaches the end of the string (this will be the return from the root calculation)
or when we encounter a closing parenthesis.
Carefully placing our `calculate()` calls ensures we do not return early and allows us to nest as many parentheses as we want.
The `parseNumber()` and `progressIndex()` methods were real heros in making this solution a lot cleaner to read.

## [LeetCode 227 - Basic Calculator II](https://leetcode.com/problems/basic-calculator-ii/)
[My solution](https://github.com/mharbol/bro-code/blob/master/leet-code/src/main/java/io/github/mharbol/leetcode/BasicCalculator2.java)
takes a different approach from the first one.
Here we can take advantage of the order of operations and use a `Stack<Integer>` to make the `calculate()` method work.
If the operation is an addition, we push the number onto the stack; subtraction pushes the negative number onto the stack.
In the case of a multiplication, we pop off the stack to make that value the left operand and push its product with the right operand.
We follow the same logic for division.
Once done, we sum all of the values in the stack and return the result.
Effectively, we evaluate all the chunks of multiplication first so that the only operation left is addition and subtraction.

## [LeetCode 1551 - Minimum Operations to Make Array Equal](https://leetcode.com/problems/minimum-operations-to-make-array-equal/)
[The best solution](https://github.com/mharbol/bro-code/blob/master/leet-code/src/main/java/io/github/mharbol/leetcode/MinOpArr.java) requires a lot of maff.
In short, we proved a closed form for if there were an even or odd number of items in the array;
once that was determined, we applied the closed form for the given case.
<details>
    <summary>See the full details:</summary>

### Some proofs to start (this may seem silly, but it is important):
#### Proof (by induction) that the sum of the first $n$ odd numbers is $n^2$.
First, we let $a_n = 1 + 3 + 5 + ... + (2n - 1)$ be the sum of the first $n$ odd numbers.
We assert that $a_n = n^2$.
We know this is true for $n = 1$ (the base case); $a_1 = 1$.
The value of $a_n$ can be recursively defined in terms of the previous value, $a_n = a_{n - 1} + (2n - 1)$.
This definition shows that the current sum is equal to the previous sum plus the next odd number in the sequence.
We use these definitions and assuptions to prove the assumption is true for the next case.
Let $k + 1$ represent the index of the next value in the sequence.
This means that $a_{k + 1} = a_k + 2(k + 1) - 1$.
If we substitute $a_k = k^2$ (our assertion), then $a_{k + 1} = k^2 + 2k + 2 - 1 = k^2 + 2k + 1 = (k + 1)^2$,
which is the the same as the initial assuption in the $k + 1$ case.

#### Proof that the sum of the first $n$ even numbers is $n(n + 1)$.
This can be proven in a similar way as before.
Let $a_n = 2 + 4 + ... + 2n$.
We assert that $a_n = n(n + 1)$. This assertion is true for $n = 1$.
We know the sum can be recursively defined as $a_n = a_{n - 1} + 2n$.
Using this definition and our assertion for the next case,
$a_{k + 1} = a_k + 2(k + 1) = k(k + 1) + 2(k + 1) = (k + 2) (k + 1)$
which is the same as the initial assumption for the $k + 1$ case.

### The average value of the array:
By the definitions of the array values in the problem, the array of length $n$ is the first $n$ odd numbers.
This means that the sum of the numbers in the array is $n^2$ and the average value is $n$.
Because the "operation" adds one and subtracts one at each step, the total value (and therefore average) does not change.
This means that if the conditions of problem are met - all values are the same - then all values must equal the initial average value at the end.

### The first few arrays:
The method displayed in the example is the optimal way to bring all values down to the average.
Each value's mirroring counterpart is equidistant from the average in the opposite operation.
The first few cases are displayed below, `+x` refers to the number of add operations that need to be applied
while `-y` refers to the total number of subtractions. Notice that the +/- pairs mirror each other.
```
n | array                           | minOp
--+---------------------------------+-------
1 | [ 1 ]                           | 0
  |                                 |
--+---------------------------------+-------
2 | [ 1   3 ]                       | 1
  |  +1  -1                         |
--+---------------------------------+-------
3 | [ 1   3   5 ]                   | 2
  |  +2      -2                     |
--+---------------------------------+-------
4 | [ 1   3   5   7 ]               | 4
  |  +3  +1  -1  -3                 |
--+---------------------------------+-------
5 | [ 1   3   5   7   9 ]           | 6
  |  +4  +2      -2  -4             |
--+---------------------------------+-------
6 | [ 1   3   5   7   9   11]       | 9
  |  +5  +3  +1  -1  -3  -5         |
--+---------------------------------+-------
7 | [ 1   3   5   7   9   11   13 ] | 12
  |  +6  +4  +2      -2  -4   -6    |
```
When the $n$ value is even, the `minOp` is the sum of the first $n/2$ odd numbers.
When the $n$ value is odd, the `minOp` is the sum of the first $(n - 1) / 2$ even numbers.
Since we know these sums from earlier, the problem becomes almost trivial.
```java
int half = n / 2; // integer division
if (n % 2 == 0)
    return half * half;
else
    return half * (half + 1);
```

</details>

## The Jump Game Saga
All of these deserve to be grouped together.
These were a load of fun to work along with some friends from work.
### [LeetCode 55 - Jump Game](https://leetcode.com/problems/jump-game/)
[Our solution](https://github.com/mharbol/bro-code/blob/master/leet-code/src/main/java/io/github/mharbol/leetcode/jumpgame/JumpGame1.java)
starts at the end of the array and looks for the next zero (the next "obstacle" to jump over).
Once we get there, we spawn a pointer just left of the zero to look for the nearest position which can jump the zero.
After this position is found, we set `zeroPointer` to the last jumpable position and keep moving to the end.
If `zeroPointer` makes it to the start of the array, then the array is jumpable.
If the pointer looking for the next jumpable point falls off the array, then it is not jumpable.

### [LeetCode 45 - Jump Game II](https://leetcode.com/problems/jump-game-ii/)
[Our solution](https://github.com/mharbol/bro-code/blob/master/leet-code/src/main/java/io/github/mharbol/leetcode/jumpgame/JumpGame2.java)
uses a similar approach as the first game.
We start off from where we want to go and dispatch a pointer to find the farthest left position where we can get there.
Since making it to the end is assured, we can afford this lax approach to finding the optimal path to the end.
