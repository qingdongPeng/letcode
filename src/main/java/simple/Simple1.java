package simple;

import org.junit.jupiter.api.Test;

public class Simple1 {
    @Test
    public void testA() {
        System.out.println(111);
    }

    /**
     * 给定一个 haystack 字符串和一个 needle 字符串，
     * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * 示例 1:
     *     输入: haystack = "hello", needle = "ll"
     *     输出: 2
     * 示例 2:
     *     输入: haystack = "aaaaa", needle = "bba"
     *     输出: -1
     * 说明:
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0
     */
    public int strStr(String haystack, String needle) {
        if(!haystack.contains(needle)) {
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
            输入: [1,3,5,6], 5
            输出: 2
       示例 2:
            输入: [1,3,5,6], 2
            输出: 1
       示例 3:
            输入: [1,3,5,6], 7
            输出: 4
       示例 4:
            输入: [1,3,5,6], 0
            输出: 0
     */
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length;i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }

    @Test
    public void testAA() {
        int[] a = {1,3,5,6};
        System.out.println(searchInsert(a,5));
        int[] b = {1,3,5,6};
        System.out.println(searchInsert(b,2));
        int[] c = {1,3,5,6};
        System.out.println(searchInsert(c,7));
        int[] d = {1,3,5,6};
        System.out.println(searchInsert(d,0));
    }
}

