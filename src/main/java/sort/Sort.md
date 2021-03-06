# 정렬이란?
정렬(sorting)은 이름, 학번, 키 등 핵심 항목(key)의 대소 관계에 따라 데이터 집합을 일정한 순서로 줄지어 늘어서도록 바꾸는 작업을 말한다.
## 내부 정렬과 외부 정렬
1. 내부 정렬(internal sorting) : 정렬할 모든 데이터를 하나의 배열에 저장할 수 있는 경우에 사용하는 알고리즘 
2. 외부 정렬(external sorting) : 정렬할 데이터가 모두 많아서 하나의 배열에 저장할 수 없는 경우에 사용하는 알고리즘
## 정렬 알고리즘의 핵심 요소
정렬 알고리즘의 핵심 요소는 교환, 선택, 삽입이며 대부분의 정렬 알고리즘은 이 세가지 요소를 응용한 것이다.
## 정렬 종류
### 1. 버블정렬
요소의 개수가 n 개인 배열에서 n-1, n-2 ..., 1 회 비교 수행
비교횟수 : n(n-1)/2 회
평균 교환 횟수 : n(n-1)/4 회 (비교 횟수의 절반)
값의 이동이 3번 발생하므로, 이동 횟수 평균은 : 3n(n-1)/4 회
### 2. 선택정렬 - 안정적이지 않음
가장 작은 요소부터 선택해 알맞은 위치로 옮겨서 순서대로 정렬하는 알고리즘
비교횟수 : n(n-1)/2 회
### 3. 삽입정렬 - 안정적
선택한 요소를 그 보다 더 앞쪽의 알맞은 위치에 삽입하는 작업을 반복하는 알고리즘
비교 횟수, 교환 횟수 : n^2/2

---------------- n^2의 시간복잡도를 갖는 정렬들 끝 ---------------------------


