

package org.example;

import java.util.ArrayList;
import static spark.Spark.*;

public class CollaztService {

    public static void main(String... args){
        port(getPort());
        staticFiles.location("/public");
        get("collazt", (request,response) -> {
            response.type("aplication/json");
            int value = Integer.parseInt(request.queryParams("value"));
            return CollaztSequence(value);
        });
    }
    
    public static String CollaztSequence(int value) {
        int valueOriginal = value;
        ArrayList<String> sequence = new ArrayList<>();
        sequence.add(String.valueOf(value));
        
        while (value > 0 && value != 1) {
            if (value % 2 == 0) {
                value = value / 2;
            } else {
                value = value * 3 + 1;
            }
            sequence.add(String.valueOf(value));
        }

        return printJSON(valueOriginal, sequence);
    }

    public static String printJSON(int valueOriginal, ArrayList<String> sequence) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"Operation\": \"collatzsequence\", ");
        json.append("\"Input\": ").append(valueOriginal).append(", ");
        json.append("\"Output\": \"");

        for (int i = 0; i < sequence.size(); i++) {
            json.append(sequence.get(i));
            if (i < sequence.size() - 1) {
                json.append(" => ");
            }
        }

        json.append("\"}");

        return json.toString();
    }

    
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }
}
