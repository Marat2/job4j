package ru.job4j.map;


import java.util.Iterator;

public class CustomHash<K,V> {

    private final int DEFAULT_TABLE_SIZE = 128;

    private float threshold = 0.75f;

    private int maxSize = 96;

    private int size = 0;



    HashEntry[] table;



    CustomHash() {

        table = new HashEntry[DEFAULT_TABLE_SIZE];

        for (int i = 0; i < DEFAULT_TABLE_SIZE; i++)

            table[i] = null;

    }



    void setThreshold(float threshold) {

        this.threshold = threshold;

        maxSize = (int) (table.length * threshold);

    }



    public HashEntry get(K key) {

        int hash = Math.abs(key.hashCode() % table.length);
        HashEntry entry = new HashEntry("","");
        /*while ( (table[hash] != null && !table[hash].getKey().equals(key))) {
            hash = (hash + 1) % table.length;
        }*/
        for(int i=0;i<=table.length;i++){
            if(table[i]!=null && table[i].getKey().equals(key)){
                entry =  table[i];
                break;
            }
        }
        return entry;

    }



    public void put(K key, V value) {

        int hash = Math.abs(key.hashCode() % table.length);

        int initialHash = -1;

        //int indexOfDeletedEntry = -1;
        int indexOfDeletedEntry = hash;
        /*while (hash != initialHash && (*//*table[hash] == DeletedEntry.getUniqueDeletedEntry() ||*//* table[hash] != null && !table[hash].getKey().equals(key))) {

            if (initialHash == -1)

                initialHash = hash;

            *//*if (table[hash] == DeletedEntry.getUniqueDeletedEntry())

                indexOfDeletedEntry = hash;*//*

            hash = (hash + 1) % table.length;

        }*/

        if ((table[hash] == null/* || hash == initialHash*/)/* && indexOfDeletedEntry != -1*/) {

            table[indexOfDeletedEntry] = new HashEntry(key, value);

            size++;

        } else if (initialHash != hash)

            if (/*table[hash] != DeletedEntry.getUniqueDeletedEntry()

                    && */table[hash] != null && table[hash].getKey().equals(key) )

                table[hash].setValue(value);

            else {

                table[hash] = new HashEntry(key, value);

                size++;

            }

        if (size >= maxSize)

            resize();

    }



    private void resize() {

        int tableSize = 2 * table.length;

        maxSize = (int) (tableSize * threshold);

        HashEntry[] oldTable = table;

        table = new HashEntry[tableSize];

        size = 0;

        for (int i = 0; i < oldTable.length; i++)

            if (oldTable[i] != null

                    /*&& oldTable[i] != DeletedEntry.getUniqueDeletedEntry()*/)

                put((K)oldTable[i].getKey(), (V)oldTable[i].getValue());

    }



    public void remove(int key) {

        int hash = (key % table.length);

        int initialHash = -1;

        while (hash != initialHash

                && (/*table[hash] == DeletedEntry.getUniqueDeletedEntry()

                ||*/ table[hash] != null

                && !table[hash].getKey().equals(key))) {

            if (initialHash == -1)

                initialHash = hash;

            hash = (hash + 1) % table.length;

        }

        if (hash != initialHash && table[hash] != null) {

            table[hash] = null;/*DeletedEntry.getUniqueDeletedEntry();*/

            size--;

        }

    }
    public class HashEntry<K, V> {
        K key;
        V value;

        public HashEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return this.key;
        }

        public V getValue(){
            return this.value;
        }

        public void setValue(V value){
            this.value=value;
        }
        public void setKey(K key){
            this.key=key;
        }
    }
}
