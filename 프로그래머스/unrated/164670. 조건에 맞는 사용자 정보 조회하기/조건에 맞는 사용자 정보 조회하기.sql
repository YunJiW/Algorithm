-- 코드를 입력하세요
SELECT UG.USER_ID,UG.NICKNAME,CONCAT(UG.CITY,' ',UG.STREET_ADDRESS1,' ',UG.STREET_ADDRESS2) AS '전체주소', CONCAT(left(TLNO,3),'-',mid(TLNO,4,4),'-',right(TLNO,4)) AS '전화번호'
FROM USED_GOODS_BOARD AS UB, USED_GOODS_USER  AS UG
WHERE UG.USER_ID = UB.WRITER_ID
GROUP BY UG.USER_ID
HAVING COUNT(UG.USER_ID) >= 3
ORDER BY UG.USER_ID DESC;