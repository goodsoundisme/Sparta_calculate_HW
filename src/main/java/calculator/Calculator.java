package calculator;

import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

public class Calculator {
    private List<Integer> results;

    public Calculator() {
        results = new ArrayList<>();
    }
//양의 정수 두개와 연산기호를 매개변수로 받아서 연산하는 매소드

    public int calculate(int num1, int num2, char operator) throws InvalidPropertiesFormatException {
        int result;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("분모에는 0이 들어올 수 없어요.");
                }
                result = num1 / num2;
                break;
            default:
                throw new InvalidPropertiesFormatException("올바르지 않은 연산기호입니다.");
        }

        //연산 결과를 컬렉션에 저장
        results.add(result);
        return result;
    }

    //연산 결과 반환하는 메서드
    public List<Integer> getResults() {
        return results;
    }
}





