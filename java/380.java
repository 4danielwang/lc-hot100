class RandomizedSet {

    // value,index
    private Map<Integer,Integer> map;

    private List<Integer> list;

    private Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        int size = list.size();
        list.add(val);
        
        map.put(val,size);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int index = map.get(val);
        int last = list.get(list.size()-1);
        list.set(index, last);
        // 更新map
        map.put(last, index);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */