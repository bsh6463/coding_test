package level1.numbersandword;


import java.util.HashMap;

public class NumberAndWord {

    public int solution(String s) {
        HashMap<String, String> translator = init();

        for (String word : translator.keySet()) {
            if (s.contains(word)){
                s = s.replace(word, translator.get(word));
            }
        }

        return Integer.parseInt(s);
    }

    private HashMap<String, String> init() {
        HashMap<String, String> translator = new HashMap<>();
        translator.put("zero","0");
        translator.put("one","1") ;
        translator.put("two","2") ;
        translator.put("three","3");
        translator.put("four","4");
        translator.put("five","5");
        translator.put("six","6") ;
        translator.put("seven","7");
        translator.put("eight","8");
        translator.put("nine","9");
        return translator;
    }

    public static void main(String[] args) {

        String s1 = "one4seveneight";

       NumberAndWord numberAndWord = new NumberAndWord();

        int answer = numberAndWord.solution(s1);
        System.out.println("======answer========");
        System.out.println(answer);

    }

}
