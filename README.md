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


# 객체지향 프로그래밍 (OOP, Obeject Oriented Programming)

- 객체 : 사물과 같이 유형적인 것과 개념이나 논리와 같은 무형적인 것들 → 데이터, 알고리즘(로직)
- 지향 : 작정하거나 지정한 방향으로 나아감
- 객체 모델링 : 현실세계의 객체를 SW객체로 설계하는 것

## 클래스 (Class)

- 객체를 만드는 설계도 (Blueprint)
- 관련있는 변수와 함수를 묶어서 만든 사용자정의 <자료형>
- 클래스 == 객체를 생성하는 틀 (붕어빵틀)

```java
[접근제한자] [활용제한자] class 클래스명{
	//	속성 (필드)

	//	동작 (메소드)

	//	생성자

	//	중첩 클래스
}
// public 다른 패키지 접근 OK
// default 같은 패키지 안에서만
public class Person{

//	속성 (필드)

//	동작 (메소드)

//	생성자

//	중첩 클래스

}
```

## 인스턴스 (Instance)

- 클래스를 통해 생성된 객체

## 객체 지향 프로그래밍 특징 (A PIE)

- Abstraction (추상화) : 현실객체 → SW객체
- Polymorphism (다형성) : 하나의 객체를 다양한 형으로 참조 (관점)
- Inheritance (상속) : 기존 클래스 재활용 → 새로운 클래스
- Encapsulation (캡슐화) :
    1. 데이터 | 로직 하나의 캡슐처럼 묶임
    2. 객체의 속성 * 행위 (공개 or 공개 X)

모듈화된 프로그래밍

재사용성 ↑

디버깅이 용이

정보 보호

## 메서드 (=함수) Method

- 객체가 할 수 있는 행동을 정의
- 메소드의 이름은 소문자로 시작하는 것이 관례 → camelCase

```java
[접근제한자][활용제한자] 반환값 메소드이름 ([매개변수들]){
행위 기술...
}
public static void main (String[] args){
}
```

- 객체를 생성한 후 객체의 멤버 메서드를 호출한다.

```java
Person p = new Person();
p.info();

// static(객체 생성없이 사용)
Person.hello();
```

### 매개변수(Parameter)

- 필요없다면 생략가능
- 파라미터 전달 시 묵시적 형 변환

## 메서드 오버로딩 (Overloading)

- 이름이 같고 매개변수가 다른 메소드 여러 개 정의하는 것
- 파라미터 개수 또는 순서, 타입이 달라야 할 것 (파라미터 이름만 다른 것 X)
- 메서드 이름은 같지만, 받는 파라미터나 리턴하는 타입이 다르도록 여러 메서드를 정의하는 것

## 클래스 변수 (Class Variable)

- 설계도에 들어 있는 변수
- 클래스 영역 선언 (static 키워드)
- 생성시기 : 클래스가 메모리에 올라 갔을때
- 모든 인스턴스가 공유함

## 인스턴스 변수 (Instance Variable)

- 힙 영역 선언
- 생성시기 : 인스턴스가 생성되었을 때 (new)
- 인스턴스 별로 생성됨
- 실제로 만들어진 객체

## 지역 변수 (Local Variable)

- 클래스 영역 이외
- 생성시기 : 선언 되었을 때

## 생성자

- new 키워드와 함께 호출되어 객체 생성
- 클래스명과 동일
- 리턴값 X
- 객체가 생성될 때 반드시 하나의 생성자 호출
- 멤버필드의 초기화에 주로 사용
- 하나의 클래스 내부에 생성자가 하나도 없으면 자동적으로 default생성자가 있는 것으로 인지
- 생성자 오버로딩 가능
- 생성자의 첫번째 라인으로 this()생성자를 사용하여 또 다른 생성자를 하나 호출 가능
- 클래스(설계도) 정의를 바탕으로 인스턴스를 만들 때 처음으로(딱 한번만) 호출되는 메서드

### 기본(default) 생성자

- 클래스 내에 생성자가 하나도 정의되어 있지 않을 경우 JVM이 자동으로 제공하는 생성자
- 형태 : 매개변수가 없는 형태, 클래스명(){}
- 생성자를 하나라도 만들면 default생성자가 자동으로 생성되지 않음

## this

- 생성자 내에서만 호출 가능함
- 생성자 내에서 첫번째 구문에 위치해야함
- 자기 자신
- 자기 자신의 멤버 변수나 메서드에 접근할 수 있도록 하는 키워드
- this() : 자기 자신의 생성자를 호출 (생성자 안에서만 사용가능)

# 객체와 클래스

## 객체 지향 프로그래밍

- 프로그래밍 패러다임의 일종
- 기존의 패러다임은 프로그램을 단순히 순차적인 동작으로 이해
- 프로그램을 객체간의 상호작용으로 이해


## static

- static 메서드에서는 static 메서드나, static 멤버 변수만 접근 가능
- (non-static)
- static int function()
- public static void main




# 객체배열관리

JVM메모리 구조

- GC(Garbage Collection) 메모리 관리
- JVM에 의해서 알아서 실행
1. 메소드 영역 : 클래스와 관련된 정보를 저장하는 영역
2. 힙(heap) : 인스턴스가 생성되는 공간
3. 스택(stack) : LIFO(Last In First Out)

### static 특징

- 로딩 시점
    - static : 클래스 로딩시
    - non-static : 객체 생성시
- 메모리상의 차이
    - static : 클래스당 하나의 메모리 공간만 할당
    - non-static : 인스턴스당 메모리기 별도로 할당
- 문법적 특징
    - static : 클래스 이름으로 접근
    - non-static : 객체 생성 후 접근
- static 영역에서는 non-static 영역을 직접 접근이 불가능
- non-static영역에서는 static영역에 대한 접근 가능

### 접근제한자

패키지

- 클래스를 모아둔 **폴더** **
- 클래스와 인터페이스를 모아두기 위한 이름 공간
- 큰 범위 → 작은 범위로 이름 짓기

import

- 다른 패키지에 있는 클래스를 사용하기 위해서는 import
- * : 해당 패키지의 **모든 클래스**를 포함 할때 사용
    - 하위 패키지는 포함되지 않음

### 캡슐화(Encapsulation)

- 속성, 행위
- 객체의 속성과 행위를 하나로 묶고 실제 구현 내용 일부를 외부에 감춰 은닉

### 접근 제한자 (access modifier)

- 접근 허용 범위를 지정하는 역할으 ㅣ키워드
    - public : 모든 위치에서 접근 가능
    - protected : 같은 패키지에서 접근 가능, 다른 패키지 접근 불가능/ 단, 상속관계일 경우 접근 가능
    - (default) : 생략을 해야, 아무것도 쓰지 않아야 dafault
    - private : 자신 클래스(내부)에서만 접근 허용
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/acb4bbd9-5e7a-4411-b76d-2d71e461f3cd/6acea26b-1bae-4e24-ba43-4531e517b559/Untitled.png)
    

### 접근자 - 설정자 ( getter - setter )

### 싱글턴 패던(Singleton Pattern)

- 객체는 유일하게 하나만 생성되도록 한다

### 객체 배열 관리

- 정보 관리 시스템 ex) 학사 관리 시스템
- 캡슐화를 이용하여 클래스 작성
- 객체의 조회, 추가, 수정, 삭제(CRUD)를 구현
- 싱글턴 패턴을 사용하여 정보 관리 일원화

## 메서드 영역 (static)

- 클래스 로더가 클래스 파일을 읽어서 프로그램이 실행되는 단계에서 할당 하는 영역

## 힙 영역

- 프로그램이 실행되고 있는 중에 동적으로 할당되는 영역
- GC(가비지 컬렉터)

## 스택 영역

- 실행 흐름을 관리하는 영역
- LIFO (Last In First Out)

### 싱글턴 패턴 구현을 위한 3요소

- 생성자를 private으로 선언
- 자기 자신의 인스턴스를 담을 static 멤버 변수를 선언
- 다른 클래스에서 해당 객체에 접근할 수 있도록 getInstance() 메서드 정의 ( 반환형 : 싱글턴 클래스)



# 상속과 다향성

### 상속 (Inheritance)

- 설계도 재사용 ⇒ 새로운 설계도
- 어떤 클래스의 특성을 그대로 갖는 새로운 클래스를 정의한 것
- 특성 : 멤버 변수, 멤버 메서드
- 상위 클래스(super class) - 하위 클래스(sub class)
- **extends** + a
1. 확장성, 재 사용성
- 부모의 생성자와 초기화 블록은 상속 X
1. 클래스 선언 시 ***extends*** 키워드를 명시
- 자바는 다중 상속 허용 X, 단일 상속 지원
1. 자식 클래스는 부모 클래스의 멤버변수, 메소드를 자신의 것처럼 사용할 수 있다.
- 단, 접근 제한자에 따라 사용 여부가 달라진다.(private)
1. Object 클래스는 모든 클래스의 조상 클래스
- 별도의 extends 선언이 없는 클래스는  extends Object가 생략
1. ***Super*** 키워드
- ***super***를 통해 조상 클래스의 생성자 호출

```java
public Student(String name, int age, String major){
	super(name, age);
	this.major = major;
}
```

- 조상 클래스의 메서드 호출

```java
super.eat();
```

1. 오버라이딩 (재정의, Overriding)
- 상속 관계에 있을 때, 부모 클래스의 특정 메서드를 바꾸고 싶을 때
- **@** (어노테이션) ⇒ 컴파일러에게 알려주는 주석
- 상위 클래스에 선언된 메서드를 자식 클래스에서 재정의 하는 것
- 메서드 이름, 반환형, 매개변수 (타입, 순서, 개수) 동일 해야 한다.
- 하위 클래스의 접근 제어자 범위가 상위 클래스보다 크거나 같아야 한다. (private, (default), protected, public)
- 조상보다 더 큰 예외를 던질 수 없다.
- 메서드 오버로딩(overloading)과 혼동하지 말 것!!

## Object 클래스

- 가장 최상위 클래스로 모든 클래스의 조상
- Object의 멤버는 모든 클래스의 멤버


### toString 메서드

- 객체를 문자열로 변경하는 메서드

### equals 메서드

- 두 객체가 같은지 비교하는 메서드
- 두 개의 레퍼런스 변수가 같은 객체를 가리키고 있는가?
- equals 재정의

### hashCode

- 객체의 해시 코드 : 객체를 구별하기 위해 사용되는 정수값
- HashSet, HashMap 객체의 동일성을 확인하기 위해 사용
- equals 메서드를 재정의 할때 반드시 hashCode도 재정의

## final

- 해당 선언이 최종 상태, 결코 수정 될 수 없음
- final 클래스 : 상속 금지
- final 메소드 : overriding 금지
- final 변수 : 더 이상 값을 바꿀 수 없음 상수화

## 다형성 (Polymorphism)

- 상속관계에 있을 때 조상 클래스의 타입으로 자식 클래스 객체를 참조할 수 있다.
- 자손 타입 → 조상 타입 (묵시적 형 변환)
- 형 변환 생략 가능
- 조상 타입 → 자손 타입 (명시적 형 변환)
- 형 변환 생략 불가능

```java
Person p = new Person();
Student st = (Student) p;
Person p = new Student();
Student st = (Student)p;
```

- instanceof 연산자를 사용해 확인 후 사용


# 추상 클래스(abstract class), 인터페이스, 제너릭

- 설계도 중에는 객체 생성 꼭 필요하지 않는 것이 있다.
- 메서드의 선언부만 남기고 구현부는 ;(세미콜론)으로 대체
- 구현부가 없으므로 abstract 키워드를 메서드 선언부에 추가
- 클래스 선언부에도 abstract를 추가

```java
public abstract class Chef{
		public abstract void cook();
}
```

- abstract 클래스는 상속 전용의 클래스
- 객체 생성 불가
- 자식을 참조할 수 있음 ⇒ 다형성 활용 가능

### 추상 클래스 사용하는 이유

- abstract 클래스는 구현의 강제를 통해 프로그램의 안정성 향상

## 인터페이스

- 서로 다른 장치들을 연결시켜 주는 규격
- 완변히 추상화된 설계도
- 클래스와 유사하게 작성이 가능 (class 대신 interface 키워드 사용)
- 모든 메서드가 추상 메서드

```java
public interface 인터페이스 이름{
	public static final 타입 상수이름1 = 10;
	(생략가능) 타입 상수이름 상수이름2 = 10;
	public abstract 반환형 메서드이름1(타입 매개변수....);
	(생략가능) 반환형 메서드이름2(타입 매개변수....);
}
```

### 인터페이스 구현

- 인터페이스 그 자체로 인스턴스 생성 불가 - 구현부X
- 메서드를 구현할 클래스가 필요
- implements 키워드 사용해 구현 클래스 작성

클래스 → 클래스 (상속) *단일 상속*

클래스 → 인터페이스 (구현)  *다중 구현*

인터페이스 → 인터페이스 (상속) *다중 상속*

### 인터페이스 상속

- extends를 이용해 상속 가능
- 다중 상속 가능 (클래스의 다중 상속에서의 문제점 없음)

### default method

- 인터페이스 구현부가 있는 메서드를 작성할 수 있음
- 메서드 앞에 default 키워드 작성
- public 접근 제한자를 사용해 생략 가능

### static method

- 클래스의 static 메서드와 사용방법 동일함 (객체 생성 없음)
- 인터페이스 이름으로 메서드 접근

### 인터페이스의 필요성

- 표준화 처리 가능
- 개발 기간 단축 가능

### 클래스와 인터페이스 비교

- 클래스
    - class 키워드를 사용해 정의
    - 인터페이스를 구현함
    - 선언 가능
    - 하나의 클래스만 상속 가능 (단일 상속)
    - 인스턴스 생성 가능
- 인터페이스
    - interface 키워드 사용해 정의
    - 클래스에 의해 구현됨
    - 상수만 가능
    - 여러 개의 인터페이스 상속 가능 (다중 상속)
    - 인스턴스 생성 불가
    

    
    ## Generic
    
    제네릭
    
    - 다양한 종류의 객체를 다루는 메서드나 컬렉션 클래스에서 컴파일 시 타입을 체크 해주는 기능
    - 객체의 타입 안정성을 제공
    - 형변환의 번거로움이 없어져 코드가 간결해짐
    
    ### 제네릭 클래스
    
    - 클래스를 정의할 때
    - 클래스 안에서 사용되는 자료형(타입)을 구체적으로 명시하지 않고 매개변수를 이용하는 클래스
    
    ### 제네릭 클래스 선언
    
    - 클래스 또는 인터페이스 선언 시 <>에 타입 파라미터 표시
    
    ```java
    public class ClassName<T>{}
    public interface InterfaceName<T>{}
    ```
    
    - T : reference Type
    - E : Element
    - K : Key
    - V : Value
    
    ### 제네릭 클래스 객체 생성
    
    - 변수와 생성 쪽의 타입은 반드시 일치
    
    ### 제한된 제네릭 클래스
    
    - 타입 문자로 사용할 타입을 명시하였지만 모든 타입을 사용할 수 있는 문제 발생
    - 구체적인 타입의 제한이 필요할 때 extends 키워드를 사용할 수 있음
    - 클래스가 아닌 인터페이스로 제한할 경우도 extends 키워드 사용
    - 클래스와 함께 인터페이스 제약 조건을 이용할 경우 &로 연결
    
    ### 와일드 카드 이용
    
    - generic type에서 구체적인 타입 대신 사용
    
    ```java
    Generic type<?> // 타입 제한 없음
    Generic type<? extends T> // T와 T를 상속받은 타입들만 가능
    Generic type<? super T> // T의 조상
    ```
