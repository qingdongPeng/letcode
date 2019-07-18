package simple;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Simple2 {

    @Test
    public void testMajorityElement() {
        int[] arr = {3, 2, 3};
        System.out.println(majorityElement(arr));
    }


    /**
     * 求众数
     * 即在数组里出现次数超过一半的数
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        return map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();
    }

    // 投票法
    /*public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }*/


    @Test
    public void testTrailingZeroes() {
        /*System.out.println(trailingZeroes(5));
        System.out.println(trailingZeroes(11));*/
        System.out.println(trailingZeroes(65));
    }

    /**
     *
     * 给定一个整数 n，返回 n! 结果尾数中零的数量。
     *
     * 示例 1:
     * 输入: 3
     * 输出: 0
     * 解释: 3! = 6, 尾数中没有零。
     *
     * 示例 2:
     * 输入: 5
     * 输出: 1
     * 解释: 5! = 120, 尾数中有 1 个零.
     *
     * 思路: 求5的个数
     *
     */
    public int trailingZeroes(int n) {
        int num = 0;
        while (n > 0) {
            num += n/5;
            n /= 5;
        }
        return num;
    }

}
