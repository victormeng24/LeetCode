package LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *  
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 *  
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2 /* 缓存容量 */
public class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int nums;

    class Node {
        public Node(int key, int val) {
            this.key = key;
            this.value = val;
        }

        int key;
        int value;
        Node pre;
        Node next;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
        this.nums = 0;
    }

    public void DeleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(Node node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            DeleteNode(node);
            addToHead(node);
            return node.value;
        } else return -1;
    }

    public void put(int key, int value) {
        if (map.get(key) == null) {
            Node node = new Node(key, value);
            map.put(key, node);
            if (nums < capacity) {
                nums++;
                addToHead(node);
            } else {
                map.remove(tail.pre.key);
                DeleteNode(tail.pre);
                addToHead(node);
            }
        } else {
            Node node = map.get(key);
            node.value = value;
            DeleteNode(node);
            addToHead(node);
        }
    }
}
