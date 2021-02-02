class Pow {
    public double myPow(double x, int n) {
        long N = n; // if n is MIN_VALUE and -n will overflow
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return helper_third(x, N);
    }

    // 2^3: ans = 1, product = 2
    // i = 3, ans = 2, product = 4
    // i = 1, ans = 8, product = 16
    // return 8
    // 2^4: ans = 1, product = 2
    // i = 4, ans = 1, product = 4
    // i = 2, ans = 1, product = 16
    // i = 1, ans = 16, product = 16 * 16
    // return 16
    public double helper_third(double x, long n) {
        double ans = 1;
        double product = x;
        for (long i = n; i > 0; i /= 2) {
            if (i % 2 != 0) {
                ans = ans * product;
            }
            product = product * product;
        }
        return ans;
    }

    // perfect working solution
    public double helper_second(double x, long n) {
        if (n == 0 || x == 0) {
            return 1;
        }

        double half = helper_second(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        }
        return half * half * x;
    }

    // stack overflow
    public double helper(double x, long n) {
        if (n == 0 || x == 0) {
            return 1;
        }
        return x * helper(x, n - 1);
    }
}