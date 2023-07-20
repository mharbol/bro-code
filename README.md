# Bro Code
A collection of [LeetCode](https://leetcode.com/) and similar problems solved with the [best java build tool](https://gradle.org/) on the market.

## [LeetCode 49 - Group Anagrams](https://leetcode.com/problems/group-anagrams/)
[My solution](src/main/java/io/github/mharbol/brocode/GroupAnagrams.java) uses a `Map<String, List<String>>` to find the anagrams.
The keys are the alphabatized version of the input String and the values are the words whose letters match the keys.

## [LeetCode 155 - MinStack](https://leetcode.com/problems/min-stack/)
[My solution](src/main/java/io/github/mharbol/brocode/MinStack.java) uses two parallel stacks to make the `MinStack` data structure.
One stack is a traditional stack to keep track of the integers while the other keeps track of the minimum value at the current position of the two stacks.
Doing it this way allows the structure to have $O(1)$ complexity for `push()`, `pop()`, `top()`, and `getMin()` operations.

## [LeetCode 1551 - Minimum Operations to Make Array Equal](https://leetcode.com/problems/minimum-operations-to-make-array-equal/)
[The best solution](src/main/java/io/github/mharbol/brocode/MinOpArr.java) requires a lot of maff.
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
1 | [1]                             | 0
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

