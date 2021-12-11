package year2016;

public class Year {

    public String solution(int m, int d) {

        int days = 0;

        for (int i=1; i<m; i++){
            days += getDays(i);
        }
        days += d;

        return  getDay(days);
    }

    public int getDays(int m){
        switch (m){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12: return 31;
            case 2: return 29;
            case 4: case 6: case 9: case 11: return 30;
        }
        return 0;
    }

    public String getDay(int days){
        int delta = (days - 1) % 7;

        switch (delta){
            case 0: return "FRI";
            case 1: return "SAT";
            case 2: return "SUN";
            case 3: return "MON";
            case 4: return "TUE";
            case 5: return "WED";
            case 6: return "THU";
        }
        return "";
    }

    public static void main(String[] args) {

        int a = 5;
        int b = 24;

        Year year = new Year();
        String answer = year.solution(a, b);

        System.out.println("=====answer====");
        System.out.println(answer);

    }
}
