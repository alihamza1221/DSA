import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Hoffman {
    static{
        System.out.println("prgramme executed!!");
    }
    Map<Character, String> encode;
    Map<String, Character> decode;

    class Node implements Comparable<Node> {
        char c;
        int freq;
        Node left;
        Node right;

        Node(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }

        @Override
        public int compareTo(Node other) {
            return this.freq - other.freq;
        }
    }

    public Hoffman(String feeder) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : feeder.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            pq.offer(node);
        }
        //remove the first two min elements and than add to left right of a node and put them back until pq.size() != 1

        while (pq.size() != 1){
            Node left = pq.poll();
            Node right = pq.poll();

            Node node = new Node('\0',left.freq + right.freq);
            node.left = left;
            node.right = right;
            pq.offer(node);
        }
        Node finalTree = pq.poll();
        //create encode and decode maps
        encode = new HashMap<>();
        decode = new HashMap<>();
        initEncodeDecode(finalTree,"");
    }
    private void initEncodeDecode(Node node , String key){
        if(node == null) return;
        if(node.left == null && node.right == null){
            encode.put(node.c,key);
            decode.put(key,node.c);
        }
        initEncodeDecode(node.left, key +'0');
        initEncodeDecode(node.right , key +'1');
    }

    public String encode(String sourse){
        String ans = "";
        for(char ch : sourse.toCharArray()){
            ans += this.encode.get(ch);
        }
        return ans;
    }

    public String decode(String EncodedString){
        String ans = "";
        String key = "";
        for(char keyToken : EncodedString.toCharArray()){
            key += keyToken;
            if(decode.containsKey(key)){
                ans += decode.get(key);
                key = "";
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        // Add your code here
        String str = "abbccda";
        Hoffman hf = new Hoffman(str);
        String cs = hf.encode(str);
        System.out.println(cs);
        String dc = hf.decode(cs);
        System.out.println(dc);
    }

}