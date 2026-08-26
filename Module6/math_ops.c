#include "stdio.h"

void print_math(int a, int b){
    int sum = a + b;
    int product = a * b;
    printf("Sum: %d\nProduct: %d\n", sum, product);
}

void main(){
    int a;
    int b;
    printf("Enter first number: ");
    scanf("%d", &a);
    printf("Enter second number: ");
    scanf("%d", &b);
    print_math(a, b);
}