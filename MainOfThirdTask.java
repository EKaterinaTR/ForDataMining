import java.io.*;
import java.util.*;

public class MainOfThirdTask {
    public static void main(String[] args) throws IOException {
        Map<String, Map<String,Integer>> consumers = new HashMap<>();
        Set<String> products = new HashSet<>();
        Set<String> uniqueConsumer = new HashSet<>();
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(new File("Date/GroupProduct with big Ability.csv")));
        BufferedReader bufferedReader1 = new BufferedReader(
                new FileReader(new File("Date/transactions.csv")));
        String s = bufferedReader.readLine();
        s = bufferedReader.readLine();
        while (s != null){
            String [] strings = s.split(";");
            products.add(strings[0]);
            //System.out.println(strings[0]);
            s = bufferedReader.readLine();
        }
        bufferedReader.close();
        s = bufferedReader1.readLine();
        s = bufferedReader1.readLine();
        while (s != null){
            String [] strings = s.split(";");
            if(products.contains(strings [0])){
                if(consumers.containsKey(strings[0])){
                    if (consumers.get(strings[0]).containsKey(strings[1])) {
                        consumers.get(strings[0]).put(strings[1],consumers.get(strings[0]).get(strings[1]) + 1);
                    }
                    else {
                        consumers.get(strings[0]).put(strings[1],1);
                    }
                }
                else {
                    Map <String,Integer> map = new HashMap<>();
                    map.put(strings[1],1);
                    consumers.put(strings[0],map);
                }
            }
            s = bufferedReader1.readLine();
            uniqueConsumer.add(strings[1]);
        }
        bufferedReader1.close();
        String s3 ="";
        for(String s1 : products) {
            Set <String> consumer = consumers.get(s1).keySet();
            int numberOfConsumerWas1time = 0;
            int numberOtherConsumer = 0;
            int all = 0;
            for (String s2: consumer) {
                if(consumers.get(s1).get(s2) == 1) {
                    numberOfConsumerWas1time++;
                }
                else {numberOtherConsumer++;}
                all += consumers.get(s1).get(s2);
                //System.out.println(s1 + " " + s2 + " " + all);
            }
            System.out.println("PROD_CODE;PERCENT_UNIQUE_BUYING;NUMBER_UNIQUE_CONSUMER;NUMBER_NOT_UNIQUE_CONSUMER");
            System.out.println(s1 + ";"+ (numberOfConsumerWas1time * 100/all) +";"+ numberOfConsumerWas1time +";"+ numberOtherConsumer);
             s3 = s1;
        }
        Set<String> consumer = new HashSet<>();
        Set <String> consumerOf0 = consumers.get(s3).keySet();
        for(String s1 : consumerOf0){
            consumer.add(s1);
        }

        for (String s1: products) {
            Set<String> newConsumer = new HashSet<>();
            for(String s2: consumer) {
                if(consumers.get(s1).keySet().contains(s2)) {
                    newConsumer.add(s2);
                }
            }
            consumer = newConsumer;
        }

        for(String s2: consumer) {
            System.out.println(s2);
        }

        System.out.println(uniqueConsumer.size());





    }
}
