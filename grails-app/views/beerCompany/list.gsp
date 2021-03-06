
<%@ page import="beerapp.BeerCompany" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'beerCompany.label', default: 'BeerCompany')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'beerCompany.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'beerCompany.name.label', default: 'Name')}" />

                            <g:sortableColumn property="name" title="${message(code: 'beerCompany.hops.label', default: 'Name')}" />

                            <g:sortableColumn property="name" title="${message(code: 'beerCompany.rating.label', default: 'Rating')}" />

                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${beerCompanyInstanceList}" status="i" var="beerCompanyInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link mapping="beerCompanyApi" id="${beerCompanyInstance.id}">${fieldValue(bean: beerCompanyInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: beerCompanyInstance, field: "name")}</td>

                            <td>${fieldValue(bean: beerCompanyInstance, field: "hops")}</td>

                            <td>${fieldValue(bean: beerCompanyInstance, field: "rating")}</td>

                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${beerCompanyInstanceTotal}" />
            </div>
        </div>

        <g:link mapping="beerApi">JSON list of Beers</g:link>
    </body>
</html>
