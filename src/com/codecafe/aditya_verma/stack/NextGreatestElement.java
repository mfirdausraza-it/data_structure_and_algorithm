package com.codecafe.aditya_verma.stack;

public class NextGreatestElement {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ni = nums1.length;
        int nj = nums2.length;
        int[] ans = new int[ni];
        for(int i = 0; i<ni; i++){
            int equal = -1;
            for(int j = 0; j<nj; j++){
                if(nums1[i] == nums2[j]){
                    equal = j;
                    break;
                }
            }
            if(equal == -1){
                ans[i] = -1;
            }else{
                for(int j = equal+1; j<nj; j++){
                    if(nums1[i] < nums2[j]){
                        ans[i] = nums2[j];
                        break;
                    }
                }
            }
            if(ans[i] == 0) ans[i] = -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums2 = {1,2,3,4};
        int[] nums1 = {2,4};
        System.out.println(nextGreaterElement(nums1,nums2));
    }
}
