package HashMAP;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        System.out.println(map.get(1));
        System.out.println(map.get(2));
    }
}
