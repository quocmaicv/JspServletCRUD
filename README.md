Làm 1 project CRUD quản lý User:
 - JDBC
 - JSP, SERVLET
 - Mô hình MVC
 - MySQL
 - CRUD
 - Sử dụng JSTL
 - Input/Output tiếng việt được

========= Lưu ý quan trọng: =========

- Tạo project thì maven -> web app 1.1 (Tạo kiểu khác thì có thể JSTL bị lỗi)
- Chạy thử JSTL đầu tiên: Đc thì code tiếp, kẻo code mất công mà nó éo lên

========= JSTL chạy thử -> Nó mà in ra Item từ 1 -> 5 thì OK hỉ =========

- <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
- <c:forEach var = "i" begin = "1" end = "5">
- Item <c:out value = "${i}"/><p>
- </c:forEach>

========= Lỗi thường gặp =========

 - Lỗi 404: lỗi url - xem xét lại config trong file .xml
   -> chú ý tên file controller nữa. đkm
 - lỗi 500: lỗi cú pháp
 - Lỗi font khi jsp -> servlet: do thiếu dòng code:
 -> request.setCharacterEncoding("UTF-8");

 ==> Tổng kết là: JSTL như cc, tạo project xong phải ưu tiên chạy nó trước, xem lên đc ko. mất công code rồi đéo lên. mẹ nó
