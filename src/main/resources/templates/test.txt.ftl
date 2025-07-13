<#if username == "张三">
当前登录的用户姓名是张三
<#else>
用户不是张三, 是: ${username}
</#if>

时间: ${curDate}

爱好:
<#list hobbies as hobby>
${hobby}
</#list>