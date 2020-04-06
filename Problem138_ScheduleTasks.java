//Time Complexity: O(n)

class Solution {
    public int leastInterval(char[] tasks, int n) {
        //base case
        if(tasks == null || tasks.length == 0)
            return 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int maxCount = 0;
        //1.Add tasks to map and get the values of maxCount and maxFreq
        //if tasks not in map
        //add key with value 0
        for(int i = 0; i < tasks.length; i++){
            if(!map.containsKey(tasks[i])){
                map.put(tasks[i],0);
            }
            //if task is in map;
            //update the count value and get maxFreq from tasks cnt
            int cnt = map.get(tasks[i]) + 1;
            map.put(tasks[i],cnt);
            maxFreq = Math.max(maxFreq, cnt);
            
        }
        //2.Calculate maxCount of no. of maxFreq
        for(int val : map.values()){
            if(val == maxFreq)
                maxCount++;
        }
        //3.Initialize partitions, emptySlots, RemainingTasks and idleSlots
        int partitions = maxFreq - 1;
        int empty = (n - (maxCount - 1)) * partitions;
        int remTasks = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(0, empty - remTasks);
        //at the ned return total lenth + idle
        return tasks.length + idle;
    }
}