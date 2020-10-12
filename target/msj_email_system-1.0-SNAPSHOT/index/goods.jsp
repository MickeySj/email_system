<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <c:if test="${flag==2}"><title>今日推荐</title></c:if>
    <c:if test="${flag==3}"><title>热销排行</title></c:if>
    <c:if test="${flag==4}"><title>新品上市</title></c:if>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../index/css/public.css">
    <link rel="stylesheet" type="text/css" href="../index/css/reclassify.css">
    <link rel="stylesheet" type="text/css" href="../index/css/bootstrap.min.css">
</head>
<body>

<jsp:include page="header.jsp"/>

<div id="main" class="main">

    <c:if test="${type!=null}">
        <div id="mnav" style="background: #f6f6f6;border: 1px solid #eee;">
            <a href="/index/type?id=${type.id}"><span style="color:#ff852b;">${type.name}</span></a>
            <i class="iconfont icon-arrow-left"></i>
        </div>
    </c:if>
    <%-- 搜索框 --%>
    <c:if test="${name!=null}">
        <div id="mnav" style="background: #f6f6f6;border: 1px solid #eee;">
            <span>搜索结果</span>
            <i class="iconfont icon-arrow-left"></i>
            <span>${name}</span>
        </div>
    </c:if>

    <div class="goodscont clearfix">

        <c:forEach items="${goodList}" var="good">
            <div class="goods-box animated wobble">
                <div class="goods">
                    <a target="_blank" href="/goods/detail?id=${good.id}">
                        <div class="img-box">
                            <img src="../index/${good.cover}">
                        </div>
                    </a>
                    <a target="_blank" href="/goods/detail?id=${good.id}">
                        <p class="goodsname">${good.name}</p>
                    </a>
                    <p class="goods-descript">${good.intro}</p>
                    <p class="goods-spec">${good.spec}</p>
                    <p class="goodsprices" style="display:block;">
                        <span class="yj">￥<span class="yjcont">${good.price}</span></span>
                    </p>
                    <p class="addcart" data-id="${good.id}" style="display:none;"><i
                            class="iconfont icon-gouwuche3"></i>加入购物车</p>
                </div>
            </div>
        </c:forEach>
        <%-- 前端对于goodList集合的处理 --%>
        <c:if test="${goodList==null || fn:length(goodList)==0}">
            <div id="searchnull">
                <img src="../index/img/searchnull.png">
                <p>很抱歉，没有找到相关产品~<br>换个关键词吧~</p>
            </div>
        </c:if>

    </div>
    <%-- 在此处解析分页数据 前端地址栏中传入数据 --%>
    <c:if test="${page!=null}">
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
    </c:if>

    <%--    ${page}--%>
    ${pageHtml}

</div>


<jsp:include page="footer.jsp"/>

</body>
<script src="../index/js/jquery.min.js" type="text/javascript"></script>
<script src="../index/js/bootstrap.js" type="text/javascript"></script>
<script type="text/javascript">
    // 显示隐藏购物车
    $(".goods-box").on("mouseenter", function () {
        $(this).addClass("active")
        $(this).find(".addcart").show()
        $(this).find(".reserve").show()
        $(this).find(".m_stop").show()
        $(this).find(".goodsprices").hide()
    });
    $(".goods-box").on("mouseleave", function () {
        $(this).removeClass("active")
        $(this).find(".addcart").hide()
        $(this).find(".reserve").hide()
        $(this).find(".m_stop").hide()
        $(this).find(".goodsprices").show()
    });
</script>
</html>