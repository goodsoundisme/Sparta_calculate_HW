package calculator;

import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // 연산 결과 저장을 위한 ArrayList 생성
        List<Integer> results = new ArrayList<>();
        Calculator calculator = new Calculator(); //Calculator 인스턴스 생성
        Scanner sc = new Scanner(System.in);

        while (true) { // 반복 루프 만들기

            System.out.println("첫번째 정수를 입력하세요."); // 첫번째 숫자 입력 받기
            int firstNumber = sc.nextInt();
            System.out.println("두번째 정수를 입력하세요."); // 두번째 숫자 입력 받기
            int secondNumber = sc.nextInt();
            System.out.println("연산을 입력하세요."); // 연산자 입력 받기
            char operator = sc.next().charAt(0);

            int result = 0; // 결과값 초기화
            boolean error = false; // 에러 발생 여부

            try{
                //Calculator 클래스로 연산수행
                result = calculator.calculate(firstNumber,secondNumber,operator);
            } catch (ArithmeticException | InvalidPropertiesFormatException e){
                System.out.println(e.getMessage());
                error = true;
            }

//            switch (operator) { // 연산자에 따른 연산 수행
//                case '+':
//                    result = firstNumber + secondNumber;
//                    break;
//                case '-':
//                    result = firstNumber - secondNumber;
//                    break;
//                case '*':
//                    result = firstNumber * secondNumber;
//                    break;
//                case '/':
//                    if (secondNumber == 0) {
//                        System.out.println("분모에는 0이 입력될 수 없습니다. 나눗셈 연산은 분자/분모 순서입니다.");
//                        error = true;
//                    } else {
//                        result = firstNumber / secondNumber;
//                    }
//                    break;
//                default:
//                    System.out.println("올바르지 않은 연산 기호입니다.");
//                    error = true;
//                    break;
//            }

            if (!error) { //결과가 에러가 아닐때 출력
                // 결과를 ArrayList에 저장
                results.add(result);
                System.out.println("결과: " + result);
            }


            sc.nextLine();

            // 가장 먼저 저장된 연산 결과 삭제
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하겠습니까? remove를 입력하세요. 아니면 no.");
            String command = sc.nextLine();
            if (command.equalsIgnoreCase("remove")) {
                if (!calculator.getResults().isEmpty()) {
                    calculator.getResults().remove(0); // 가장 오래된 결과 삭제
                    System.out.println("가장 먼저 저장된 결과가 삭제되었습니다.");
                } else {
                    System.out.println("삭제할 결과가 없습니다.");
                }
            }

            System.out.println("저장된 모든 연산 결과를 출력하려면 'inquiry'를 입력하세요.");
            System.out.println("더 계산하시겠습니까? exit 입력 시 종료");

            String exitInput = sc.nextLine();

            if (exitInput.equalsIgnoreCase("inquiry")) {
                // 저장된 모든 연산 결과를 출력
                System.out.println("모든 저장된 연산 결과:");
                for (int resultValue : calculator.getResults()) { // 향상된 for문 사용
                    System.out.println(resultValue);
                }
                continue; // 결과 출력 후 다시 루프 시작
            }

            // 반복 계속 여부 확인
            if (exitInput.equalsIgnoreCase("exit")) {
                break; // 프로그램 종료
            }
        }
    }
}
