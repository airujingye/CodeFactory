<#macro mapperEL value>${r"#{"}${value}}</#macro>
<#macro jspEL value>${r"${"}${value}}</#macro>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.cnrgs.com/core" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/common/var.jsp"></jsp:include>
<jsp:include page="/common/meta.jsp"></jsp:include>
<title>${table.tableTitle}列表</title>
<jsp:include page="/common/css.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h3>${table.tableTitle}列表</h3>
			</div>
			<div class="col-md-12 pull-right">
				<a class="btn btn-default" href="${table.pageFolder}/${table.pageName}_add.jsp" role="button">新增</a>
				<a class="btn btn-default" href="${table.pageFolder}/list" role="button">刷新</a>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<form class="form-inline" action="${table.pageFolder}/list"
					id="queryForm" name="queryForm" method="post">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">请输入查询条件:</span>
						<input type="text" name="searchValue" class="form-control"
							aria-describedby="basic-addon1" value="<@jspEL 'page.searchValue'/>">
					</div>
					<button type="submit" class="btn btn-default">查询</button>
					<input type="hidden" id="currentPage" name="currentPage"
						value="<@jspEL 'page.currentPage'/>">
				</form>
			</div>
			<div class="col-md-12">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>序号</th>
							<th>${table.primaryKey.title}</th>
							<#list table.fieldList as f>
							<th>${f.title}</th>
							</#list>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="<@jspEL 'dataList'/>" var="bean" varStatus="status">
							<tr>
								<td scope="row" align="center"><@jspEL 'page.fromRow+status.index+1'/></td>
								<td><@jspEL 'bean.${table.primaryKey.name}'/></td>
								<#list table.fieldList as f>
								<td><@jspEL 'bean.${f.name}'/></td>
								</#list>
								<td><a title="修改"
									href="${table.pageFolder}/${table.pageName}_update_page.do?${table.primaryKey.name}=<@jspEL 'bean.${table.primaryKey.name}'/>"><span
										class="glyphicon glyphicon-edit"></span> </a> <a title="删除"
									href="${table.pageFolder}/${table.pageName}_delete.do?${table.primaryKey.name}=<@jspEL 'bean.${table.primaryKey.name}'/>"><span
										class="glyphicon glyphicon-remove"></span> </a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-md-12 pull-right">
				共<@jspEL 'page.totalSize'/>条 当前第<@jspEL 'page.currentPage'/>/<@jspEL 'page.totalPage'/>页
				<div class="btn-group" role="group" aria-label="...">
					<c:if test="<@jspEL 'page.currentPage>1'/>">
						<button type="button" class="btn btn-default btn-sm"
							onclick="gotoPage(1)">
							<span class="glyphicon glyphicon-step-backward"
								aria-hidden="true">
						</button>
						<button type="button" class="btn btn-default btn-sm"
							onclick="gotoPage(<@jspEL 'page.currentPage-1'/>)">
							<span class="glyphicon glyphicon-triangle-left"
								aria-hidden="true">
						</button>
					</c:if>
					<c:if test="<@jspEL 'page.currentPage<page.totalPage'/>">
						<button type="button" class="btn btn-default btn-sm"
							onclick="gotoPage(<@jspEL 'page.currentPage+1'/>)">
							<span class="glyphicon glyphicon-triangle-right"
								aria-hidden="true">
						</button>
						<button type="button" class="btn btn-default btn-sm"
							onclick="gotoPage(<@jspEL 'page.totalPage'/>)">
							<span class="glyphicon glyphicon-step-forward" aria-hidden="true">
						</button>
					</c:if>
				</div>
				跳至<input type="text" id="pn" style="width:40px">页
				<button type="button" class="btn btn-default btn-sm" onclick="gotoPageTo()">GO</button>
			</div>
		</div>
	</div>
	<jsp:include page="/common/js.jsp"></jsp:include>
	<script type="text/javascript">
		function gotoPageTo(){
			gotoPage($("#pn").val());
		}
		
		function gotoPage(pn){
			$("#currentPage").val(pn);
			$("#queryForm").submit();
		}
	</script>
</body>
</html>