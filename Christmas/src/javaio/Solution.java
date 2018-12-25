package javaio;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution{
    public int[] twoSum(int[] nums,int target){
        /**
         * 暴力办法
         * */
//        for(int i = 0;i < nums.length;i++){
//            for(int j = i+1;j < nums.length;j++){
//                if(nums[j] == target - nums[i]){
//                    return new int[] {i,j};
//                }
//            }
//        }

        /**
         * 一遍哈希表
         * */
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            int complement = target - nums[i];
            map.put(nums[i],i);
            if(map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {3,4,5,6,7,8};
        int target = 13;
        System.err.println(Arrays.toString(solution.twoSum(nums,target)));
    }
}
