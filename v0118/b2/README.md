# 정상 흐름
```
o.s.security.web.FilterChainProxy        : Trying to match request against DefaultSecurityFilterChain [RequestMatcher=any request, Filters=[org.springframework.security.web.session.DisableEncodeUrlFilter@7c901a00, org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter@59a1cc2f, org.springframework.security.web.context.SecurityContextPersistenceFilter@2e982a2d, org.springframework.security.web.header.HeaderWriterFilter@7030125c, org.springframework.web.filter.CorsFilter@703bf096, org.springframework.security.web.authentication.logout.LogoutFilter@6de41f70, org.zerock.b2.filter.JWTLoginFilter@3da92501, org.zerock.b2.filter.TokenCheckFilter@419568ae, org.springframework.security.web.savedrequest.RequestCacheAwareFilter@251e9720, org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter@518f4b42, org.springframework.security.web.authentication.AnonymousAuthenticationFilter@16820407, org.springframework.security.web.session.SessionManagementFilter@55c9008d, org.springframework.security.web.access.ExceptionTranslationFilter@5acf3659]] (1/1)
o.s.security.web.FilterChainProxy        : Securing OPTIONS /api/sample/ex1
o.s.security.web.FilterChainProxy        : Invoking DisableEncodeUrlFilter (1/13)
o.s.security.web.FilterChainProxy        : Invoking WebAsyncManagerIntegrationFilter (2/13)
o.s.security.web.FilterChainProxy        : Invoking SecurityContextPersistenceFilter (3/13)
s.s.w.c.SecurityContextPersistenceFilter : Set SecurityContextHolder to empty SecurityContext
o.s.security.web.FilterChainProxy        : Invoking HeaderWriterFilter (4/13)
o.s.security.web.FilterChainProxy        : Invoking CorsFilter (5/13)
o.s.s.w.header.writers.HstsHeaderWriter  : Not injecting HSTS header since it did not match request to [Is Secure]
s.s.w.c.SecurityContextPersistenceFilter : Cleared SecurityContextHolder to complete request
o.s.security.web.FilterChainProxy        : Trying to match request against DefaultSecurityFilterChain [RequestMatcher=any request, Filters=[org.springframework.security.web.session.DisableEncodeUrlFilter@7c901a00, org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter@59a1cc2f, org.springframework.security.web.context.SecurityContextPersistenceFilter@2e982a2d, org.springframework.security.web.header.HeaderWriterFilter@7030125c, org.springframework.web.filter.CorsFilter@703bf096, org.springframework.security.web.authentication.logout.LogoutFilter@6de41f70, org.zerock.b2.filter.JWTLoginFilter@3da92501, org.zerock.b2.filter.TokenCheckFilter@419568ae, org.springframework.security.web.savedrequest.RequestCacheAwareFilter@251e9720, org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter@518f4b42, org.springframework.security.web.authentication.AnonymousAuthenticationFilter@16820407, org.springframework.security.web.session.SessionManagementFilter@55c9008d, org.springframework.security.web.access.ExceptionTranslationFilter@5acf3659]] (1/1)
o.s.security.web.FilterChainProxy        : Securing GET /api/sample/ex1
o.s.security.web.FilterChainProxy        : Invoking DisableEncodeUrlFilter (1/13)
o.s.security.web.FilterChainProxy        : Invoking WebAsyncManagerIntegrationFilter (2/13)
o.s.security.web.FilterChainProxy        : Invoking SecurityContextPersistenceFilter (3/13)
s.s.w.c.SecurityContextPersistenceFilter : Set SecurityContextHolder to empty SecurityContext
o.s.security.web.FilterChainProxy        : Invoking HeaderWriterFilter (4/13)
o.s.security.web.FilterChainProxy        : Invoking CorsFilter (5/13)
o.s.security.web.FilterChainProxy        : Invoking LogoutFilter (6/13)
o.s.s.w.a.logout.LogoutFilter            : Did not match request to Or [Ant [pattern='/logout', GET], Ant [pattern='/logout', POST], Ant [pattern='/logout', PUT], Ant [pattern='/logout', DELETE]]
o.s.security.web.FilterChainProxy        : Invoking JWTLoginFilter (7/13)
o.s.security.web.FilterChainProxy        : Invoking TokenCheckFilter (8/13)
org.zerock.b2.filter.TokenCheckFilter    : [TokenCheckFilter: doFilterInternal]
org.zerock.b2.filter.TokenCheckFilter    : mid: username
o.z.b2.service.CustomUserDetailsService  : [CustomUserDetailsService]: loadUserByUsername
o.s.security.web.FilterChainProxy        : Invoking RequestCacheAwareFilter (9/13)
o.s.security.web.FilterChainProxy        : Invoking SecurityContextHolderAwareRequestFilter (10/13)
o.s.security.web.FilterChainProxy        : Invoking AnonymousAuthenticationFilter (11/13)
o.s.s.w.a.AnonymousAuthenticationFilter  : Did not set SecurityContextHolder since already authenticated UsernamePasswordAuthenticationToken [Principal=org.springframework.security.core.userdetails.User [Username=username, Password=[PROTECTED], Enabled=true, AccountNonExpired=true, credentialsNonExpired=true, AccountNonLocked=true, Granted Authorities=[ROLE_ADMIN, ROLE_USER]], Credentials=[PROTECTED], Authenticated=true, Details=null, Granted Authorities=[ROLE_ADMIN, ROLE_USER]]
o.s.security.web.FilterChainProxy        : Invoking SessionManagementFilter (12/13)
s.CompositeSessionAuthenticationStrategy : Preparing session with ChangeSessionIdAuthenticationStrategy (1/1)
o.s.security.web.FilterChainProxy        : Invoking ExceptionTranslationFilter (13/13)
o.s.security.web.FilterChainProxy        : Secured GET /api/sample/ex1
o.s.s.a.i.a.MethodSecurityInterceptor    : Did not re-authenticate UsernamePasswordAuthenticationToken [Principal=org.springframework.security.core.userdetails.User [Username=username, Password=[PROTECTED], Enabled=true, AccountNonExpired=true, credentialsNonExpired=true, AccountNonLocked=true, Granted Authorities=[ROLE_ADMIN, ROLE_USER]], Credentials=[PROTECTED], Authenticated=true, Details=null, Granted Authorities=[ROLE_ADMIN, ROLE_USER]] before authorizing
o.s.s.a.i.a.MethodSecurityInterceptor    : Authorizing ReflectiveMethodInvocation: public java.util.Map org.zerock.b2.controller.SampleRestController.ex1(); target is of class [org.zerock.b2.controller.SampleRestController] with attributes [[authorize: 'permitAll()', filter: 'null', filterTarget: 'null']]
o.s.s.a.i.a.MethodSecurityInterceptor    : Authorized ReflectiveMethodInvocation: public java.util.Map org.zerock.b2.controller.SampleRestController.ex1(); target is of class [org.zerock.b2.controller.SampleRestController] with attributes [[authorize: 'permitAll()', filter: 'null', filterTarget: 'null']]
o.s.s.a.i.a.MethodSecurityInterceptor    : Did not switch RunAs authentication since RunAsManager returned null
o.s.s.w.header.writers.HstsHeaderWriter  : Not injecting HSTS header since it did not match request to [Is Secure]
s.s.w.c.SecurityContextPersistenceFilter : Cleared SecurityContextHolder to complete request
```

## Access Token 만료
```
o.s.security.web.FilterChainProxy        : Trying to match request against DefaultSecurityFilterChain [RequestMatcher=any request, Filters=[org.springframework.security.web.session.DisableEncodeUrlFilter@7c901a00, org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter@59a1cc2f, org.springframework.security.web.context.SecurityContextPersistenceFilter@2e982a2d, org.springframework.security.web.header.HeaderWriterFilter@7030125c, org.springframework.web.filter.CorsFilter@703bf096, org.springframework.security.web.authentication.logout.LogoutFilter@6de41f70, org.zerock.b2.filter.JWTLoginFilter@3da92501, org.zerock.b2.filter.TokenCheckFilter@419568ae, org.springframework.security.web.savedrequest.RequestCacheAwareFilter@251e9720, org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter@518f4b42, org.springframework.security.web.authentication.AnonymousAuthenticationFilter@16820407, org.springframework.security.web.session.SessionManagementFilter@55c9008d, org.springframework.security.web.access.ExceptionTranslationFilter@5acf3659]] (1/1)
o.s.security.web.FilterChainProxy        : Securing OPTIONS /api/sample/ex1
o.s.security.web.FilterChainProxy        : Invoking DisableEncodeUrlFilter (1/13)
o.s.security.web.FilterChainProxy        : Invoking WebAsyncManagerIntegrationFilter (2/13)
o.s.security.web.FilterChainProxy        : Invoking SecurityContextPersistenceFilter (3/13)
s.s.w.c.SecurityContextPersistenceFilter : Set SecurityContextHolder to empty SecurityContext
o.s.security.web.FilterChainProxy        : Invoking HeaderWriterFilter (4/13)
o.s.security.web.FilterChainProxy        : Invoking CorsFilter (5/13)
o.s.s.w.header.writers.HstsHeaderWriter  : Not injecting HSTS header since it did not match request to [Is Secure]
s.s.w.c.SecurityContextPersistenceFilter : Cleared SecurityContextHolder to complete request
o.s.security.web.FilterChainProxy        : Trying to match request against DefaultSecurityFilterChain [RequestMatcher=any request, Filters=[org.springframework.security.web.session.DisableEncodeUrlFilter@7c901a00, org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter@59a1cc2f, org.springframework.security.web.context.SecurityContextPersistenceFilter@2e982a2d, org.springframework.security.web.header.HeaderWriterFilter@7030125c, org.springframework.web.filter.CorsFilter@703bf096, org.springframework.security.web.authentication.logout.LogoutFilter@6de41f70, org.zerock.b2.filter.JWTLoginFilter@3da92501, org.zerock.b2.filter.TokenCheckFilter@419568ae, org.springframework.security.web.savedrequest.RequestCacheAwareFilter@251e9720, org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter@518f4b42, org.springframework.security.web.authentication.AnonymousAuthenticationFilter@16820407, org.springframework.security.web.session.SessionManagementFilter@55c9008d, org.springframework.security.web.access.ExceptionTranslationFilter@5acf3659]] (1/1)
o.s.security.web.FilterChainProxy        : Securing GET /api/sample/ex1
o.s.security.web.FilterChainProxy        : Invoking DisableEncodeUrlFilter (1/13)
o.s.security.web.FilterChainProxy        : Invoking WebAsyncManagerIntegrationFilter (2/13)
o.s.security.web.FilterChainProxy        : Invoking SecurityContextPersistenceFilter (3/13)
s.s.w.c.SecurityContextPersistenceFilter : Set SecurityContextHolder to empty SecurityContext
o.s.security.web.FilterChainProxy        : Invoking HeaderWriterFilter (4/13)
o.s.security.web.FilterChainProxy        : Invoking CorsFilter (5/13)
o.s.security.web.FilterChainProxy        : Invoking LogoutFilter (6/13)
o.s.s.w.a.logout.LogoutFilter            : Did not match request to Or [Ant [pattern='/logout', GET], Ant [pattern='/logout', POST], Ant [pattern='/logout', PUT], Ant [pattern='/logout', DELETE]]
o.s.security.web.FilterChainProxy        : Invoking JWTLoginFilter (7/13)
o.s.security.web.FilterChainProxy        : Invoking TokenCheckFilter (8/13)
org.zerock.b2.filter.TokenCheckFilter    : [TokenCheckFilter: doFilterInternal]
org.zerock.b2.filter.TokenCheckFilter    : ExpiredJwtException----------------------
o.s.s.w.header.writers.HstsHeaderWriter  : Not injecting HSTS header since it did not match request to [Is Secure]
s.s.w.c.SecurityContextPersistenceFilter : Cleared SecurityContextHolder to complete request
```