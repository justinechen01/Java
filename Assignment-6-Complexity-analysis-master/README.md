# Assignment-6-Complexity-analysis

Problem 1: 

Choose an appropriate set of operations to count: the number of time the array is access 

The worst-case scenario is when the loop runs every single iteration to find abs(dubs[i] - d) < eps. The loop will only end if an element in dubs[i]-1 is less then eps. Then the loop will run n time to find that element which result to running all the iterations. 

The worst-case scenario is T(n)

Problem 2:

Appropriate set of operations to count: the amount of time the recurssive call is called. 

Every time when the recurrsive it is dividing the integer up. The worst case scenario is that it divides the number mutiple times because the number is too large.

The worst-case scenario T(logn)

Problem 3: 

I counted myArr[x++] = new IntPair(arr[i],arr[j]);

The loop will iterate through two loops. The loop will iterate through the array depending on the length. If the length is long, then loop will be iterating longer. The loop will only terminate when the function finds each element’s possible pairs. 

The worst-case scenario T(n^2)



Problem 4: 

I counted how many times the array is called. 

The worst-case scenario T(n^2) it is because there are two for loops in my program. 

Yes, with the new information my answer has change. There are two arrays and my code complexity depends on the array two array size. If the array is the same, then it will be O(n) =O(m). If n < m then the run time will be O(m). Otherwise it will be O(n). 

Problem 5 
I counted how many times the array is called. 

The worst-case scenario is O (m + n)

There are two arrays and my code complexity depends on the array two array size. If the array is the same, then it will be O(n) =O(m). If n < m then the run time will be O(m). Otherwise it will be O(n). 

If we know time complexity of a function we can still put the bound on O (m+n). 
