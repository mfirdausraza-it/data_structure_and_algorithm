package com.codecafe.dsa_pattern.two_pointer;

public class DutchNationFlag {
	
	
    public void sortColors(int[] nums) {
        int n = nums.length;
        if(n == 1) return;
        //intialize three pointer
        // zero = make sure for index of 0
        // two = make sure for index of 2
        // one = will float over the array
        int zero = 0, one = 0,two = n-1;
        // why not till n, because index two already
        // coming to down by arranging position of 2
        while(one<=two){
            int current = nums[one];
            if(current == 0){
                swap(nums,one,zero);
                zero++;
                //one should be increase because if we wont
                // increase it will stuck in loop
                one++;
            }
            //do nothing just increase the current index of one
            //because 1 should be in middle
            else if(current == 1) one++;
            else{
                swap(nums,one,two);
                //only decrease index not increase index of 1
                //suppose value at index two is 0 and value at index one is 2
                //after swap nums[one] = 0 or 2 and nums[two] = 2
                //if we increase index of one then current 
                //nums[one] = 0 or 2 will be not handle
                two--;
            }
        }
    }
    
    //helper method to swap two elements in the array
    static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args) {

	}
	
}
