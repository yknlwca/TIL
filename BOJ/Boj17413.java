import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Boj17413 {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String inputString = bf.readLine();
		StringBuilder result = new StringBuilder();
		StringBuilder word = new StringBuilder();
		boolean inTag = false;
		
		for(int i = 0; i < inputString.length(); i++) {
			char c = inputString.charAt(i);
			
			
			if(c == '<') {
				inTag = true;						// 태그 시작
				result.append(word.reverse());		// 태그 전 거꾸로 저장
				word.setLength(0);					// 초기화
				result.append(c);					// < 태그 시작
			}else if (c == '>') {					
				inTag = false;						// > 태그 끝
				result.append(c);
			}else if (inTag) {						// > 만나기전 정상 저장
				result.append(c);
			}else {									// <> 가 아니면
				if(c == ' ') {						// 태그 밖의 띄어쓰기가 있을때
					result.append(word.reverse());	// 뒤집어서 입력
					word.setLength(0);				// word 초기화
					result.append(c);				// 띄어쓰기 입력
				}else {								// 일반 글자 word에 저장
					word.append(c);
				}
			}
		}
		result.append(word.reverse());				// 남아있는거 뒤집어서 저장
		System.out.println(result.toString());
	}
}
