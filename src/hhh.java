
import java.util.Arrays;
import java.util.List;

public class hhh {
    public static int test1(int d) {
        //有一个乱序的数组
        int[] arr = {0, 0, 2, 8};
        //对其进行从小到大排序
        Arrays.sort(arr);
        int length = arr.length;
        int result = 9999999;
        arr[length - 1] += d;
        if (length == 2) {
            return arr[length - 1] - arr[length - 2];
        }
        for (int i = length - 1; i > 1; i--) {
            int avg = (arr[i - 2] + arr[i]) / 2;
            int num = arr[i - 1];
            if (num + d < avg) {
                arr[i - 1] = num + d;
            }
            if (num < avg && num + d > avg) {
                arr[i - 1] = avg;
            }
            if (result > arr[i] - arr[i - 1]) {
                result = arr[i] - arr[i - 1];
            }
        }
        if (result > arr[1] - arr[0]) {
            result = arr[1] - arr[0];
        }
        return result;
    }

    public static int test2(List<Integer> nums) {
        //取第一个位置的数值,list长度
        int length = nums.size();
        int now = nums.get(0);
        int nowIndex = 0;
        int result = 0;
        for (int i = 1; i < length-1; i++) {
            if(nums.get(i) > now){//找到比当前位置大的数值
                //进行跳跃
                result = result + now*(i-nowIndex);
                now = nums.get(i);
                nowIndex = i;
            }
        }
        //最后一次跳跃，直接跳到最后一个位置
        result = result + now*(length-1-nowIndex);
        return result;
    }
}
