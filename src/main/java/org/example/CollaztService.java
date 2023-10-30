

package org.example;

import java.util.ArrayList;
import static spark.Spark.*;

public class CollaztService {

    public static void main(String... args){
        port(getPort());
        staticFiles.location("/public");
        get("collazt", (request,response) -> {
            response.type("text/json");
            int number = Integer.parseInt(request.queryParams("number"));
            return CollaztSecuence(number);
        });
    }
  
    public static String CollaztSecuence(int num){
        ArrayList<String> secuence = new ArrayList<>();
        secuence.add(String.valueOf(num));

        while(num > 0 &&  num != 1){
            if(num % 2 == 0){
                num = num / 2;
            }
            else {
                num = num * 3 + 1;
            }
            secuence.add(String.valueOf(num));
        }
        String result = secuence.get(0) + " ";
        for(int i = 1; i < secuence.size(); i++){
            result +=  " ==> " + secuence.get(i);
        }
        return result;
    }
    
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
