package Sort;

import DATA.Item;
/************************************------------@copyright for @m_it_01-----------------***********************************/

public class Sort {
private static int  total;
    public Sort() {
    }


    //heap sort impiment
    public void sort(int arr[],Direction direction)
    {
        int n = arr.length;
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i,direction);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0,direction);
        }
    }
    void heapify(int arr[], int n, int i,Direction direction)
    {

            int largest = i;  // Initialize largest as root
            int l = 2 * i + 1;  // left = 2*i + 1
            int r = 2 * i + 2;  // right = 2*i + 2
        if(direction==Direction.LOW_HIGH) {
            // If left child is larger than root
            if (l < n && arr[l] > arr[largest])
                largest = l;

            // If right child is larger than largest so far
            if (r < n && arr[r] > arr[largest])
                largest = r;
        }
        else{
            // If left child is larger than root
            if (l < n && arr[l] < arr[largest])
                largest = l;

            // If right child is larger than largest so far
            if (r < n && arr[r] < arr[largest])
                largest = r;
        }
            // If largest is not root
            if (largest != i) {
                int swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = swap;

                // Recursively heapify the affected sub-tree
                heapify(arr, n, largest,direction);
            }

    }
    /************************************------------@copyright for @m_it_01-----------------***********************************/







/*
    //heap sort me

    public void Heap_Sort(int[] arr){
        total=arr.length-1;

        for(int i=total/2;i>=0;i--){
            heapify(arr,i);
        }
        for(int j=total;j>=0;j--){
            swap(arr,0,j);
            total--;
            heapify(arr,0);
        }
    }

    private void heapify(int[] arr, int ParntIndex){
  int LeftNodeIndex=ParntIndex*2;
  int RightNodeIndex=(ParntIndex*2)+1;

  int NewIndex=ParntIndex;

    if(LeftNodeIndex<total&&arr[LeftNodeIndex]>arr[ParntIndex]){
      NewIndex= LeftNodeIndex;
    }
    if(RightNodeIndex<total&&arr[RightNodeIndex]>arr[ParntIndex]){
        NewIndex= RightNodeIndex;
    }

    if(NewIndex!=ParntIndex){
        swap(arr,NewIndex,ParntIndex);
        heapify(arr,NewIndex);
    }
    }



    //end of heap sort
*/


    //quick sort me start
    public  void quickSort_me(int[] arr,int low,int high,Direction direction){
        if(low<high){
            int pi=sub_divid(arr,low,high,direction);
            quickSort_me(arr,low,pi-1,direction);
            quickSort_me(arr,pi+1,high,direction);
        }
    }
    private  int sub_divid(int[] arr, int low, int high,Direction direction) {
        int pove=arr[high];
        int i=low-1;
        if(direction==direction.LOW_HIGH){
                for (int j=low;j<high;j++){
                    if(arr[j]<pove){
                        i++;
                        swap( arr,j,i);
                    }
                }
        }
        else{
            for (int j=low;j<high;j++){
                if(arr[j]>pove){
                    i++;
                    swap( arr,j,i);
                }
            }
        }
        swap( arr, high,i+1);
        return i+1;
    }
    private  void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    // quick sort me ended



}

