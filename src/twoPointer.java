import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 双指针问题
 */
public class twoPointer {
    /**
     * 移动零问题
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if (len < 2) return;
        int slow = 0;

        for (int fast = 0; fast < len; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        while (slow < len) {
            nums[slow++] = 0;
        }
    }

    /**
     * 盛最多水的容器
     */
    public static int maxArea(int[] height) {
        int len = height.length;
        int right = len - 1;//右指针
        int left = 0;//左指针
        int max = 0;//最大容量
        int cur = 0;//当前容量
        if (len < 2) {
            return 0;
        }
        while (left < right) {
            cur = (right - left) * Math.min(height[left], height[right]);
            if (cur > max) {
                max = cur;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    /**
     * 三数之和
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;//数组长度小于3，直接返回空列表
        Arrays.sort(nums);//排序
        int len = nums.length;
        int score = 0;
        int left = 0;//左指针
        int right = 0;//右指针
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) break;//如果当前数字大于0，则后面数字和当前数字之和一定小于0，直接返回
            if (i > 0 && nums[i] == nums[i - 1]) continue;//如果当前数字与前一个数字相等，则跳过，避免重复计算
            score = -nums[i];
            left = i + 1;
            right = len - 1;
            //双指针求和法
            while (left < right) {
                if (nums[left] + nums[right] == score) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;//跳过重复数字
                    while (left < right && nums[right] == nums[right - 1]) right--;//跳过重复数字
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < score) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

}

