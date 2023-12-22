
package HashMAP;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class HashMap<T, V> {

    // creating implimantation of hashmap
    // methods >put >get >remove >size >isEmpty >containsKey >containsValue >clear
    // >keySet >values >entrySet

    Queue<Node>[] buckets;
    // bucket size
    int m = 10;
    int n = 0;// no of nodes
    double a = 2.33;// load factor

    HashMap() {
        buckets = new LinkedList[m];
        for (int i = 0; i < m; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    class Node {
        V val;
        T key;

        Node(V val, T key) {
            this.val = val;
            this.key = key;
        }
    }

    int getHash(T key) {
        // getting hashcode of key
        return Math.abs(key.hashCode() % m);
    }

    public void put(T key, V val) {
        // putting key and value into hashmap
        Node node = searchKey(buckets, key);
        if (node != null) {
            node.val = val;
            return;
        }
        if (n >= a) {
            rehash();
        }
        buckets[getHash(key)].add(new Node(val, key));
        n++;
    }

    public V get(T key) {
        // getting value of key
        return searchKey(buckets, key).val;
    }

    Node searchKey(Queue<Node> buckets[], T key) {
        Queue<Node> list = buckets[getHash(key)];
        for (Node node : list) {
            if (node.key == key) {
                return node;
            }
        }
        return null;
    }

    public boolean remove(T key) {
        // removing key and value from hashmap
        Node node = searchKey(buckets, key);
        if (node != null) {

            n--;
            return buckets[getHash(key)].remove(node);
        }
        return false;
    }

    void rehash() {
        // rehashing hashmap
        Queue<Node>[] old = buckets;
        m = 2 * m;
        buckets = new LinkedList[m];
        for (int i = 0; i < m; i++) {
            buckets[i] = new LinkedList<>();
        }
        for (int i = 0; i < old.length; i++) {
            for (Node node : old[i]) {
                buckets[getHash(node.key)].add(node);
            }
        }
    }
}