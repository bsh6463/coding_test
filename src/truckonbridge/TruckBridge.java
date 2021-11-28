package truckonbridge;

import java.util.LinkedList;
import java.util.Queue;

public class TruckBridge {

    /**
     * @param bridge_length : 다리에 올라갈 수 있는 최대 차량 수, 건너는 시간
     * @param weight : 다리가 견딜 수 있는 하중
     * @param truck_weights : 각 트럭의 하중
     */
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        // 다리 : index 1 -> 0
        Queue<Truck> bridge = new LinkedList<>();
        Queue<Truck> truckQueue = new LinkedList<>();

        //대기열 생성
        for (int i=0; i < truck_weights.length; i++){
            truckQueue.add(new Truck(truck_weights[i], 0));
        }

        int time=1;
        Truck truck = truckQueue.peek();
        bridge.add(truck);
        truck.go();
        truck = truckQueue.remove();
        int totalWeight = truck.getWeight();

        System.out.println("=====다 리======");
        System.out.println("time : " + time);
        bridge.forEach(t -> System.out.println("truck : " +t.getWeight()));

        while (true){

            time++;

            truck = truckQueue.peek();

            //차량 이미 있는 경우 차량 이동.
            totalWeight = moveTruck(bridge_length, bridge, totalWeight);

            if (bridge.isEmpty() && truckQueue.isEmpty()){
                break;
            }

            //신규차량 진입 가능 조건.
            if(bridge.size() < bridge_length && truck != null && isLEWeight(totalWeight+ truck.getWeight(), weight)){
                truck = truckQueue.remove();
                truck.go();
                bridge.add(truck);
                totalWeight += truck.getWeight();
            }

            System.out.println("=====다 리======");
            System.out.println("time : " + time);
            bridge.forEach(t -> System.out.println("truck : " +t.getWeight()));

            if (bridge.isEmpty() && truckQueue.isEmpty()){
                break;
            }

        }


        return time;
    }

    private int moveTruck(int bridge_length, Queue<Truck> bridge, int totalWeight) {
        Truck frontTruck = bridge.peek();
        if (frontTruck.getPosition() == bridge_length){
            bridge.remove();
            totalWeight -= frontTruck.getWeight();
        }
        for (Truck ea : bridge) {
            ea.go();
        }
        return totalWeight;
    }


    private boolean isLEWeight(int truckWeight, int weight){
        return truckWeight <= weight;
    }

    private static class Truck{
        private int weight;
        private int position;

        public Truck(int weight, int position) {
            this.weight = weight;
            this.position = position;
        }

        public int getPosition() {
            return position;
        }

        public int getWeight() {
            return weight;
        }

        public int go(){
           return this.position++;
        }
    }



    public static void main(String[] args) {

        TruckBridge truckBridge = new TruckBridge();
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weight= {10};

        int time = truckBridge.solution(bridge_length, weight, truck_weight);

        System.out.println("********************");
        System.out.println("answer");
        System.out.println("time = " + time);
    }

}
