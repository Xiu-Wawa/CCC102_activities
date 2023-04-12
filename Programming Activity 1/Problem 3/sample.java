public class sample {
    public static void main(String[] args) {
        System.out.println(gcd(11,33));
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
