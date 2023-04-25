import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.crypto.spec.PSource;
import javax.sound.midi.Soundbank;
import java.util.*;

public class Lab13 {
    public static void main(String[] args) throws ParseException {
        System.out.println("Challange 1: \n");

        //I
        Integer[] array = {30, 31, 34, 28, 49};
        JSONArray jsonArray = new JSONArray();
        for (Integer element : array) { jsonArray.add(element); }
        System.out.printf("I: %s%n", jsonArray);

        //II
        String[] str= {"One", "Two", "Three", "Four"};
        jsonArray = new JSONArray();
        for (String element : str) { jsonArray.add(element); }
        System.out.printf("%nII: %s%n", jsonArray);

        //III
        Object[] randArray= {31, "Hello World", new String[]{"One", "Two", "Three"}};
        jsonArray = new JSONArray();
        for (Object o:
             randArray) {
            if (o instanceof String[]){
                jsonArray.add(Arrays.toString((String[]) o));
                continue;
            }
            jsonArray.add(o);
        }
        System.out.printf("%nIII: %s%n", jsonArray);

        //IV
        Map<String,String> map=new TreeMap<String,String>();
        map.put("Name", "Name1");
        map.put("Address","213 Washington Blv");
        map.put("Zip","90532");
        JSONObject jSonObject = new JSONObject();
        jSonObject.putAll(map);
        System.out.printf("%nIV: %s%n", jSonObject);

        //V
        Map<String,Object> map2 =new TreeMap<String,Object>();
        Set<String> friends=new TreeSet<String>();
        friends.add("Friend 1");
        friends.add("Friend 2");

        map2.put("Name", "Name 1");
        map2.put("Address", "213 Washington Blv");
        map2.put("Zip", "90532");
        map2.put("Friends", friends);

        jSonObject = new JSONObject();
        jSonObject.putAll(map2);
        System.out.printf("%nV: %s%n", jSonObject);

        //Challenge 2
        System.out.println("\n\nChallenge 2: \n");

        //JSON 1
        String fruits = "[\"Apples\", \"Oranges\", \"Banana\"]";
        JSONParser parser = new JSONParser();
        jsonArray = (JSONArray) parser.parse(fruits);
        System.out.printf("JSON 1: %s%n", jsonArray);

        //JSON 2
        String carInfo = "{\"Make\":\"Toyota\", \"YearsOld\":3, \"Odometer\":12342, \"Price\":23122.00, \"Color\":\"Black\"}";
        parser = new JSONParser();
        jSonObject = (JSONObject) parser.parse(carInfo);
        System.out.printf("%nJSON 2: %s%n", jSonObject);

        //JSON 3
        String carInfo2 = "[" +

                          "{\"Make\": \"Toyota\"," +
                          "\"YearsOld\": 3," +
                          "\"Odometer\": 22342," +
                          "\"Price\": 13122.00," +
                          "\"Color\": \"White\"}," +

                          "{\"Make\": \"Honda\"," +
                          "\"YearsOld\": 5," +
                          "\"Odometer\": 13342," +
                          "\"Price\": 24122.00," +
                          "\"Color\": \"Black\"}" +

                          "]";
        parser = new JSONParser();
        jsonArray = (JSONArray) parser.parse(carInfo2);
        System.out.printf("%nJSON 3: %s%n", jsonArray);

        //JSON 4
        String studentInfo = "[" +

                              "{\"StudentId\": \"BC110023\"," +
                              "\"Name\": \"Joe Blogs\"," +
                              "\"Email\": \"joe@email.com\"," +
                              "\"Courses\": [\"CSC-123\",\"CSC123-Lab\"]}," +

                              "{\"StudentId\": \"BC110024\"," +
                              "\"Name\": \"Jane Doe\"," +
                              "\"Email\": \"jane@email.com\"," +
                              "\"Courses\": [\"CSC-123\",\"CSC123-Lab\"]}" +

                              "]";
        parser = new JSONParser();
        jsonArray = (JSONArray) parser.parse(studentInfo);
        System.out.printf("%nJSON 4: %s%n", jsonArray);




    }
}