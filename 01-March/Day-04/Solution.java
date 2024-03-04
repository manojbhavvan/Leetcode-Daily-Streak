class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        int count = 0;
        Arrays.sort(tokens);
        int left = 0, right = n - 1;
        int maxScore = 0;
        while (left <= right) {
            if (tokens[left] <= power) {
                power -= tokens[left++];
                count++;
                maxScore = Math.max(maxScore, count);
            } else if (count > 0) {
                power += tokens[right--];
                count--;
            } else {
                break;
            }
        }
        return maxScore;
    }
}
/*
Algo used
1. We start with a power of 0 and a score of 0.
2. We sort the tokens because it's easier to manage them this way.
3. We have two strategies:
4. If we have enough power, we'll spend tokens to gain points.
5. If we have points, we'll spend them to gain power.
6. We'll keep track of the maximum points achieved during this process.
7. We'll iterate through the tokens using two pointers - one starting from the beginning and the other from the end.
8. We'll keep moving the pointers based on whether we're spending tokens to gain points or spending points to gain power.
9. We'll stop when we can't do either anymore.
10. The maximum points achieved will be our answer.
*/