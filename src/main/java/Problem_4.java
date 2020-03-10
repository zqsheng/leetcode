public class Problem_4 {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] {1,3},new int[] {2}));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int quotient = nums1.length + nums2.length >> 1;
        int remainder = (nums1.length + nums2.length) % 2;
        int i1 = 0,i2 = 0, i = 0,t1 = 0,t2 = 0;
        while (i < quotient + 1) {
            t2 = t1;
            if (i1 < nums1.length && i2 < nums2.length) {
                if (nums1[i1] < nums2[i2]) {
                    t1 = nums1[i1++];
                } else {
                    t1 = nums2[i2++];
                }
            } else if (i1 < nums1.length) {
                t1 = nums1[i1++];
            } else {
                t1 = nums2[i2++];
            }
            i++;
        }
        return remainder == 0 ? (t1 + t2) / 2.0 : t1;
    }
}
