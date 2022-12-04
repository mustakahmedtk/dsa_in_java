package com.collection.DSA_module;


import java.util.Arrays;


class HeapRunner{
    public static void main(String[] args){
        int[] arr = new int[20];
        Heaps hp = new Heaps(20);
        int[] inputArray = {7,3,12,2,6,4,5};
        //hp.maxHeapify(inputArray);
        int[] result = hp.heapsort(inputArray);
        for(int i = 0; i<result.length; i++){
             System.out.println(result[i]);
        }
    }
}




public class Heaps {
    int[] heapArray;
    int heapSize;
    Heaps(int size){
        this.heapArray = new int[size];
        this.heapSize = 1;

    }

     void perculateUp(int[] heaparray, int impurityIndex, String type){
        while(impurityIndex>1){
            int parent = heaparray[impurityIndex/2];
            if(type == "minHeap"){
                if(parent < heaparray[impurityIndex]){
                    break;
                }
            }else{
                if(parent > heaparray[impurityIndex]){
                    break;
                }
            }
            this.swap(heaparray, impurityIndex, impurityIndex/2);
            impurityIndex = impurityIndex/2;
        }
    }

    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


     void addElementToHeap(int[] heaparray, int lastIndex, int newElem){
        // introduce the impurity
        int newIndex = lastIndex+1;
        heaparray[newIndex] = newElem;
        // perculateUp to make it pure
        this.perculateUp(heaparray, newIndex,"minHeap");
    }

    void minHeapify(int[] inputarr){
        for(int i = 0; i<inputarr.length; i++){
            int newIndex = i+1;
            this.heapSize++;
            this.heapArray[newIndex] = inputarr[i];
            this.perculateUp(this.heapArray, newIndex, "minHeap");
        }
    }
    void maxHeapify(int[] inputarr){
        for(int i = 0; i<inputarr.length; i++){
            int newIndex = i+1;
            this.heapSize++;
            this.heapArray[newIndex] = inputarr[i];
            this.perculateUp(this.heapArray, newIndex, "maxHeap");
        }
    }

    int[] heapsort(int[] input){
        int[] heapArray = new int[input.length+1];
        heapArray[0] = -1;
        heapArray[heapArray.length-1] = input[input.length-1];
        for(int i =0; i<input.length-1; i++){
            heapArray[i+1] = input[i];

        }
        int lastFilledIndex = heapArray.length-1;
        heapArray = this.perculateDown(heapArray, lastFilledIndex);
        System.out.print(Arrays.toString(heapArray));
        while(lastFilledIndex>1){
            this.perculateDown(heapArray, lastFilledIndex);
            //  remove root
            this.swap(heapArray, 1, lastFilledIndex);
            lastFilledIndex--;
        }
        return heapArray;
    }
    int[] getHeap(){
        return this.heapArray;
    }
    int getSize(){
        return this.heapSize;
    }
    int findMaxIndex(int[] arr,int i,int j){
        if(arr[i]>arr[j]){
            return i;
        }
        return j;
    }
  // perculateDown
    int[] perculateDown(int[] arr, int lastFilledIndex){
        int index = 1;
        while(true){
            int leftChild = 2*index;
            int rightChild = 2*index+1;
            if(leftChild>lastFilledIndex){
                break;
                // reduced a leaf
            }
            if(rightChild>lastFilledIndex){
                // no right child available
                if(arr[index]>arr[leftChild]){
                    break;
                }
                this.swap(arr, index, leftChild);

            }else{
                int maxIndex = this.findMaxIndex(arr, leftChild ,rightChild);
                int maxValue = Math.max(arr[leftChild], arr[rightChild]);
                if(arr[index]>maxValue){
                    break;
                }
                this.swap(arr, index, maxIndex);
                index = maxIndex;
            }

        }
        return arr;
    }

}
