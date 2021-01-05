# Python

## map()
- 반복가능 객체 요소의 전체 타입 변경 + 펼치기
- 기본 형식
  - `map(함수명, 반복객체)`
- 예제
    ```py
    A, B = map(int, input().split())
    ```

    ```py
    def f(x):
        return x+1

    new = list(map(f, [1, 2]))
    ```