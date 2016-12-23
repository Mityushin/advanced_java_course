package LFU;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 12/10/16.
 */
public class LFUCache<HT, TT> {
    private int capac;
    private HashMap<HT, Node<TT>> cache = new HashMap<>();

    public LFUCache(int capac) {
        this.capac = capac;
    }

    public LFUCache() {
        capac = 10;
    }

    private class Node<A> {
        A data;
        int freq;

        Node(A data, int freq) {
            this.data = data;
            this.freq = freq;
        }

        Node(A data) {
            this.data = data;
            freq = 0;
        }

        int getFrequency() {
            return freq;
        }

        A getData() {
            return data;
        }

        void increment() {freq++;}
    }

    private boolean full() {
        if (cache.size() == capac) {
            return true;
        }
        return false;
    }

    public TT getData(HT key) {
        if (cache.containsKey(key)) {
            cache.get(key).increment();
            return cache.get(key).getData();
        }
        return null;
    }

    public void addElement(HT key, TT data) {
        if(full()) {
            HT keyDelete = getLFUKey();
            cache.remove(keyDelete);
            cache.put(key, new Node<>(data));
        } else {
            Node<TT> nodeData = new Node<>(data);
            cache.put(key, nodeData);
        }
    }

    private HT getLFUKey() {
        int min = Integer.MAX_VALUE;
        HT key = null;

        for (Map.Entry<HT, Node<TT>> entry : cache.entrySet()) {
            if(min > entry.getValue().getFrequency()) {
                min = entry.getValue().getFrequency();
                key = entry.getKey();
            }
        }
        return key;
    }
}