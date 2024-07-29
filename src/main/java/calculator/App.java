package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("첫번째 정수를 입력하세요.");//첫번째 숫자 입력하도록
        int firstNumber = sc.nextInt(); //첫번째 정수 입력받기
        System.out.println("두번째 정수를 입력하세요."); //두번째 숫자 입력하도록
        int secondNumber = sc.nextInt(); //두번째 정수 입력받기
        System.out.println("연산을 입력하세요."); //연산자 받기
        char operator = sc.next().charAt(0);

        int result = 0; //결과값 0으로 초기화
        boolean error = false; //입력한 값이 정확(=연산이 성공적으로 이루어진)경우에만 출력하도록 하기 위해 설정. 오류 메시지를 위해서는 true로 값을 바꿔주면 된다!

        switch (operator) { //switch로 입력받은 연산에 따라 다르게 수행
            case '+': //operator가 +인 케이스
                result = firstNumber + secondNumber; //연산자 사용
                break; //break로 끝내주기
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                if (secondNumber == 0) {
                    System.out.println("분모에는 0이 입력 될 수 없어요. 나눗셈 연산은 분자/분모 순서입니다.");
                    error = true; //에러 변수를 트루로 변경
                } else {
                    result = firstNumber / secondNumber;
                }
                break;
            default:
                System.out.println("올바르지 않은 연산 기호입니다.");
                error = true;
                break;
        }
        if (!error) {
            System.out.println("결과 : "+result);




        }

    }

}
