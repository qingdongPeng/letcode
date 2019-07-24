package simple;

import org.junit.jupiter.api.Test;

import java.util.*;

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

    /**
     * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * 示例 1:
     * 给定 nums = [3,2,2,3], val = 3,
     * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * 示例 2:
     * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
     * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
     * 注意这五个元素可为任意顺序。
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * 思路:双指针法
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    @Test
    public void testRemoveElement() {
        int []arr = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(arr, 2));
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 示例 1:
     * 输入: [2,2,1]
     * 输出: 1
     * 示例 2:
     * 输入: [4,1,2,1,2]
     * 输出: 4
     *
     * 思路1: 通过map, 未出现则put, 出现了则remove
     * 思路2: 通过异或操作, 0与任何数异或得到本身, 相同的数异或得到0
     *       即把数组里所有数与0异或, 最后得到的就是那个只出现一次的数
     */
    public int singleNumberByMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if(map.containsKey(num)) {
                map.remove(num);
            } else {
                map.put(num, 1);
            }
        }
        return map.keySet().stream().findFirst().get();
    }

    public int singleNumberByMath(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }

    @Test
    public void testSingleNumber() {
        int[] arr = {1, 1, 2, 3, 2};
        System.out.println(singleNumberByMath(arr));
        System.out.println(singleNumberByMap(arr));
    }

    /**
     * 给定两个二进制字符串，返回他们的和（用二进制表示）。
     * 输入为非空字符串且只包含数字 1 和 0。
     *
     * 示例 1:
     * 输入: a = "11", b = "1"
     * 输出: "100"
     *
     * 示例 2:
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     *
     * 借鉴他人思路
     */
    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        int i = a.length() -1;
        int j = b.length() -1;
        while(i >= 0 || j >= 0 || carry != 0){
            if(i >= 0) {
                carry += a.charAt(i--) - '0';
            }
            if(j >= 0) {
                carry += b.charAt(j--) - '0';
            }
            sb.append(carry%2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }

    @Test
    public void testAddBinary() {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }

}
