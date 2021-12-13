package watermelon;

public class Watermelon {
    public String solution(int n) {
        String[] container = {"수", "박"};

        StringBuilder builder = new StringBuilder();

        for (int i=0; i<n; i++){
            if ((i%2) == 0){
                builder.append(container[0]);
            }else {
                builder.append(container[1]);
            }
        }
        return builder.toString();
    }
}
