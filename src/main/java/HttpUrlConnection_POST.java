import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpUrlConnection_POST {
    public static void main(String[] args) {
        //POST AND AUTHENTICATION
        //USING gorest.co.in as authentication is not possible on reqres.in
        try{
            //creating json object for data
            JSONObject json = new JSONObject();
            json.put("name", "Pallavi");
            json.put("email", "pa1010@gmail.com");
            json.put("gender", "female");
            json.put("status", "active");

            //opening connection
            URL url = new URL("https://gorest.co.in/public/v2/users");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Authorization", "Bearer fe365320b7de52611463d52036fc09860aa5f701dbb2bdc2c425d7ba35d33201");
            conn.setDoOutput(true);
            conn.getOutputStream().write(json.toString().getBytes());
            System.out.println(conn.getResponseCode());

            try(BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))){
                String response;
                while((response=br.readLine())!=null){
                    System.out.println(response);
                }
            }
            conn.disconnect();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
