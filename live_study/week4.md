# 목표 

자바가 제공하는 제어문을 학습하세요.

# 학습할 것 (필수)

## 선택문

자바는 순차적으로 위에서 아래로 차례대로 실행한다. 선택문은 `변수에 일치하는 경우의 값에 따라 실행되는 제어문이다.`

**Switch 문**

Case에 해당하는 값에 따라 코드의 실행을 제어하는 구문

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