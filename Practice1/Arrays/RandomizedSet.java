package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSet {
    
    private HashMap<Integer, Integer>valueToIndexMap;
    private List<Integer>valueList;
    private Random random;

    public RandomizedSet() {
        valueToIndexMap = new HashMap<>();
        valueList = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(valueToIndexMap.containsKey(val)){
            return false;
        }

        valueToIndexMap.put(val, valueList.size());
        valueList.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!valueToIndexMap.containsKey(val)){
            return false;
        }

        int index = valueToIndexMap.get(val);
        int lastValue = valueList.get(valueList.size() - 1);

        valueList.set(index, lastValue);
        valueToIndexMap.put(lastValue, index);

        valueList.remove(valueList.size() - 1);
        valueToIndexMap.remove(val);

        return true;
    }
    
    public int getRandom() {
        return valueList.get(random.nextInt(valueList.size()));
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        
        System.out.println(randomizedSet.insert(1)); // true
        System.out.println(randomizedSet.remove(2)); // false
        System.out.println(randomizedSet.insert(2)); // true
        System.out.println(randomizedSet.getRandom()); // 1 or 2
        System.out.println(randomizedSet.remove(1)); // true
        System.out.println(randomizedSet.insert(2)); // false
        System.out.println(randomizedSet.getRandom()); // 2
    }

}
