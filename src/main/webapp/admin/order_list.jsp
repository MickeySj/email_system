<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>订单列表</title>
    <link rel="stylesheet" href="../admin/css/bootstrap.css"/>
    <%--    <link rel="stylesheet" type="text/css" href="../index/css/bootstrap.min.css">--%>
</head>
<body>
<div class="container">

    <%@include file="header.jsp" %>

    <br>

    <ul role="tablist" class="nav nav-tabs">
        <li
                <c:if test='${status==0}'>class="active"</c:if> role="presentation"><a href="orderList">全部订单</a></li>
        <li
                <c:if test='${status==1}'>class="active"</c:if> role="presentation"><a href="orderList?status=1">未付款</a>
        </li>
        <li
                <c:if test='${status==2}'>class="active"</c:if> role="presentation"><a href="orderList?status=2">已付款</a>
        </li>
        <li
                <c:if test='${status==3}'>class="active"</c:if> role="presentation"><a href="orderList?status=3">配送中</a>
        </li>
        <li
                <c:if test='${status==4}'>class="active"</c:if> role="presentation"><a href="orderList?status=4">已完成</a>
        </li>
    </ul>

    <br>

    <table class="table table-bordered table-hover">

        <tr>
            <th width="5%">ID</th>
            <th width="5%">总价</th>
            <th width="15%">商品详情</th>
            <th width="20%">收货信息</th>
            <th width="10%">订单状态</th>
            <th width="10%">支付方式</th>
            <th width="10%">下单用户</th>
            <th width="10%">下单时间</th>
            <th width="10%">操作</th>
        </tr>

        <c:forEach var="order" items="${orderList}">
            <tr>
                <td><p>${order.id}</p></td>
                <td><p>${order.total}</p></td>
                <td>
                    <c:forEach var="item" items="${order.itemList}">
                        <a target="_blank" href="/goods/detail?id=${item.good.id}"><p>${item.good.name}</p></a>
                        <p>¥${item.price} x ${item.amount}</p>
                    </c:forEach>
                </td>
                <td>
                    <p>${order.name}</p>
                    <p>${order.phone}</p>
                    <p>${order.address}</p>
                </td>
                <td>
                    <p>
                        <c:if test="${order.status==1}">未付款</c:if>
                        <c:if test="${order.status==2}"><span style="color:red;">已付款</span></c:if>
                        <c:if test="${order.status==3}">配送中</c:if>
                        <c:if test="${order.status==4}">已完成</c:if>
                    </p>
                </td>
                <td>
                    <p>
                        <c:if test="${order.paytype==1}">微信</c:if>
                        <c:if test="${order.paytype==2}">支付宝</c:if>
                        <c:if test="${order.paytype==3}">货到付款</c:if>
                    </p>
                </td>
                <td><p>${order.user.username}</p></td>
                <td><p>${order.systime}</p></td>
                <td>
                    <c:if test="${order.status==2}">
                        <a class="btn btn-success" href="orderSend?id=${order.id}&status=${status}">发货</a>
                    </c:if>
                    <c:if test="${order.status==3}">
                        <a class="btn btn-warning" href="orderFinish?id=${order.id}&status=${status}">完成</a>
                    </c:if>
                    <a class="btn btn-danger" href="orderDelete?id=${order.id}&status=${status}">删除</a>
                </td>
            </tr>
        </c:forEach>

    </table>
    <%-- 在此处解析分页数据 前端地址栏中传入数据 --%>
    <%--    <c:if test="${page!=null}">--%>
    <nav aria-label="Page navigation" style="text-align: center">
        <ul class="pagination">
            <li class="current">
                <a href="${url}?current=1<c:if test="${type!=null}">&id=${type.id}</c:if>"
                   aria-label="Previous">
                    <span aria-hidden="true">首页</span>
                </a>
            </li>
            <c:forEach begin="1" end="${page.pageTotal}" var="page">
                <li
                        class="current"><a
                        href="${url}?current=${page}<c:if test="${type!=null}">&id=${type.id}</c:if>">${page}</a>
                </li>
            </c:forEach>
            <li class="current">
                <a href="${url}?current=${page.pageTotal}<c:if test="${type!=null}">&id=${type.id}</c:if>"
                   aria-label="Next">
                    <span aria-hidden="true">尾页</span>
                </a>
            </li>
        </ul>
    </nav>
    <%--    </c:if>--%>

</div>
</body>
</html>