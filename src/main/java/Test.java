import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

    public static void main(String[] args) {
//        is("A man, a plan, a canal: Panama");
//        is(",a's");
//        is("OP");
//        test(new int[]  {10,5,2,6},100);
        findTheDistanceValue(new int[]{4,5,8},new int[]{10,9,1,8},2);
        System.out.println(getKth(12,15,2));
    }
    public static int getKth(int lo, int hi, int k) {
        List<int[]> list = new ArrayList<>();
        for (int i = lo; i < hi + 1 ; i++) {
            list.add(getWeight(i));
        }
        Collections.sort(list,(e1,e2) -> e1[0] == e2[0] ? Integer.compare(e1[1],e2[1]) : Integer.compare(e1[0],e2[0]));
        return list.get(k - 1)[1];
    }
    private static int[] getWeight(int n) {
        int c = 0;
        int n1 = n;
        while (n > 1) {
            if(n % 2 == 1) {
                n = 3 * n + 1;
            } else {
                n /= 2;
            }
            c++;
        }
        return new int[] {c,n1};
    }

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        b:
        for(int i = 0;i < arr1.length;i++) {
            for(int j = 0; j < arr2.length;j++) {
                if(Math.abs(arr1[i]- arr2[j]) <= d) {
                    break b;
                }
            }
            count++;
        }
        return count;
    }
    public static int test(int[] numbers, int k) {
        int[] res = new int[1];
        if(numbers.length < 2) {
            return 0;
        }
        int l = 0,r = 0;
        while (l < numbers.length) {
            r = l;
            while (r < numbers.length) {
                int pro = 1;
                if (l != r) {
                    for (int i = l; i < r + 1; i++) {
                        pro *= numbers[i];
                    }
                } else {
                    pro = numbers[l];
                }
                if (pro < k) {
                    res[0]++;
                }
                if(pro > k && numbers[r] != 1) {
                    break;
                }
                r++;
            }
            l++;
        }
        return res[0];
    }
    static boolean is(String s) {
        if(s == null || s == "") {
            return true;
        }
        char[] chars = s.toCharArray();
        int l = 0,r = chars.length - 1;

        while (r > l) {
            if(!Character.isLetterOrDigit(chars[l])) {
               l++;
               continue;
            }
            if(!Character.isLetterOrDigit(chars[r])) {
                r--;
                continue;
            }
            if(Character.toLowerCase(chars[l]) != Character.toLowerCase(chars[r])) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    /**
     * 有序数组删除出现次数大于1元素
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if(nums == null) {
            return 0;
        }
        if(nums.length == 1) {
            return 1;
        }
        int pre = nums[0],last = nums.length;
        for(int i = 1;i < last;i++) {
            int j = --i;
            while(i < last - 1 && pre == nums[++i]);
            if(i - j > 1) {
                for(int k = i;k < last;k++) {
                    nums[k - (i - j)] = nums[k];
                }
                last -= (i - j);
                pre = nums[j];
                i = j;
            } else {
                pre = nums[j + 1];
            }
        }
        return last;
    }
}
