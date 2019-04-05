<#import "/parts/common.ftl" as c>
<#import "/parts/login.ftl" as l>
<@c.page>
    <div>
        <@l.logout/>
        <span><a href="/user">User list</a> </span>
    </div>
    <div><h1>Профиль драйвера</h1></div>
    <div>
        Текущий профиль - ....
    </div>
    <a href="/driver">Управление профилями</a>
    <div><h1>Команды</h1></div>
    <div><h2>Добавление команды</h2></div>
    <div>
        <form method="post">
            <input type="text" name="shortName" placeholder="Введите короткое имя">
            <input type="text" name="name" placeholder="Введите название команды">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Добавить</button>
        </form>
    </div>
    <div><h2>Поиск команды</h2></div>
    <form method="get" action="/main">
        <input type="text" name="shortName" placeholder="Короткое имя клуба" value="${shortName}">
        <button type="submit">Найти</button>
    </form>
    <div><h2>Список команд</h2></div>
    <#list teams as team>
        <div>
            <b>${team.shortName}</b>
            <span>${team.name}</span>
          <!--  <a href="/driver?team=${team.shortName}">Change driver</a>  -->
        </div>
    <#else >
        No teams
    </#list>
</@c.page>