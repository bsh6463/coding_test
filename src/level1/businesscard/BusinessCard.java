package level1.businesscard;

public class BusinessCard {

    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;

        for (int i=0; i< sizes.length; i++){
            int w = sizes[i][0];
            int h = sizes[i][1];
            if (w <= h){

                if (h > maxW){
                    maxW = h;
                }
                if(w > maxH){
                    maxH = w;
                }
            }else{
                if (w > maxW){
                    maxW = w;
                }
                if(h > maxH){
                    maxH = h;
                }

            }
        }
        return maxH*maxW;
    }

    public static void main(String[] args) {

        BusinessCard businessCard = new BusinessCard();

        int[][] sizes ={{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        int answer = businessCard.solution(sizes);

        System.out.println("=====answer=====");
        System.out.println(answer);
    }
}
