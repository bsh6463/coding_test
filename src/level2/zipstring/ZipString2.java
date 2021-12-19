package level2.zipstring;

import java.util.ArrayList;

public class ZipString2 {
    public int solution(String s) {
        int answer = s.length();
        for (int i=1; i<=s.length()/2+1; i++){
            //1개식, 2개씩...차례대로 비교
            StringBuilder builder = new StringBuilder();

            //i자씩 끊어서 배열 만들기
            int Q = s.length()/i;
            ArrayList<String> arrayList = new ArrayList<>();
            for (int j=0; j<i*(Q); j+=i){
                arrayList.add(s.substring(j, j+i));
            }
            //i개씩 자르고 남은 놈들
            arrayList.add(s.substring(i*Q, s.length()));

            //잘라낸 문자열이 같은지 확인.
            ArrayList<String> results = new ArrayList<>();
            String temp = "";
            int cnt = 1;
            for (String value : arrayList) {
                if (value.equals(temp)) {
                    cnt++;
                } else {
                    if (cnt != 1) {
                        results.add(temp + String.valueOf(cnt));
                    } else {
                        results.add(temp);
                    }

                    temp = value;
                    cnt = 1;
                }
            }
            results.add(arrayList.get(Q));

            results.forEach(builder::append);
            String zipString = builder.toString();
            System.out.println(zipString);

            int zipCount = zipString.length();

            if (zipCount < answer){
                answer = zipCount;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "aabbaccc";
        ZipString2 zipString = new ZipString2();
        int solution = zipString.solution(s);
        System.out.println("===answer====");
        System.out.println(solution);
    }
}
