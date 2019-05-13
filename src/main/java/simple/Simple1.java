package simple;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;

public class Simple1 {
    @Test
    public void testA() {
        System.out.println(111);
    }

    /**
     * 给定一个 haystack 字符串和一个 needle 字符串，
     * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * 示例 1:
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * 说明:
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0
     */
    public int strStr(String haystack, String needle) {
        if (!haystack.contains(needle)) {
            return -1;
        } else {
            return haystack.indexOf(needle);
        }
    }


    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 你可以假设数组中无重复元素。
     * 示例 1:
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * 示例 2:
     * 输入: [1,3,5,6], 2
     * 输出: 1
     * 示例 3:
     * 输入: [1,3,5,6], 7
     * 输出: 4
     * 示例 4:
     * 输入: [1,3,5,6], 0
     * 输出: 0
     */
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    @Test
    public void testAA() {
        int[] a = {1, 3, 5, 6};
        System.out.println(searchInsert(a, 5));
        int[] b = {1, 3, 5, 6};
        System.out.println(searchInsert(b, 2));
        int[] c = {1, 3, 5, 6};
        System.out.println(searchInsert(c, 7));
        int[] d = {1, 3, 5, 6};
        System.out.println(searchInsert(d, 0));
    }


    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 示例:
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     */
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum = sum > 0 ? sum + nums[i] : nums[i];
            if (sum > result) {
                result = sum;
            }
        }
        return result;
    }

    @Test
    public void testMaxSubArray() {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }

    /**
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
     * 如果不存在最后一个单词，请返回 0 。
     * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
     * 示例:
     * 输入: "Hello World"
     * 输出: 5
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;
        String[] str = s.split(" ");
        if (str.length == 0)
            return 0;
        if (str.length == 1)
            return str[0].length();
        return str[str.length - 1].length();
    }

    @Test
    public void testLengthOfLastWord() {
        String s = "a ";
        System.out.println(lengthOfLastWord(s));
    }

    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * 示例 1:
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 示例 2:
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     */
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        while (index > 0) {
            if (digits[index] == 9) {
                digits[index] = 0;
                index--;
            } else {
                digits[index] += 1;
                break;
            }
        }
        if (index == -1 && digits[0] == 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        }
        return digits;
    }

    @Test
    public void testPlusOne() {
        int[] arr = {4, 3, 2, 1};
        System.out.println(Arrays.toString(plusOne(arr)));

        int[] arr2 = {8, 8, 9};
        System.out.println(Arrays.toString(plusOne(arr2)));

        int[] arr3 = {9,9,9};
        System.out.println(Arrays.toString(plusOne(arr3)));
    }

}

