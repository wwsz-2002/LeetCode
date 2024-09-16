import java.util.ArrayList;
import java.util.HashMap;

/**
 * 滑动窗口问题
 */
public class slidingWindow {
    /**
     * 无重复字符的最长子串
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        //提取字符串到字符数组中
        char[] chars = s.toCharArray();
        int n = chars.length;//长度
        int nowLen = 0;
        int maxLen = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();//存储字符和字符出现的位置
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(chars[i])) {//当前不在map中
                map.put(chars[i], i);//将当前的字符和下标放入hash中
                nowLen++;//滑动窗口长度加一
                maxLen = Math.max(nowLen, maxLen);//更新最大长度
            }
            else {//在map中
                nowLen=i-map.get(chars[i]);//滑动窗口长度更新为当前下标和之前相同字符的下标之间的距离
                for (int j = left; j < map.get(chars[i]); j++){
                    map.remove(chars[j]);
                }
                left =map.get(chars[i])+1;//更新滑动窗口的左边界
                map.put(chars[i], i);//将当前的字符和下标放入hash中
            }
        }
        return maxLen;
    }
}
