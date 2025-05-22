## 排序

### 冒泡排序
冒泡排序的核心思想是比较相邻的两个数，以升序为例，如果这个左边的数比右边的大，则进行交换。第一次循环之后，最大数就到最右边了。

```java
/**
 * 这个是关于冒泡排序的相关练习
 */
public class BubbleSort {
    /**
     * 冒泡排序对数据进行排序操作的函数
     *
     * @array 需要排序的数组
     */
    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                // 左右两个数进行比较，如果左边的比右边的大则进行交换。
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
```

那么是否还可以进行优化呢，也是可以的。
```java
for (int j = i + 1; j < array.length; j++) { }
```

在上面的这段代码里面我们可以看到，`j < array.length`可见后面有一些是不需要进行比较操作的，因为最大或最小的已经*冒泡*到了最右侧。所以这里可以的条件可以改成。

```java
for (int j = i + 1; j < array.length - i; j++) { }
```

冒泡排序的速度还是比较一般的。

### 选择排序

