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

### 기본 문법

프로그램 (Program)

- 컴퓨터에서 실행될 때 특정 작업(specific task)을 수행하는 일련의 명령어들의 모음

운영 체제 (Operating System, OS)

- 시스템 하드웨어를 관리할 뿐 아니라 응용 소프트웨어를 실행하기위해 하드웨어 추상화 플랫폼과 공통 시스템 서비스를 제공하는 시스템 소프트웨어

비트 (Bit, Binary digit)

- 2^2
- 컴퓨터가 값을 저장하는 최소 단위

바이트 (Byte)

- 8bits = 2^8 = 256가지값 값을 표현
- 컴퓨터 정보 처리의 최소 단위

2진수 (Binary)

- 2의 보수
    - 맨앞에 1 → 음수
    - 비트를 뒤집는다
    - +1

자바 가상 머신 (JVM, Java virtual machine)

- 자바 바이트 코드를 실행할 수 있는 주체
- 자바 바이트 코드는 플랫폼에 독립적이며 모든 JVM은 자바 가상 머신 규격에 정의된 대로 자바 바이트 코드를 실행
- 컴파일 : 프로그래밍
- Write Once Run Everywhere!
- Java는 플랫폼 독립적, JVM은 독립적 X

자바 개발 도구 (Java Development Kit)

- 컴파일러, 라이브러리

자바 실행 환경 (Java Runtime Enviorment)

자료형 (Data Type)

- 기본 : 값
- 참조 : 주소값 ex) String

형 변환 (Type Casting)

- 묵시적 (암묵적) : Implicit Casting
    - 범위가 좁은 곳 → 큰 곳
    - 그냥 해도 OK
- 명시적 : Explicit Casting
    - 범위가 큰 곳 → 좁은 곳
    - 형 변환 연산자 사용 = (타입) 값;
        - ex) int i = 100;
            
            byte b  = i; (X)
            
            byte b = (byte) i; (O)
            

단항 연산자

- 증감 연산자 ++, —
    - 전위형 (prefix) ++i
    - 후위형 (postfix) i—

비트 부정 연산자 ~

- 비트 값을 반전

논리 부정 연산자 !


### 1차원 배열

변수 이름

변수의 개수가 많아 짐 

코드의 길이 늘어남

반복문 사용 어려움

### 배열

- 같은 종류의 데이터를 저장하기 위한 자료구조
- 크기가 고정되어 있음 (한번 생성된 배열은 크기를 바꿀 수 없음)
- Java에서 배열은 객체로 취급 (참조형)

자료형[] 배열이름 = new 자료형[길이]

자료형[] 배열이름 = new 자료형[] {값1, 값2, 값3, 값4}

자료형[] 배열이름 = {값1, 값2, 값3, 값4}

### for-each문

### 배열의 복사

- 배열은 생성하면 길이를 변경할 수 없기 때문에 큰 배열을 생성하고 이전 배열의 값을 복사해야함

### 최댓값, 최솟값 찾기

배열을 순회하면서 최댓값 / 최솟값이 나올 때마다 업데이트를 해주는 방식

초기값은 충분히 큰 / 작은 값을 설정해야 함

### 빈도수 구하기

다른 자료형을 담을 수 있는 것은 무엇이 있을까?

### 2차원 배열

- 1차원 배열을 여러개 저장할 수 있는 자료구조
- 2차원 배열은 배열 요소로 1차원 배열의 참조를 가지는 배열
- N차원 배열은 배열 요소로 N-1차원 배열의 참조를 가지는 배열

### 선언

int[][] iArr ←권장

int iArr[][]

int[] iArr[]

### 생성

배열의 이름 = new 배열유형[1차원 배열개수][1차원 배열의 크기];

배열의 이름 = new 배열유형[1차원 배열개수][];

## 델타 배열
```java
// 상하 좌우
int[] dr = {-1, 1, 0, 0};
int[] dc = {0, 0, -1, 1};

// 상하좌우 , 좌상, 우상, 좌하, 우하
int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
```


