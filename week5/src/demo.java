import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class demo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("<----------------第一题-------------->");
        System.out.println("请输入一个整数x：");
        int x = in.nextInt();
        int num = Judge(x);
        System.out.println("反转之后的整数x为：" + num);
        System.out.println("<----------------第二题-------------->");
        System.out.println("假设你正在爬楼梯，需要n阶你才能到达楼顶");
        System.out.println("请输入n：");
        int n = in.nextInt();
        ClimbStairs(0, n);
        System.out.println("有" + count + "种不同的方法可以爬到楼顶");
        System.out.println("<----------------第三题-------------->");
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = Subset(nums);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    //用于判断数字的范围以及是否为10的整数倍
    public static int Judge(int x) {
        if (x < -(Math.pow(2, 31)) || x > Math.pow(2, 31) - 1) {
            return 0;
        } else {
            if (x % 10 == 0) {
                return Reverse(x / 10);
            } else {
                return Reverse(x);
            }
        }
    }

    //用来反转数字
    public static int Reverse(int num) {
        int flag = 0; //记录num的正负
        //如果num为负，则取反然后将flag置1
        if (num < 0) {
            num = -num;
            flag = 1;
        }
        //利用字符串、字符数组之间的转换来变换数字
        String s = String.valueOf(num);
        char[] nums = s.toCharArray();
        char temp;
        for (int i = 0; i < nums.length / 2; i++) {
            temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
        s = String.valueOf(nums);
        int m = Integer.valueOf(s);
        //如果flag为1，说明num为负，则应该把符号位加回去
        if (flag == 1) {
            m = -m;
        }
        return m;
    }

    //用于记录爬楼梯的方案的数量
    static int count = 0;

    public static void ClimbStairs(int start, int end) {
        if (start == end) {
            count++;
        }
        if (start + 1 <= end) {
            ClimbStairs(start + 1, end);
        }
        if (start + 2 <= end) {
            ClimbStairs(start + 2, end);
        }
    }

    public static List<List<Integer>> Subset(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        int count = (int) Math.pow(2, len);//子集的个数
        for (int i = 0; i < count; i++) {
            String s = Integer.toBinaryString(i);
            List<Integer> temp = new ArrayList<>();
            for (int j = s.length() - 1; j >= 0; j--) {
                if (s.charAt(j) == '1') {
                    temp.add(nums[s.length()-1-j]);
                }
            }
            result.add(temp);
        }
        return result;
    }
}

















