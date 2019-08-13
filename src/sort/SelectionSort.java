package sort;

import util.Constants;
import java.util.Arrays;

// 运行时间和输入无关：为了找出最小的元素而扫描一遍数组并不能为下一遍扫描提供什么信息
// 数据移动是最少的：n次交换，交换次数和数组大小是线性关系

public class SelectionSort {
    public static void main(String[] args) {
        // small to big
        int[] ar = Constants.ar;
        int al = Constants.al;

        /*
        在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
        再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
        以此类推，直到所有元素均排序完毕。
         */

        // GeeksforGeeks
        // 共4轮排序，做同样的事情
        for (int i = 0; i < al - 1; i++) {
            int min_dex = i;

            // 此for只是找出最小index
            // 从i开始是因为i前面的数字都是已排序好的
            // i + 1因为自己不用比对（应该说自己就是index了）
            // 范围到al是因为搜寻直到最后一个数字
            for (int j = i + 1; j < al; j++) {
                if (ar[j] < ar[min_dex]) {
                    min_dex = j;
                }
            }
            /*
              此方法是找出最小數的index
              再利用bubble sort原理排序
             */
            /*
            抓出
             */
            int temp = ar[min_dex];
            ar[min_dex] = ar[i];
            ar[i] = temp;
        }
        System.out.println(Arrays.toString(ar));

        // my test
    }
}
