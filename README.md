# Weather-Temp-Project
Using Java (Back-End)
عملکرد پروژه به این شکل است که هر 5 دقیقه یکبار درخواست به weatherapi.com ارسال کرده و اطلاعات جدید را در دیتابیس ذخیر میکند.
<br>
لیست زیر شامل تمام وبسرویس های موجود و اررور های آن هاست :
<br>

1 - دریافت آخرین وضعیت تمام شهر ها ( فقط آخرین وضعیت هر شهر اعلام میشود ) :
<br>
/weather (GET)
<br>
2 - دریافت تاریخچه وضعیت آب و هوای یک شهر :
<br>
/weather/{city} (GET)
<br>
Errors:
<br>
  404 - Not Found
  <br>

3 - دریافت لیست شهر های موجود :
<br>
/city (GET)
<br>
4 - افزودن یک شهر جدید :
<br>
/city (POST)
<br>
Params : name 
<br>
Errors : 
<br>
  409 - Record Already Exists
  <br>
 زمان اجرای برنامه برای اولین بار ، توسط فایل زیر ، دو شهر لندن و تهران به صورت پیشفرض در دیتابیس قرار گرفته و دیتای آنها خوانده میشود.
 <br>
 CityConfig (package : com.example.weather.config)
 
 
