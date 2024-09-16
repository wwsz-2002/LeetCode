import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *哈希表实现
 */
public  class  hash {
    /**
     * 两数之和问题
     */
    public int[] addOfTowNumbertest(int[] num,int target){
        //获取传入数组的长度
        int len = num.length;
        //定义一个哈希表
        HashMap<Integer,Integer> hash = new HashMap<>();
        //从头开始遍历原数组
        for(int i = 0;i < len;i++){
            //获取当前元素与目标的插值
            int temp = target - num[i];
            //判断是否在哈希表中
            if(hash.containsKey(temp)){
                return new int[]{hash.get(temp),i};
            }
            //否则就放入哈希表
            else{
                hash.put(num[i],i);
            }
        }
        return new int[]{-1,-1};
    }

    /**
     * 字母异位词分组
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        //若数组为空则返回一个空列表
        if (strs.length == 0){return new ArrayList<>();}
        //获取数组中的单词
        HashMap<String,List<String>> hash = new HashMap<>();
        for(String str : strs){
            //将单词转换为字符数组
            char[] chars = str.toCharArray();
            //对字符数组进行排序
            Arrays.sort(chars);
            //将排序后的字符数组转换为字符串
            String key = String.valueOf(chars);
            //判断是否在哈希表中
            if(!hash.containsKey(key)){
                hash.put(key,new ArrayList<>());
            }
            //将单词放入哈希表
            hash.get(key).add(str);
        }
        return new ArrayList<>(hash.values());
    }

    /**
     * 最长连续序列问题
     */
    public static int longestConsecutive(int[] nums) {
        //创建哈希表
        HashMap<Integer,Integer> hash = new HashMap<>();
        int len = nums.length;
        //遍历数组,并将数字放入哈希表中
        for(int i = 0;i < len;i++){
            hash.put(nums[i],i);
        }
        int max = 0;
        for(int i = 0;i < len;i++){
            //判断当前数字是否为连续序列的第一个数字
            if(hash.containsKey(nums[i] - 1)){
                //不是第一个数字
                continue;
            }
            //是第一个数字
            int begin = nums[i];
            int num = 1;
            while(hash.containsKey(begin + 1)){
                begin++;
                num++;
            }
            if (num > max){
                max = num;
            }
        }
        return max;
    }
}
