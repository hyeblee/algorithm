SELECT DISTINCT A.ID
              , A.EMAIL
              , A.FIRST_NAME
              , A.LAST_NAME
FROM DEVELOPERS A
JOIN SKILLCODES B
  ON (A.SKILL_CODE & B.CODE) > 0   -- 개발자가 B.CODE 스킬을 보유했는지 체크
WHERE B.NAME IN ('Python', 'C#')    -- Python 또는 C# 스킬 필터
ORDER BY A.ID ASC;                  -- ID 기준 오름차순 정렬
