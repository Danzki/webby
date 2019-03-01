<#import "/parts/common.ftl" as c>
<@c.page>
<div><b>Добавление профиля</b></div>
<div>Внимание! Новый профиль становится активным.</div>
    <form method="post" action="adddriver">
        <input type="text" name="name" placeholder="Введите короткое имя">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Добавить</button>
    </form>
<div>Список профилей</div>
<#list drivers as driver>
    ${driver.name}
    <b>${driver.active?then('Active', 'Non-active')}</b>
<#else>
    No drivers
</#list>
<div><a href="/main">Main page</a></div>
</@c.page>