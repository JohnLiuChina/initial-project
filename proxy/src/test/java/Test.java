import com.alibaba.fastjson.JSONObject;
import com.amazonaws.services.dynamodbv2.xspec.S;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
public class Test {
    @org.junit.Test
    public void restTemplateTest() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(restTemplate
                .exchange(new RequestEntity<>(null, null, HttpMethod.GET, new URI("http://127.0.0.1:8088/proxy/receive")), String.class));
    }

    @org.junit.Test
    public void testLevel() {
        String dir = "2154/ada/3/56/7582";
//        dir = dir.substring(1, dir.length());
//        dir = dir.substring(0, dir.length() - 1);
        List<String> dirs = Arrays.asList(dir.split("/"));
        List<String> insertList = new ArrayList<>();
        for (int i = 0; i < dirs.size(); i++) {
            String tempDir = "";
            for (int j = 0; j <= i; j++) {
                tempDir = tempDir.concat(dirs.get(j)).concat("/");
            }
            insertList.add(tempDir.substring(0, tempDir.length() - 1));
        }
        System.out.println(JSONObject.toJSONString(insertList));
    }

    private int count(String str, char s2) {

        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == s2) {
                num++;
            }
        }
        return num;

    }

}
