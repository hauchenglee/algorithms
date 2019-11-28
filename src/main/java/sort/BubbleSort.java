package sort;

import util.Constants;

import java.util.Arrays;

// https://www.zhihu.com/question/20063815

public class BubbleSort {
    public static void main(String[] args) {
        // small to big
        int[] ar = Constants.ar;
        int al = Constants.al;

        // 共4轮排序,每轮都是把最大的元素排在后面
        for (int i = 0; i < al; i++) {

            // 每轮排序中,需要比较的元素个数比上一轮少一个
            // 因为不需要跟自己比较，所以数量 - 1
            for (int j = 0; j < al - 1; j++) {

                // 中间变量,用于两个元素交换位置
                if (ar[j] > ar[j + 1]) {
                    int temp = ar[j + 1];
                    ar[j + 1] = ar[j];
                    ar[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(ar));

        // big to small
        int[] br = Constants.br;
        int bl = Constants.bl;
        for (int i = 0; i < bl; i++) {
            for (int j = 0; j < bl - 1; j++) {
                if (br[j] < br[j + 1]) {
                    int temp = br[j + 1];
                    br[j + 1] = br[j];
                    br[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(br));
    }
}
