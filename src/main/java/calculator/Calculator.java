package calculator;

import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

public class Calculator {
    private List<Integer> results; //연산결과를 저장하는 컬렉션 private으로 설정해 외부에서 직접 접근하지 못하도록.


    //생성자
    public Calculator() {
        results = new ArrayList<>(); //생성자를 통해 컬렉션 필드 초기화..
    }
//숫자 두개와 연산기호를 매개변수로 받아서 연산하는 매소드

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

//    //연산 결과를 추가하는 메서드
//    private void addResult(int result) {
//        results.add(result);
//    }

    //연산 결과 반환하는 메서드 > getter매서드(level2-3) >였는데 inquiryResults 메서드로 변견 level2-5
    public List<Integer> inquiryResults() {
        return new ArrayList<>(results); //외부에서 직접 수정 불가 >컬렉션의 복사본을 반환하니까
    }
    //결과 수정하는 setter 메서드..이게 맞나
    public void setResults(List<Integer> results) {
        this.results=results;
    }
    //가장 오래된(먼저 나온) 연산결과를 삭제하는 메서드
    public void removeFirstResult(){
        if(!results.isEmpty()) {
            results.remove(0); //가장 오래된 결과 삭제
        }
    }





}





