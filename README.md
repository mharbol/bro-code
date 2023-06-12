# Bro Code
A collection of [LeetCode](https://leetcode.com/) and similar problems solved with the [best java build tool](https://gradle.org/) on the market.

## [LeetCode 155 - MinStack](https://leetcode.com/problems/min-stack/)
[My solution](src/main/java/io/github/mharbol/brocode/MinStack.java) uses two parallel stacks to make the `MinStack` data structure.
One stack is a traditional stack to keep track of the integers while the other keeps track of the minimum value at the current position of the two stacks.
Doing it this way allows the structure to have $O(1)$ complexity for `push()`, `pop()`, `top()`, and `getMin()` operations.
