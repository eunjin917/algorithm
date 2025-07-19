// 정올 #556 배열1 - 자가진단2
public class Main {

    final static int MAX = 10;

    public static void main(String[] args) {

        int[] nums = new int[MAX];
        for (int i=0; i<MAX; i++) {
            nums[i] = i+1;
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
}
