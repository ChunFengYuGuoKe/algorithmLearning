package org.leetcode.double_pointer;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */

public class MoveZero_283 {
    public static void moveZeroes(int[] nums) {
        if(nums == null) return;
        // X 用对换双指针吧，不行，对换指针会打乱顺序

        // int left = 0;
        // int right = nums.length - 1;
        // while(left < right){
        //     if(nums[left] == 0 && nums[right] != 0){
        //         int temp = nums[left];
        //         nums[left] = nums[right];
        //         nums[right] = temp;
        //     }
        //     if(nums[left] != 0) left++;
        //     if(nums[right] == 0) right--;
        // }

        // 试试快慢指针
        // slow在什么时候应该移动，他需要找一个0值
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast++) {
            // if(nums[fast] == 0) slow = fast;
            // 不用想那么多，反正后面有符合要求的数字就拿到前面来就行，然后每多一个符合要求的数，slow往后移动一个位置就行
            // 上面这种根据fast到了一个0就把slow改过去的方式是不对的，因为交换之后会连续有几个零，这样前面的0就交换不到了
            /*这样写也是有问题的，当只有一个元素的时候，此时就会把那一个元素改成0，还是老老实实用交换
            if(nums[fast] != 0 && nums[slow] == 0) {
                nums[slow] = nums[fast];
                nums[fast] = 0;
                slow++;
            }*/
            if(nums[fast] != 0){
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for(int num : nums) {
            System.out.println(num);
        }
    }
}
