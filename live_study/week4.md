# 목표 

자바가 제공하는 제어문을 학습하세요.

# 학습할 것 (필수)

## 선택문

자바는 순차적으로 위에서 아래로 차례대로 실행한다. 선택문은 `변수에 일치하는 경우의 값에 따라 실행되는 제어문이다.`

**Switch 문**

Case에 해당하는 값에 따라 코드의 실행을 제어하는 구문 

**언제 사용하는가?** IF문을 계속 여러 번 추가하고 복잡해지는 부분을 해결하기 위해 처리할 경우의 수가 많을때 사용한다.

**제약 조건**

- switch :  조건식의 결과는 문자열 또는 정수여야 한다
- case : 정수 상수만 가능하며 다른 case와 중복될 수 없음

```java
// 1. 스위치문의 조건식을 계산 
switch(조건식) {
    // 2. 스위치문의 조건식과 일치하는 case 문으로 이동
    case (조건식 해당값 a):
        실행문장  // 3. 조건식 결과가 해당값 a일 경우 실행되는 문장을 구현
        break;    // 4. break 문을 통해 해당 switch 조건문을 빠져나옴
    case (조건식 해당값 b): // 3. 위의 case가 아닐때 실행
        실행문장;
        break;
    default:  // 3. 위의 다수의 case가 아닌 모든 경우에 실행
        실행문장
        
}
```

예제)

SwitchCase01.java
```java 
public class SwitchCase01 {
    public static void main(String[] args) {
        int var = 3;

        // 짝수 홀수 여부를 판단
        switch(var) {
            case 1:
                System.out.println("this is 1");
                break;
            case 2:
                System.out.println("this is 2");
                break;
            case 3:
                System.out.println("this is 3");
                break;
            case 4:
                System.out.println("this is 4");
                break;
            default:
                System.out.println("this is default");
                break;
        }

    }
}

```

- ref
https://palpit.tistory.com/607 <br>
https://pathas.tistory.com/110 <br>
https://lovefor-you.tistory.com/189 <br>

## 반복문

- ref
