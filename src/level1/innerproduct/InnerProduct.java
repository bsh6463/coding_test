package level1.innerproduct;

public class InnerProduct {

    public int solution(int[] a, int[] b) {
        int sum=0;

        for (int i=0; i<a.length; i++){
            sum+= a[i]*b[i];
        }
        return sum;
    }

}
