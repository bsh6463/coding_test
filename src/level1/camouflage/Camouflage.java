package level1.camouflage;

import java.util.ArrayList;
import java.util.HashMap;

public class Camouflage {
    /**
     * [["yellowhat", "headgear"],
     * ["bluesunglasses", "eyewear"],
     * ["green_turban", "headgear"]]
     * ["asdfsdf","A"],["sdasdasd,"A"], ["asdasd","B"], ["qweqwe", "C"],["123123", "D"],["Asd5", "E"]]
     * ["A", {"asdfsdf", "sdasdasd"}],["B", {"asdasd"}], ["C", {"qweqwe"}],["D",{"123123"}],["E", {"Asd5"}]]
     */
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, ArrayList<String>> closet = new HashMap<>();

        ArrayList<String> clotheList;

        //배열을 싹 돌면서
        for (String[] clothe : clothes) {
            clotheList = new ArrayList<>();

            //현재 옷의 종류가 옷장에 있는 경우
            if (closet.containsKey(clothe[1])){

                //해당 옷의 종류에 옷 추가
                closet.get(clothe[1]).add(clothe[0]);
            }else {
                //현재 옷의 종류가 옷장에 없는 경우
                clotheList.add(clothe[0]);

                //옷장에 새로 넣음.
                closet.put(clothe[1],clotheList);
            }
        }

        System.out.println(closet);

        //["A", {"asdfsdf", "sdasdasd"}],["B", {"asdasd"}], ["C", {"qweqwe"}],["D",{"123123"}],["E", {"Asd5"}]]
        for (String category : closet.keySet()) {
               answer *= closet.get(category).size()+1;
        }

        //모두 선택 안하는 경우 제외;
        return --answer;
    }

    public static void main(String[] args) {
        Camouflage camouflage = new Camouflage();

        String[][] clothes1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int answer1 = camouflage.solution(clothes1);
        System.out.println("your answer : " + answer1);
        System.out.println("=============================");

        String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        int answer2 = camouflage.solution(clothes);
        System.out.println("your answer : " + answer2);
        System.out.println("=============================");
        }

}
