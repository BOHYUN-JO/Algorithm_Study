#include <stdio.h>
#define pi 3.14159265358979

int main(void) {
 int r; // ������
 scanf("%d", &r);
 printf("%.6lf\n%.6lf", r*r*pi, 2.0*r*r);
 return 0;
}

