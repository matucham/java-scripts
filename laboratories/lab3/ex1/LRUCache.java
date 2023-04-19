package lab3.ex1;

import java.util.HashMap;

public class LRUCache<K, V>{
    class Node<T, U> {
        Node<T, U> previous;
        Node<T, U> next;
        T key;
        U value;

        public Node(Node<T, U> previous, Node<T, U> next, T key, U value){
            this.previous = previous;
            this.next = next;
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<K, Node<K, V>> cache;
    private Node<K, V> leastRecentlyUsed;
    private Node<K, V> mostRecentlyUsed;
    private int maxSize;
    private int currentSize;

    public LRUCache(int maxSize){
        this.maxSize = maxSize;
        this.currentSize = 0;
        leastRecentlyUsed = new Node<K, V>(null, null, null, null);
        mostRecentlyUsed = leastRecentlyUsed;
        cache = new HashMap<K, Node<K, V>>();
    }
    public V get(K key){
        Node<K, V> Node = cache.get(key);
        if (Node == null){
            throw new IllegalArgumentException();
        }
        else if (Node.key == mostRecentlyUsed.key){
            return mostRecentlyUsed.value;
        }

        Node<K, V> nextNode = Node.next;
        Node<K, V> previousNode = Node.previous;

        if (Node.key == leastRecentlyUsed.key){
            nextNode.previous = null;
            leastRecentlyUsed = nextNode;
        }

        else if (Node.key != mostRecentlyUsed.key){
            previousNode.next = nextNode;
            nextNode.previous = previousNode;
        }

        Node.previous = mostRecentlyUsed;
        mostRecentlyUsed.next = Node;
        mostRecentlyUsed = Node;
        mostRecentlyUsed.next = null;

        return Node.value;

    }

    public void put(K key, V value){
        if (cache.containsKey(key)){
            return;
        }

        Node<K, V> myNode = new Node<K, V>(mostRecentlyUsed, null, key, value);
        mostRecentlyUsed.next = myNode;
        cache.put(key, myNode);
        mostRecentlyUsed = myNode;

        if (currentSize == maxSize){
            cache.remove(leastRecentlyUsed.key);
            leastRecentlyUsed = leastRecentlyUsed.next;
            leastRecentlyUsed.previous = null;
        }

        else if (currentSize < maxSize){
            if (currentSize == 0){
                leastRecentlyUsed = myNode;
            }
            currentSize++;
        }
    }

}
