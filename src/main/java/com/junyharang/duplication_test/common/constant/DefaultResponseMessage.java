package com.junyharang.duplication_test.common.constant;

public interface DefaultResponseMessage {
    /* Status Code */
    int OK = 200;
    int CREATE_SUCCESS = 201;
    int BAD_REQUEST = 400;
    int UN_AUTHORIZATION = 401;
    int NOT_FOUND = 404;
    int SERVER_ERROR = 500;

    /* 한글 */

    String KOREAN_200 = "작업 성공";
    String KOREAN_201 = "등록 성공";
    String KOREAN_401 = "접근 불가";
    String KOREAN_400 = "잘못된 요청";
    String KOREAN_404 = "찾을 수 없음";
    String KOREAN_500 = "서버 문제";

    /* 영어 */

    String ENGLISH_200 = "OK";
    String ENGLISH_201 = "Create Success";
    String ENGLISH_400 = "Bad Request";
    String ENGLISH_401 = "Un Authorization";
    String ENGLISH_404 = "Not Found";
    String ENGLISH_500 = "Internal Server Error";
}
