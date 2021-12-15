package level1.printer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {

    public int solution(int[] priorities, int location) {

        Queue<Document> queue = new LinkedList<>();

        //초기 순서, 변경된 순서
        HashMap<Integer, Integer> container = new HashMap<>();

        //대기열 생성.
        for (int i=0; i<priorities.length; i++){
            Document document = new Document(priorities[i], i);
            queue.add(document);
        }

        int index=0;
        while (!queue.isEmpty()){
            Document doc = queue.remove();

            for (Document document : queue) {
                if (doc.getPriority() < document.getPriority()){
                    queue.add(doc);
                    doc = null;
                    break;
                }
            }

            if (doc != null){
                container.put(doc.getInitialLocation(), ++index);
            }

        }

        System.out.println("=================================");
        System.out.println("initial Location : changed Location");
        System.out.println(container);
        return container.get(location);
    }


    private static class Document {
        private int priority;
        private int initialLocation;

        public Document(int priority, int initialLocation) {
            this.priority = priority;
            this.initialLocation = initialLocation;
        }

        public int getInitialLocation() {
            return initialLocation;
        }

        public int getPriority() {
            return priority;
        }
    }

    public static void main(String[] args) {
        Printer printer = new Printer();
        int[] priorities1 = {2, 1, 3, 2};
        int location1 = 2;

        int answer1 = printer.solution(priorities1, location1);
        System.out.println("answer1 =  "+ answer1);

        int[] priorities2 = {1, 1, 9, 1, 1, 1};
        int location2 = 0;

        int answer2 = printer.solution(priorities2, location2);
        System.out.println("answer2 =  "+ answer2);
    }

}
