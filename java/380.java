/**
 * @description: O(1) 时间插入、删除和获取随机元素
 */
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
    
    // 删除先把要删除的元素和最后一个元素交换位置，然后删除最后一个元素，这样就可以O(1)时间删除
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
