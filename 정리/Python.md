# Python

## map()
> 반복가능 객체 요소의 전체 타입 변경 + 펼치기
- 기본 형식
  > `map(함수명, 반복객체)`
- 예제
  ```py
  A, B = map(int, input().split())
  ```
  ```py
  def f(x):
      return x+1

  new = list(map(f, [1, 2]))
  ```

## .strip()
> 문자열 앞뒤의 `whitespace` 제거 (중간에는 제거 X)
- `whitespace` : ' ', '\t', '\n'

## 리스트 메소드
- 추가 및 삽입
  - `.append(요소)`
    - 마지막 위치에 새 요소 추가
  - `.insert(위치, 요소)`
    - 해당 위치 앞에 삽입
  - `.extend(리스트)`
    - 마지막 위치에 새 리스트 추가
- 삭제
  - `del 명령어`
    ```py
    del a[0:2]
    ```
  - `.remove(요소)`
    - 해당 요소를 찾아 삭제
  - 요소 수정 이용
    ```py
    a[0:2] = []
    ```

## 예외 처리
- `EOFError` 등