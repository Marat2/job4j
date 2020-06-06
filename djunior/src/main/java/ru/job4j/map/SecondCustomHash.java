package ru.job4j.map;

import java.util.*;

public class SecondCustomHash<K,V> {
    //private int threshold ;
    private int size = 0;
    private int modCount;
    static  int DEFAULT_INITIAL_CAPACITY =4;
    //static final float DEFAULT_LOAD_FACTOR = 0.75f;
    //final float loadFactor=DEFAULT_LOAD_FACTOR;
    private Node<K,V>[] table;
    public SecondCustomHash(){
        table = new Node[DEFAULT_INITIAL_CAPACITY];
    }
    static class Node<K,V>  {
        final int hash;
        final K key;
        V value;
        Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
        public V getValue(){
            return value;
        }
        public K getKey(){
            return key;
        }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final boolean equals(Object o) {
            if (o == this){
                return true;
            }
            Node<K, V> tmpNode = (Node<K, V>) o;
            if(tmpNode.key.equals(this.key) && tmpNode.value.equals(this.value)){
                return true;
            }
            return false;
        }
    }
    static int hash(int h)
    {
        h ^= (h >>> 20) ^ (h >>> 12);
        return Math.abs(h ^ (h >>> 7) ^ (h >>> 4));
    }
    static int indexFor(int h, int length)
    {
        return h & (length - 1);
    }
    boolean addEntry(int hash, K key, V value, int index)
    {
        if(table[index]==null){
            size++;
            ++modCount;
            //Node<K, V> e = table[index];
            table[index] = new Node<K, V>(hash, key, value);
            return true;
        }
        return false;
    }
    public boolean put(K key,V value){//проверка на Null
        //проверка а могу ли я вообще добавить и не превышен ли размер
        if (size==DEFAULT_INITIAL_CAPACITY-1){
            resize(DEFAULT_INITIAL_CAPACITY);
        }
        int hash = hash(key.hashCode());
        int index = indexFor(hash,DEFAULT_INITIAL_CAPACITY/*size+1*/);
        return addEntry(hash,key,value,index);
    }
    void resize(int capacity)
    {
        int oldCapasity = capacity;
        DEFAULT_INITIAL_CAPACITY = oldCapasity*2;
        Node[] newTable = new Node[DEFAULT_INITIAL_CAPACITY];
        transfer(newTable,oldCapasity);
        table = newTable;
        //threshold = (int)(DEFAULT_INITIAL_CAPACITY * loadFactor);
    }
    public void transfer(Node[] newTable,int oldCapasity){
        Node<K,V> oldTable[] = table;
        for (int i=0;i<oldCapasity;i++){
            if(table[i]!=null){
                //int h = hash((int)table[i].getKey().hashCode());
                int index = indexFor(table[i].hash,DEFAULT_INITIAL_CAPACITY/*size*/);
                newTable[index] = new Node<K,V>(table[i].hash,table[i].getKey(),table[i].getValue());
            }
        }
        table = newTable;
    }
    public boolean remove(Object key) {
        Node<K,V> e;
        return removeNode(hash(key.hashCode()), key);
    }
    final  boolean removeNode(int hash, Object key) {
        Node<K,V>[] tab; Node<K,V> p; int n;
        if ((tab = table) != null && (n = tab.length) > 0 && (p = tab[(n - 1) & hash]) != null) {
            Node<K,V> node = null, e; K k; V v;
            if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k))))
                node = p;
            if (node != null) {
                ++modCount;
                --size;
                node=null;
                return true;
            }
        }
        return false;
    }
    public Iterator<V> iterator() {
        return new IteratorOfDynamic();
    }
    private class IteratorOfDynamic implements Iterator<V> {
        int cursor = 0;
        int expectedModCount = modCount;

        IteratorOfDynamic() {

        }

        private void checkForComodification(int expectedModCount) {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public V next() {
            checkForComodification(expectedModCount);
            int i = cursor;
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            cursor = i + 1;
            if (table[i]!=null){
                return (V) table[i].getValue();
            }
            return null;
        }
    }
}
