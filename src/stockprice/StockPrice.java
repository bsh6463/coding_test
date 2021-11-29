package stockprice;

import java.util.Arrays;


public class StockPrice {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

      //{1, 2, 3, 2, 3}
        for (int i=0; i<prices.length; i++){
            int price = prices[i];
            int count = 0;

            for (int j=i+1; j<prices.length; j++){
                if (prices[j] >= price){
                    count++;
                }else {
                    count++;
                    break;
                }
            }
            answer[i]= count;
        }

        return answer;
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();

        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = stockPrice.solution(prices);

        System.out.println("=============");
        Arrays.stream(answer).forEach(System.out::println);


    }

}
