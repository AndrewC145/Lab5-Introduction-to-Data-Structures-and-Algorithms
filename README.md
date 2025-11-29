# Lab5-Introduction-to-Data-Structures-and-Algorithms

## video reflection
[![lab 5](https://img.youtube.com/vi/VRa-rQL52nk/0.jpg)](youtube.com/watch?v=VRa-rQL52nk)

1. Benchmark Overview

Performance testing was conducted on the custom DoublyLinkedList implementation to analyze how its core operations scale with increasing input sizes. The tested operations include:

Insert (addLast)

Search (contains)

Access (getAt)

Remove (removeFirst)


Execution time was measured using System.nanoTime(), and results were converted to milliseconds (ms) for readability.
Input sizes tested: 1,000, 5,000, 10,000, and 50,000 elements.


---

2. Benchmark Results (in milliseconds)

N	Insert (ms)	Search (ms)	Access (ms)	Remove (ms)

1,000	0.826	4.203	1.619	0.076
5,000	0.340	29.511	25.543	0.147
10,000	0.513	104.252	69.815	0.385
50,000	3.339	2925.701	1992.298	1.425



---

3. Runtime Analysis

Insert (addLast) Expected O(1)

Insertion at the tail of the list remained very fast across all sizes. Times ranged from 0.34 ms to 3.34 ms, demonstrating low growth relative to input size. This matches the expected constant-time performance for appending to a doubly linked list with a maintained tail reference.


---

Remove (removeFirst)  Expected O(1)

Deletion from the front showed similarly stable performance, remaining under 1.5 ms even at 50,000 elements. Like insertion, this reflects the expected O(1) complexity of removing the head node.


---

Search (contains)  Expected O(n)

The search operation exhibited steep linear growth as the list size increased. Search times rose from 4.2 ms at 1,000 elements to 2,925 ms (2.9 seconds) at 50,000 elements. Since searching requires traversing nodes sequentially, this behavior aligns with the theoretical O(n) complexity.


---

Access by Index (getAt) – Expected O(n)

Index-based access demonstrated similar scaling, increasing from 1.6 ms at 1,000 elements to nearly 2 seconds at 50,000 elements. Because a doubly linked list must traverse nodes to reach a specific index, the measured results are consistent with linear time access.




4. Conclusion

The benchmark results clearly support the theoretical time complexities of a doubly linked list:

O(1): insertion at tail, removal from front

O(n): search, index access


Constant-time operations remained extremely fast and scaled minimally with input size. Linear-time operations showed significant growth, especially at large N, reflecting the traversal-based nature of linked lists.
Overall, the implementation behaves as expected, and the benchmark data confirms its scalability characteristics.
