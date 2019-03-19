package whu.hydro.algorithm.sort;

import java.util.Stack;

/**
 * @ClassName mergeSort
 * @Description TODO
 * @Author 86187
 * @Date 2019/3/13 9:19
 * @Version 1.0
 */
public class mergeSort {

    static class PointNode{
        int[] a;
        int left;
        int right;

        public PointNode(int[] a, int left, int right) {
            this.a = a;
            this.left = left;
            this.right = right;
        }
    }

    static int[] tmpArray;

    static void merge(int[] a, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd){
            if (Integer.compare(a[leftPos], a[rightPos]) <= 0) {
                tmpArray[tmpPos++] = a[leftPos++];
            } else {
                tmpArray[tmpPos++] = a[rightPos++];
            }
        }

        while (leftPos <= leftEnd) {
            tmpArray[tmpPos++] = a[leftPos++];
        }

        while (rightPos <= rightEnd) {
            tmpArray[tmpPos++] = a[rightPos++];
        }

        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }
    }

    static void mergeSort(int[] a, int left, int right) {
        tmpArray = new int[right-left+1];
        PointNode root = new PointNode(a, left, right);
        int currentType = 0;
        Stack<PointNode> pointNodes = new Stack<>();
        Stack<Integer> type = new Stack<>();
        pointNodes.push(root);
        type.push(currentType);
        while (!pointNodes.isEmpty()) {
            int mid = (root.left+root.right)/2;
            if (currentType==2) {
                merge(a,  root.left, mid+1, root.right);
            }

            if(root.left < mid && currentType==0){
                pointNodes.push(root);
                type.push(currentType);
                currentType = 0;
                root = new PointNode(a, root.left, mid);
            } else if(mid+1 < root.right && currentType == 1) {
                pointNodes.push(root);
                type.push(currentType);
                currentType = 0;
                root = new PointNode(a, mid+1, root.right);
            } else {
                if (currentType < 2) {
                    currentType++;
                } else {
                    root = pointNodes.pop();
                    currentType = type.pop()+1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {3,2,4,1,6,8,9,-1,-3,-2,9,4,23,1,3,5};

        mergeSort(a, 0,a.length-1);

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }

    void mergeSort(int[] a, int[] temArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, temArray, left, center);
            mergeSort(a, temArray, center + 1, right);
            merge(a, temArray, left, center+1, right);
        }
    }

    public void mergeSort(int[] a) {
        int[] tmpArray = new int[a.length];
        mergeSort(a, tmpArray, 0, a.length - 1);
    }

    void merge(int[] a, int[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd){
            if (Integer.compare(a[leftPos], a[rightPos]) <= 0) {
                tmpArray[tmpPos++] = a[leftPos++];
            } else {
                tmpArray[tmpPos++] = a[rightPos++];
            }
        }

        while (leftPos <= leftEnd) {
            tmpArray[tmpPos++] = a[leftPos++];
        }

        while (rightPos <= rightEnd) {
            tmpArray[tmpPos++] = a[rightPos++];
        }

        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }
    }

}
