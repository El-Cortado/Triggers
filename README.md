# Triggers

See [example](app/src/main/java/com/barapps/triggers/example/Main.java)


# הדמיון בין הטריגרים האלו לאלו הישנים
מורכבים מתנאים - שאם הם מתקיימים - הפעולות רצות

# מה שונה?
במקום האחר, לכל טריגר מוגדר אינטרוול הריצה שלו והוא קבוע. כאן למעשה יש הבדל בין טריגרים "רגעיים" לטריגרים ממושכים ויותר מזה - הפעולות הם אלו שמגדירות מה זמן הריצה שלהם ואלו סוג של פעולות קיימות.

דוגמא - אם יש פעולה שהיא רגעית  - ניתן לשלב טריגר שבו זה יקרה רק פעם אחת ובאותה מידע לבצע את הפעולה יחד עם עוד פעולות בלתי תלויות או בכלל להחליט שאת התנאי מתקיים הפעולה תקרה כל 5 דקות החל מעוד 10 שניות.

יש ניתוק מוחלט בין התנאים ומתי הם נדגמים - לאלו פעולות ירוצו.


#### מה נשאר לעשות

המון דברים
1. להוסיף את כל התנאים
2. לייצר תנאים "מרוכבים" - שמגדירים את זמן הדגימה שלהם או שהם בכלל ב-push
3. לייצר מנגנון סנכרון של הטריגרים. כלומר אם יש תנאי שהוא בדחיפה, צריך עכשיו לסנכרן את הטריגר - רמז - שיטוח התנאים כבר קיים :)
4. להוסיף פעולות "מרוכבות" - כמו רצף פעולות שאם אחד מהם נכשל מפסיקים - או אינטרוול בין פעולות או כל דבר אחר
5. לחשוב על כך שבזבוז סוללה ומשאבים ריצה זה דבר יקר - לחשוב איך עושים הכל נכון ולא רק דיזיין נכון
6. להוסיף תמיכה בעוד המון דברים בלתי תלויים כמו
עדכון תנאים,

שיקוף ערכים,

אופטימיזצייה בזמן אמת על התנאים כדי שישתמשו באותם מנגנוני דחיפה.

הוספה, הסרה, ושינוי שיובילו לעדכון האופטימיזצייה לדוגמא או שינוי במנגונוי הדחיפה - כי לדוגמא כבר לא מאזינים להם

לייצר מנגנון שאם יש פעולה קריטית אז גם אם היא מופיעה במס' תנאים היא תקרה רק פעם אחת על כל זמן מחזורי מסוים

אלו רק דברים שרשמתי תוך כדי שחשבתי עליהם תוך כדי כתיבת המסמך, יש עוד מליון דברים שאפשר להוסיף - תחשבו גם על דברים שיש היום והם פשוט לא נכונים כמו 
Param Condition
