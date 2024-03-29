-- 코드를 입력하세요
SELECT CATEGORY 
    , MAX(PRICE) AS 'MAX_PRICE'
    , PRODUCT_NAME
FROM FOOD_PRODUCT F
WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
AND PRICE = (SELECT MAX(PRICE) FROM FOOD_PRODUCT WHERE CATEGORY = F.CATEGORY GROUP BY CATEGORY)
GROUP BY CATEGORY
ORDER BY 2 DESC