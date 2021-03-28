# C++

## atoi(숫자같은문자열)
> char -> int 변환

## cin >> 변수;
- 뒤에 문자열 입력 시 입력버퍼 발생 -> `cin.ignore();` 필요O

## cin.getline(배열명, 최대길이);
-  1줄만 입력받기
- `cin.ignore();` 필요X

## cin.ignore();
> 입력버퍼 비우기

## sizeof(배열)
> 배열이 차지하는 전체 크기 반환
- ex.
    ```c++
    int intArr[10] = {0};
    sizeof(intArr) / sizeof(int);   // 40/4 => 10
    ```

## strlen(문자열)
> 길이 반환 (\0 제외, 순수 길이)

