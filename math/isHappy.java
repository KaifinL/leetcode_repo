class Solution {

    private int next_num(int curr) {
        int result = 0;
        while (curr != 0) {
            int last = curr%10;
            curr /= 10;
            result += (last*last);
        }
        return result;
    }

    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = next_num(n);
        }
        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }
}


/*

My solution above is correct, but not effective enough. If you notice that
a non-happy number can form a circle, then you should be aware that
a double pointers can be used here to detect the cycle.

Therefore, instead of using a hashset, the only thing we need to do 
is to compare whether the slower pointer is equal to the faster pointer.
Or if any of them is equal to 0.

See the official website for a better explaination. Below is the solution I
copied paste from the official solution.

*/
class Solution {

     public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }
}