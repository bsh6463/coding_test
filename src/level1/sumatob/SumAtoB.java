package level1.sumatob;

public class SumAtoB {

    public long solution(int a, int b) {
        if (a > b) {
            int  temp = b;
            b = a;
            a = temp;
        }
        return (a==b)? a : (long) b *(b+1)/2 - (long) (a - 1)*a/2;
    }
}
