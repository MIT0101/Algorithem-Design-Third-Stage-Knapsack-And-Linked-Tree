package Sort;

import DATA.Item;

public class Sort_Items {


    public Sort_Items() {
    }

    /************************************------------@copyright for @m_it_01-----------------***********************************/

    //heap sort for itemes provit to wieght
    public void sort_provit_to_w(Item arr[], Direction direction) {
        int n = arr.length;
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify_provit_to_w(arr, n, i, direction);

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            Item temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify_provit_to_w(arr, i, 0, direction);
        }
    }

    void heapify_provit_to_w(Item arr[], int n, int i, Direction direction) {

        int largest = i;  // Initialize largest as root
        int l = 2 * i + 1;  // left = 2*i + 1
        int r = 2 * i + 2;  // right = 2*i + 2
        if (direction == Direction.LOW_HIGH) {
            // If left child is larger than root
            if (l < n && arr[l].provit_to_weigh > arr[largest].provit_to_weigh)
                largest = l;

            // If right child is larger than largest so far
            if (r < n && arr[r].provit_to_weigh > arr[largest].provit_to_weigh)
                largest = r;
        } else {
            // If left child is larger than root
            if (l < n && arr[l].provit_to_weigh < arr[largest].provit_to_weigh)
                largest = l;

            // If right child is larger than largest so far
            if (r < n && arr[r].provit_to_weigh < arr[largest].provit_to_weigh)
                largest = r;
        }
        // If largest is not root
        if (largest != i) {
            Item swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify_provit_to_w(arr, n, largest, direction);
        }
    }
    //end of sort items provit to with

    //heap sort for itemes provit
    public void sort_provit(Item arr[], Direction direction) {
        int n = arr.length;
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify_provit(arr, n, i, direction);

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            Item temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify_provit(arr, i, 0, direction);
        }
    }
    /************************************------------@copyright for @m_it_01-----------------***********************************/

    void heapify_provit(Item arr[], int n, int i, Direction direction) {

        int largest = i;  // Initialize largest as root
        int l = 2 * i + 1;  // left = 2*i + 1
        int r = 2 * i + 2;  // right = 2*i + 2
        if (direction == Direction.LOW_HIGH) {
            // If left child is larger than root
            if (l < n && arr[l].provit > arr[largest].provit)
                largest = l;

            // If right child is larger than largest so far
            if (r < n && arr[r].provit > arr[largest].provit)
                largest = r;
        } else {
            // If left child is larger than root
            if (l < n && arr[l].provit < arr[largest].provit)
                largest = l;

            // If right child is larger than largest so far
            if (r < n && arr[r].provit < arr[largest].provit)
                largest = r;
        }
        // If largest is not root
        if (largest != i) {
            Item swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify_provit(arr, n, largest, direction);
        }
    }
    //end of sort items provit

    /************************************------------@copyright for @m_it_01-----------------***********************************/

    //heap sort for itemes weight
    public void sort_weight(Item arr[], Direction direction) {
        int n = arr.length;
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify_weight(arr, n, i, direction);

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            Item temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify_weight(arr, i, 0, direction);
        }
    }

    void heapify_weight(Item arr[], int n, int i, Direction direction) {

        int largest = i;  // Initialize largest as root
        int l = 2 * i + 1;  // left = 2*i + 1
        int r = 2 * i + 2;  // right = 2*i + 2
        if (direction == Direction.LOW_HIGH) {
            // If left child is larger than root
            if (l < n && arr[l].weight > arr[largest].weight)
                largest = l;

            // If right child is larger than largest so far
            if (r < n && arr[r].weight > arr[largest].weight)
                largest = r;
        } else {
            // If left child is larger than root
            if (l < n && arr[l].weight < arr[largest].weight)
                largest = l;

            // If right child is larger than largest so far
            if (r < n && arr[r].weight < arr[largest].weight)
                largest = r;
        }
        // If largest is not root
        if (largest != i) {
            Item swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify_weight(arr, n, largest, direction);
        }
    }
}
/************************************------------@copyright for @m_it_01-----------------***********************************/

