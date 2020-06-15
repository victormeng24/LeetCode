package CountPrimes;

/**
 *
 */
public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(10));
    }

    /**
     * 统计所有小于非负整数 n 的质数的数量。
     * <p>
     * 示例:
     * <p>
     * 输入: 10
     * 输出: 4
     * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int[] markArr = new int[n];
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (isPrime(i)) {
                for (int j = i * i; j < n; j += i) {
                    markArr[j] = 1;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < markArr.length; i++) {
            if (markArr[i] == 0) {
                count++;
            }
        }
        return count;
    }

    public boolean isPrime(int x) {
        int sqrt = (int) Math.sqrt(x);
        for (int i = 2; i <= sqrt; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
