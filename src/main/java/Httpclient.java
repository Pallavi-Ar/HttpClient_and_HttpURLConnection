import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.json.JSONObject;

import java.io.IOException;

public class Httpclient {

    public static void main(String[] args) {
        //calling method and printing result
        try {
            String result = sendPOST("https://reqres.in/api/users");
            System.out.println(result);
        }
        catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    //creating method to perform POST operation
    private static String sendPOST(String url) throws IOException, ParseException {
        //http client
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = " ";

        //creating json object and putting data
        JSONObject newObject = new JSONObject();
        newObject.put("name","Pallavi");
        newObject.put("job","trainee");

        //creating post request
        HttpPost post = new HttpPost(url);

        //converting json object to string
        post.setEntity(new StringEntity(newObject.toString()));
        CloseableHttpResponse response = httpClient.execute(post);
        result = EntityUtils.toString(response.getEntity());

        //returning string
        return result;
    }
}
