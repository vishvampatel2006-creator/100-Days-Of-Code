// Day 22 | BTCE202 (DSA) & BTCS104 (C) | Array Insertion, Deletion & Linear Search
// Complexity: Traversal O(n), Insertion O(n), Deletion O(n), Linear Search O(n)

#include <stdio.h>

void display(int arr[], int n) {
    printf("Array elements: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int insertElement(int arr[], int n, int capacity, int element, int pos) {
    if (n >= capacity || pos < 0 || pos > n) {
        printf("Insertion not possible!\n");
        return n;
    }
    for (int i = n - 1; i >= pos; i--) {
        arr[i + 1] = arr[i];
    }
    arr[pos] = element;
    return n + 1;
}

int deleteElement(int arr[], int n, int pos) {
    if (n <= 0 || pos < 0 || pos >= n) {
        printf("Deletion not possible!\n");
        return n;
    }
    for (int i = pos; i < n - 1; i++) {
        arr[i] = arr[i + 1];
    }
    return n - 1;
}

int linearSearch(int arr[], int n, int key) {
    for (int i = 0; i < n; i++) {
        if (arr[i] == key) {
            return i;
        }
    }
    return -1;
}

int main() {
    int arr[20] = {10, 20, 30, 40, 50};
    int n = 5;
    int capacity = 20;

    display(arr, n);

    n = insertElement(arr, n, capacity, 25, 2);
    printf("After inserting 25 at index 2:\n");
    display(arr, n);

    n = deleteElement(arr, n, 3);
    printf("After deleting element at index 3:\n");
    display(arr, n);

    int target = 40;
    int idx = linearSearch(arr, n, target);
    if (idx != -1) {
        printf("Element %d found at index %d\n", target, idx);
    } else {
        printf("Element %d not found\n", target);
    }

    return 0;
}