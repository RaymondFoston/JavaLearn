<%--
  Created by IntelliJ IDEA.
  User: Hugn
  Date: 2/22/2019
  Time: 4:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="/hello?a=2&&c=2">你好</a>
  <%--restful分格--%>
  <form action="/book/" method="post">
    <input type="submit" value="增加"/>
  </form>
  <form action="/book/1" method="post">
    <input name="_method" value="put" type="hidden"/>
    <input type="submit" value="修改"/>
  </form>
  <form action="/book/1" method="post">
    <input name="_method" value="delete" type="hidden"/>
    <input type="submit" value="删除"/>
  </form>
  <a href="/book/1" methods="get">
    查询
  </a>
  <%--获取请求信息--%>
  <form action="/request" method="get">
    <input name="user" />
    <input type="submit" value="submit"/>
  </form>
  <hr/>
  <%--处理POJO对象--%>
  <form action="bookHandler" method="post">
    书名: <input type="text" name="bookName"/><br/>
    作者: <input type="text" name="author"/><br/>
    库存: <input type="text" name="stock"/><br/>
    价格: <input type="text" name="price"/><br/>
    销量: <input type="text" name="sales"/><br/>
    街道: <input type="text" name="address.street"/><br/>
    省: <input type="text" name="address.province"/><br/>
    <input type="submit"  value="提交"/>
  </form>
  </form>
  <hr/>
  <h2>FifththController</h2>
<a href="/httpHandler">httlpHandler</a>
  <hr/>
  <h2>SixthController</h2>
  <a href="/handler01">传数据到页面handler01</a><br/>
  <a href="/handler02">传数据到页面handler02</a><br/>
  <a href="/handler03">传数据到页面handler03</a><br/>
  <a href="/handler04">传数据到页面handler04</a><br/>
  </body>
</html>
