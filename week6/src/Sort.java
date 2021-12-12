
public class Sort {
    public static void main(String args[]) {
        int a[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        random(a);
        bubbleSort(a);

        random(a);
        insertSort(a);

        random(a);
        quickSort(a, 0, a.length - 1);
        System.out.println("快速排序的结果为:");
        for (int k = 0; k < a.length; k++) {
            System.out.print(a[k] + " ");
        }
        System.out.println();

        random(a);
        sort(a, 0, a.length - 1);
        System.out.println("归并排序的结果为:");
        for (int k = 0; k < a.length; k++) {
            System.out.print(a[k] + " ");
        }
        System.out.println();

        random(a);
        heapSort(a);
        System.out.println("堆排序的结果为:");
        for (int k = 0; k < a.length; k++) {
            System.out.print(a[k] + " ");
        }

    }

    //冒泡排序
    public static void bubbleSort(int nums[]) {
        int temp;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        System.out.println("冒泡排序的结果为:");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    //插入排序
    public static void insertSort(int nums[]) {
        int i, j;
        int len = nums.length;
        int temp;
        for (i = 1; i < len; i++) {
            temp = nums[i];
            j = i - 1;
            while (j >= 0 && nums[j] > temp) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
        System.out.println("插入排序 de结果为:");
        for (int k = 0; k < nums.length; k++) {
            System.out.print(nums[k] + " ");
        }
        System.out.println();
    }

    //快速排序
    public static void quickSort(int nums[], int left, int right) {
        if(left>right){
            return;
        }
        int i = left, j = right;
        int temp = nums[left], m;
        while (i < j) {
            while (temp <= nums[j] && i < j) {
                j--;
            }
            while (temp >= nums[i] && i < j) {
                i++;
            }
            if (i < j) {
                m = nums[j];
                nums[j] = nums[i];
                nums[i] = m;
            }
        }
        nums[left] = nums[i];
        nums[i] = temp;
        quickSort(nums, left, j - 1);
        quickSort(nums, j + 1, right);
    }

    //归并排序
    public static int[] sort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            sort(a, low, mid);
            sort(a, mid + 1, high);
            mergeSort(a, low, mid, high);
        }
        return a;
    }

    public static void mergeSort(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= high) {
            temp[k++] = a[j++];
        }
        for (int m = 0; m < temp.length; m++) {
            a[m + low] = temp[m];
        }
    }

    //堆排序
    public static void heapSort(int[] nums) {
        //构建大顶堆
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }
        //调整堆结构后，交换堆顶元素与末尾元素
        for (int j = nums.length - 1; j > 0; j--) {
            swap(nums, 0, j);
            adjustHeap(nums, 0, j);
        }
    }

    //交换数据
    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void adjustHeap(int[] nums,int i,int length) {
        int temp = nums[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && nums[k]<nums[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(nums[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                nums[i] = nums[k];
                i = k;
            }else{
                break;
            }
        }
        nums[i] = temp;//将temp值放到最终的位置
    }

    //打乱顺序
    public static void random(int arr[]) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int currentRandom = (int) (Math.random() * (len - 1));
            int current = arr[i];
            arr[i] = arr[currentRandom];
            arr[currentRandom] = current;
        }
    }


}


