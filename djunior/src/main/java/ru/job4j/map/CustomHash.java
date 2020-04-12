package ru.job4j.map;

import java.util.Arrays;

public class CustomHash<K,V> {
    int defaultSize = 1 << 2;
    int size;
    V[] baseArray = (V[]) new Object[defaultSize];

    public int size() { return size; }

    public boolean isEmpty() { return size() == 0; }

    private int getBucketIndex(K key)
    {
        int hashCode = key.hashCode();
        int index = hashCode % defaultSize;
        return index;
    }


    public V get(K key)
    {
        // Find head of chain for given key
        int bucketIndex = Math.abs(getBucketIndex(key));
        if(baseArray[bucketIndex]!=null) {
            return baseArray[bucketIndex];
        }
        return null;
    }


    public void put(K key, V value)
    {
        // Find head of chain for given key
        int bucketIndex = Math.abs(getBucketIndex(key));
        baseArray[bucketIndex] = value;
        // Insert key in chain
        size++;
        // If load factor goes beyond threshold, then
        // double hash table size
        if ((1.0*size)/defaultSize >= 0.7)
        {
            int temp = defaultSize;

            defaultSize = 2 * defaultSize;
            size = 0;
            baseArray =Arrays.copyOf(baseArray, this.defaultSize);
        }
    }



    /*private int hash(K key) {
        int h;
        int hash= (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        return hash;
    }*/

    /*private V[] resize(){
        if(baseArray.length==0){
            baseArray = (V[]) new Object[defaultSize];
        }else if(baseArray.length>=defaultSize){
            this.defaultSize = baseArray.length<<1;
            baseArray =Arrays.copyOf(baseArray, this.defaultSize);
        }
        return baseArray;
    }*/

}
