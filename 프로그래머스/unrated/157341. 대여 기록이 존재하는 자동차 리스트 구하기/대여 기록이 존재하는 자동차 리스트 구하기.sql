-- 코드를 입력하세요
SELECT DISTINCT CR.CAR_ID
FROM CAR_RENTAL_COMPANY_CAR AS CR, CAR_RENTAL_COMPANY_RENTAL_HISTORY AS CH
WHERE CR.CAR_ID = CH.CAR_ID
AND MONTH(CH.START_DATE) = '10'
AND CR.CAR_TYPE = '세단'
ORDER BY CAR_ID DESC;