<#import "/parts/common.ftl" as c>
<#import "/parts/login.ftl" as l>
<@c.page>
<b>Add new user</b>
${#message}
<@l.login "/registration" />
</@c.page>