public class LCM {
    public static void main(String[] args) {
        LCM main = new LCM();
        int lcm = main.findlcm(48, 26); 
        System.out.println("LCM:" + lcm);
    }
    
    public int findlcm(int a, int b) {
        return a * b / GCD(a, b);
    }
    
    public int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }
}
