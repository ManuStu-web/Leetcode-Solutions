class Solution {
    public int reverse(int x) {

        long revNum = 0;
        int n=x;
        while (n!=0) {
            int ld = n % 10;
            revNum = (revNum * 10) + ld;
            n /= 10;
        }

        if (revNum > Integer.MAX_VALUE || revNum < Integer.MIN_VALUE) {
            return 0;
        }

        return (int)revNum;

    }
}
