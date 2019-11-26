<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath(); %>
<html>
  <head>
    <title></title>
  </head>
  <body>
          <form name = "frm" method = "post" action="<%=path%>/LoginDo">
              <p>用户名:<input type = "text" name = "name">
              <p>密码:<input type = "password" name = "pwd">
              <p> <input type = "submit" value = "登录">
                  <input type = "reset" value = "重置">
          </form>

          <form name = "frm" method = "post" action="<%=path%>/RegistDo">
              <p>用户名:<input type = "text" name = "name">
              <p>密码:<input type = "password" name = "pwd">
              <p> <input type = "submit" value = "注册">
          </form>

          <form name = "frm" method = "post" action="<%=path%>/deleteDo">
              <p>ID:<input type = "text" name = "id">
              <p> <input type = "submit" value = "删除">
          </form>

          <form name = "frm" method = "post" action="<%=path%>/updateDo">
              <p>ID:<input type = "text" name = "id">
              <p>用户名:<input type = "text" name = "name">
              <p>密码:<input type = "password" name = "pwd">
              <p> <input type = "submit" value = "修改">
          </form>
  </body>
</html>