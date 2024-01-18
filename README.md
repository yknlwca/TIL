# Markdown
> 보다 간단한 문법으로 구조적인 문서를 작성하기 위한 마크업 언어
> Git README에 많이 작성된다.
## header
- 문단의 제목을 `#`을 사용하여 작성할 수 있습니다.
- `-`를 사용해 리스트를 작성할 수 있습니다.


텍스트를 *기울이고* 싶다면 `*`을 텍스트의 양쪽에 씌우면 됩니다.

텍스트를 **강조하고** 싶다면 `**`을 텍스트의 양쪽에 씌우면 됩니다.

|기수|반|강사|반장|CA|
|---|---|---|---|---|
|1기|1반|Mike|John|Lisa|

### 코드 스내핑
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class ChatGPT {

    private static String API_KEY = "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";
    private static String GPT_URL = "https://api.openai.com/v1/chat/completions";

    public static void main(String[] args) throws IOException {
        URL url = new URL(GPT_URL);    
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
        connection.setDoInput(true);
        connection.setDoOutput(true);

        JSONObject data = new JSONObject();
        data.put("model", "gpt-3.5-turbo");
        data.put("temperature", 0.7);

        JSONObject message = new JSONObject();
        message.put("role", "user");
        message.put("content", "안녕? Chat GPT에 대해 자세하게 소개해줘.");

        JSONArray messages = new JSONArray();
        messages.put(message);

        data.put("messages", messages);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
        bw.write(data.toString());
        bw.flush();
        bw.close();

        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line = null;

        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        System.out.println(sb.toString());
    }
}
```








# Today I Learned

### 참고 사이트
https://paperswithcode.com/
* 연구 논문과 코드를 함께 제공하는 온라인 플랫폼,
* 머신 러닝과 딥러닝 분야에서 발표된 논문과 해당 논문에 대한 구현된 코드를 함께 제공
* 허깅페이스 https://huggingface.co/
* https://blog.naver.com/seonspace/222928891719


# 처음 겪는 오류
> round함수의 사사오입(Round half to Even)
>> * round(2.5)는 2입니다. (가장 낮은 자리 숫자가 5이므로 짝수로 반올림)
>> * round(3.5)는 4입니다. (가장 낮은 자리 숫자가 5이므로 짝수로 반올림)
>> * round(1.5)는 2입니다. (가장 낮은 자리 숫자가 5이므로 짝수로 반올림)
>> * round(2.75, 1)은 2.8입니다. (소수점 한 자리까지 반올림)


### 비전수립 / 디자인Thinking
