#include "stdio.h"

void swap(int *a, int *b){
    int tmp = *a;
    *a = *b;
    *b = tmp;
}

// will not swap variables since pass by value so the original variable unchanged
void broken_swap(int a, int b){
    int tmp = a;
    a = b;
    b = tmp;
}

void main(){
    int x = 10;
    int y = 20;
    printf("Before swap: x = %d, y = %d\n", x,y);
    swap(&x, &y);
    printf("After swap: x = %d, y = %d\n", x,y);

    printf("Before broken swap: x = %d, y = %d\n", x,y);
    broken_swap(x, y);
    printf("After broken swap: x = %d, y = %d\n", x,y);
}