
## 목표

자바가 제공하는 다양한 연산자를 학습하세요.

## 학습할 것

- 산술 연산자
- 비트 연산자
- 관계 연산자
- 논리 연산자
- instanceof
- assignment(=) operator
- 화살표(->) 연산자
- 3항 연산자
- 연산자 우선 순위
- (optional) Java 13. switch 연산자


### 연산자란?

어떠한 기능 또는 어떤 대상체에 계산과 같은 처리를 수행하는 문자 또는 기호라고 볼 수 있다. 

- 연산자(operator) : 어떠한 기능을 수행하는 기호 (ex, +, - , *, / 등)
- 피연산자(operand) : 연산자의 작업 대상 (ex 변수, 상수, 수식 등)

### 산술 연산자

산술 연산자는 수학적인 계산에 사용되는 연산자이다. `사칙연산`이라고 생각하면 된다.

|연산자|기능|
|------|--------------------|
|+|두 피연산자의 값을 더함|
|-|왼쪽의 피연산자 값에서 오른쪽의 피연산자 값을 뺌|
|*|두 피연산자의 값을 곱함|
|/|왼쪽의 피연산자 값을 오른쪽의 피연산자 값으로 나눔|
|%|왼쪽 피연산자에서 오른쪽 피연산자로 나누었을때 나머지 (ex 11%4 = 나머지 3)|


```java
public static void main(String[] args) {
    int a = 3;
    int b = 4;
    
    System.out.println(a+b);
    System.out.println(a-b);
    System.out.println(a/b);
    System.out.println(a*b);
    System.out.println(a%b);
}
```

output
```
7
-1
0
12
3
```

### 비트 연산자

비트는 컴퓨터에서 데이터를 나타내는 최소 단위이다. 모든 데이터는 0과 1의 조합으로 구성된다. 이 0또는 1이 하나의 비트이다. 

|연산자|기능|
|------|--------------------|
|& (AND)| 비트단위로 AND 연산 / 양쪽의 비트가 모두 1이면 1이고, 아니면 0의 결과를 낸다. |
| `|`(OR)| 비트단위로 OR 연산 / 양쪽 데이터의 비트의 값을 OR 조건으로 따져서 한쪽 bit가 1이면 무조건 1의 결과를 반환 |
|^ (XOR) | 비트단위로 XOR 연산 / 양쪽의 비트가 서로 다른 비트면 1이고, 아니면 0의 결과를 낸다. |
|~ (NOT) | 피연산자의 모든 비트를 반전시켜 얻은 결과 반환 |

```java

public static void main(String[] args) {
    int a = 9;
    
    System.out.println(Integer.toBinaryString(a)); // binary로 반환
    System.out.println("10진수 : " + a);
    System.out.println("not 2진수 : " + Integer.toBinaryString(~a));
    System.out.println("not 10진수 : " + ~a);
```

output
```
직접 해보기
```

### 관계 연산자

두 피연산자간의 서로 크고 작음을 비교하는 연산자이며 비교연산자라고도 말을 한다.

왼쪽 피연산자와 우측 피연산자를 비교하여 `boolean 값으로 반환`하는 연산자


**아래의 기능의 부분이 맞으면 `true`를 반환 틀리면 `false`를 반환한다.**

|연산자|기능|
|------|--------------------|
|<| 왼쪽 피연산자가 오른쪽 피연산자보다 작은가|
|>| 왼쪽 피연산자가 오른쪽 피연산자보다 큰가|
|<=| 왼쪽 피연산자가 오른쪽 피연산자보다 같거나 작은가 |
|>=| 왼쪽 피연산자가 오른쪽 피연산자보다 같거나 큰가 |
|==| 두 연산자가 같은가 |
|!=| 두 연산자가 다른가 |

### 논리 연산자

|연산자|기능|
|------|--------------------|
|&&| 왼쪽 연산자와 오른쪽 연산자가 모두 `true`이면 연산결과는 `true`|
|`||`| 왼쪽과 오른쪽 둘 중 하나라도 `true`면 연산 견과는 `true` |
|!| 기존 연산결과와 반대 |


### instanceof

instanceof는 객체타입을 확인하는데 사용한다.

속성은 연산자이고 형변환이 가능한지 해당 여부를 true or false로 가르쳐준다.

instanceof를 이용한 연산결과로 true를 얻었다는 것은 참조변수가 검사한 타입으로 형변환이 가능하다는 것을 뜻한다.

부모 클래스(A)보다 자식 클래스(B)는 더 많은 기능을 담고 있다.

그러므로 자식 클래스(B)는 부모 클래스(A)로 형변환이 가능하다.

- B instanceof A : true
- A instanceof B : false

```java
public class instanceOf {

    public static void main(String[] args) {
        A a = new A();
        if (a instanceof Object) {
            System.out.println("오브젝트 클래스 형변환가능");
        }
        if (a instanceof A) {
            System.out.println("자신클래스 형변환 가능");
        }
        if(a instanceof B) {
            System.out.println("자식클래스 형변환가능");
        }
    }
}

class A {

}

class B extends A {

}
```

### assignment(=) operator

왼쪽 피연산자는 변수이고 오른쪽 피연산자는 값이다. 오른쪽에 있는 값을 왼쪽 변수에 넣어주는 연산자이다.

```
int a = 10;
char ch = 'y';
```

### 화살표(->) 연산자

람다식에서 사용하는 연산자로 람다 표현식 (lambda expression)이라고 말한다.

작성법

```
(매개변수목록) -> {함수몸체}
```


다음과 같은 메소드를 화살표 표현식으로 바꾸면 아래와 같이 된다.

메소드

```java
int min(int x, int y) {
    return x<y ? x:y;
}
```

람다 표현식

```java
(x, y) -> x < y ? x: y;
```

익명 클래스

```java
new Object() {
    int min(int x, int y) {
        return x < y ? x : y;
    }
}
```

### 3항 연산자

if 문을 사용하여 코딩을 할 경우 코딩라인이 길어지기 마련이다.

```java
int a;
if(5 < 4){
    a = 50;
} else if () {
    a = 40;
}
```

3항연산자의 표기법은 다음과 같다.

```
변수 = 조건문 ? 참일때의값 : 거짓일때 값;
```

위의 코드를 3항 연산자로 바꾸면 아래와 같다.

```java 
int a = (5 < 4) ? 50 : 40;
```


### 연산자 우선 순위

연산자에는 우선순위가 있다.

한 식에 여러 연산자가 있을시 , 해당 우선순위 순서대로 결과값이 계산이 된다.

|우선순위|연산자|내용|
|------|---------|----------------|
| 1 | (), [] | 괄호/대괄호 |
| 2 | !, ~, ++, -- | 부정/증감 연산자 |
| 3 | *, /, % | 곱셈 / 나눗셈 연산자 |
| 4 | +, - | 덧셈 / 뺄셈 연산자 |
| 5 | <<, >>, >>> | 비트단위의 시프트 연산자 |
| 6 | <, <=, >, >= | 관계 연산자 |
| 7 | ==, != | |
| 8 | & | 비트단위의 논리연산자 |
| 9 | ^ | |
| 10 | `|` | |
| 11 | && | 논리곱 연산자 |
| 12 | `||` | 논리합 연산자 |
| 13 | ? : | 조건 연산자 |
| 14 | =, +=, -=, *=, /=, %=, >>=, >>=, &=, ^=, ~= | 대입/할당연산자 |

### (optional) Java 13. switch 연산자

기존 Switch에서 `:` 사용하여 조건에 대한 처리를 진행

java13에서는 화살표 연산자 (->) 사용 가능

```java
switch(val) {
        case 'a':
            // something 'a'
        break;
    case 'b':
        // somethine 'b'
        break;
}
```

java 13
```java
switch(val) {
        case 'a' -> System.out.println('a');
    case 'b' -> System.out.println('b');
}
```

위와 같이 사용했을때 장점은 `break`을 사용하지 않아도 되고, 아래와 같은 표현식으로 사용 가능

```java

System.out.println(
    switch(val) {
        case 'a' -> "A"
        case 'b' -> "B"
        case 'c' -> "C"
    }
);

T a = switch(val) {
    case 'd' -> d;
    case 'e' -> e;
    default -> f;
};
```



### ref

- https://edu.goorm.io/learn/lecture/41/%EB%B0%94%EB%A1%9C%EC%8B%A4%EC%8A%B5-%EC%83%9D%ED%99%9C%EC%BD%94%EB%94%A9-%EC%9E%90%EB%B0%94-java/lesson/577/%EC%82%B0%EC%88%A0-%EC%97%B0%EC%82%B0%EC%9E%90
- https://neul-carpediem.tistory.com/20
- https://sowhat4.tistory.com/67
- https://beccacatcheserrors.tistory.com/10
- https://m.blog.naver.com/PostView.nhn?blogId=akohong&logNo=220801614365&proxyReferer=https:%2F%2Fwww.google.com%2F
- https://donologue.tistory.com/55
- https://vmpo.tistory.com/106
- https://medium.com/gdana/%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8%EC%9D%98-%EB%85%BC%EB%A6%AC-%EA%B4%80%EA%B3%84-%EB%B9%84%EA%B5%90-%EC%97%B0%EC%82%B0%EC%9E%90-44f2900a85b2
- https://improver.tistory.com/140
- https://arabiannight.tistory.com/313
- https://blog.naver.com/rwans0397/220602620066
- http://www.tcpschool.com/java/java_lambda_concept
- https://coding-factory.tistory.com/266
- https://toma0912.tistory.com/66