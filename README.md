# Programmers.Level2_Java_FuncDevelopment

## 프로그래머스 스택/큐 > 기능개발

### 1. 문제설명
input으로 작업의 초기 진척도 int[] progresses, 작업의 하루 개발속도 int[] speeds가 들어온다. 모든 작업은 input으로 들어온 순서대로 처리되어야 하며 완성도가 100가 되면 *배포*된다. 즉, 100% 완료된 작업이 있어도 이전작업이 100%가 되어 배포되지 않으면 배포되지 못한다. 이렇게 배포되는 날에 여러 작업들이 동시에 배포될텐데, 각 배포마다 몇개의 작업이 배포되는지 int[]으로 return하는 문제이다.

### 2. 풀이
매일 progresses에 speed만큼 더하며 배포되어야 할 작업 idx를 두어 progresses[idx] > 100일때 idx++를 해가며 완성이 되지 않는 작업이 나올 때 까지 그날 배포될 작업의 수를 count하였다. 이렇게 idx < progresses.length까지 반복하며 각 배포당 배포되는 작업의 수는 별도로 저장하여 return해주었다.

조건에 progresses의 길이가 100 이하라 되어있다. 1일을 기준으로 loop마다 모든 progresses를 계산해 주는것 보다 
```java
while (progresses[i] + (day*speed[i]) < 100)
  day++;
```
로 완성도 100%일때의 day로 한번에 하나의 progresses에 대해 검사하는 알고리즘이 더 경제적이다.
