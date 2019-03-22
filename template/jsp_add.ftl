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
<title>新增${table.tableTitle}</title>
<jsp:include page="/common/css.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<h4>新增${table.tableTitle}</h4>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<form action="${table.pageFolder}/${table.pageName}_add" method="post" class="form-horizontal">
					<#list table.fieldList as f>
					<div class="form-group">
						<label for="${f.name}" class="col-sm-2 control-label">${f.title}</label>
					    <div class="col-sm-10">
					    	<input type="text" class="form-control" id="${f.name}" name="${f.name}" placeholder="请输入${f.title}">
					    </div>
					</div>
					</#list>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<c:if test="<@jspEL 'sessionScope.loginer!=null'/>">
							<input type="hidden" name="recorder" value="<@jspEL 'sessionScope.loginer.id'/>">
							</c:if>
							<button type="submit" class="btn btn-default">保存</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="/common/js.jsp"></jsp:include>
</body>
</html>