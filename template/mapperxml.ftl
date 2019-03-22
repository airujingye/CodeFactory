<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<#macro mapperEL value>${r"#{"}${value}}</#macro>
<#macro jspEL value>${r"${"}${value}}</#macro>
<mapper namespace="com.greatmap.gmtravel.${table.packageName}mapper.${table.className}Mapper">
	
	<sql id="Base_Column_List">
	    ${table.primaryKey.name}<#list table.fieldList as f>,${f.name}</#list>
  	</sql>
	<select id="selectAll" resultType="com.greatmap.gmtravel.${table.packageName}entity.${table.className}">
		select <include refid="Base_Column_List" /> from ${table.tableName}
	</select>

	<select id="selectById" resultType="com.greatmap.gmtravel.${table.packageName}entity.${table.className}"
		parameterType="${table.primaryKey.type}">
		select <include refid="Base_Column_List" /> from ${table.tableName} where ${table.primaryKey.name}=<@mapperEL table.primaryKey.name/>
	</select>

	<select id="selectByPage" resultType="com.greatmap.gmtravel.${table.packageName}entity.${table.className}"
		parameterType="com.greatmap.gmtravel.common.util.Page">
		select <include refid="Base_Column_List" /> from ${table.tableName}
		<where>
			<if test="searchValue!=null and searchValue!=''">
				${table.primaryKey.name} like '%' <@mapperEL 'searchValue'/> '%'<#list table.fieldList as f> OR ${f.name} like '%' <@mapperEL 'searchValue'/> '%'</#list>
			</if>
		</where>
	</select>

	<select id="count" resultType="Integer">
		select count(*) from ${table.tableName}
	</select>

	<insert id="insert" parameterType="com.greatmap.gmtravel.${table.packageName}entity.${table.className}" >
		<#if table.primaryKey.autoIncrement>
		<selectKey resultType="${table.primaryKey.type}" keyProperty="${table.primaryKey.name}">  
			SELECT LAST_INSERT_ID() AS ${table.primaryKey.name} 
		</selectKey>
		</#if>
		insert into
		${table.tableName}(${table.primaryKey.name}<#list table.fieldList as f>,${f.name}</#list>)
		values(<@mapperEL table.primaryKey.name/><#list table.fieldList as f>,<@mapperEL f.name/></#list>)
	</insert>

	<update id="update" parameterType="com.greatmap.gmtravel.${table.packageName}entity.${table.className}">
		update ${table.tableName} set
		<#list table.fieldList as f><#if f_index!=0>,</#if>${f.name}=<@mapperEL f.name/></#list>
		where ${table.primaryKey.name}=<@mapperEL table.primaryKey.name/>
	</update>

	<update id="delete" parameterType="${table.primaryKey.type}">
		update ${table.tableName} set isdelete=1 where ${table.primaryKey.name}=<@mapperEL table.primaryKey.name/>
	</update>

</mapper>