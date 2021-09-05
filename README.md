# SpringSecurityDemo
STEP_1 - оздание базового проекта</p>
1. генерация Spring с необходимыми зависимостями</p>
2. Проверка работоспособности с помщью запуска через браузер localhost:8080 c выводом ошибочной страницы</p>
![step1_0](https://user-images.githubusercontent.com/61631173/132098069-64279563-8267-4138-a3e8-68ee7b2fcd41.JPG)
</p>
3. создание пакета model с классом Developer </p>
-  Developer - сущность с аннотациями, позволяющими создание конструктора и гетерров с сеттерами</p>
4. создание пакета rest с калссом DeveloperRestControllerV1</p>
- DeveloperRestControllerV1 - класс, в котором созданы следующие методы:</p>
   - создание коллекции в качестве данных, содержащей разработчиков   </p>
   - public List<Developer> getall() - возвращает список разработчиков</p>
   - public Developer getById(Long id)</p>
  проверка вывода в браузере занесённых данных</p></p>
  
  ![step1_1](https://user-images.githubusercontent.com/61631173/132098142-c079f0fe-9329-45a9-930d-7476b7a7fe1f.JPG)</p></p>
  
![step1_2](https://user-images.githubusercontent.com/61631173/132098145-3538d2b7-c588-4ed6-a749-47870f83bfca.JPG)</p>

</p>
STEP_2 - интеграция Spring Security. Базовая аутентификация.</p>

1. добавление зависимости spring-boot-starter-security</p>

![step2_0](https://user-images.githubusercontent.com/61631173/132099310-eae84745-afcd-40cb-a0ab-2d81480121d4.JPG)</p>

3. перезапуск приложения</p>
4. запуск -> перенаправление на страницу логина</p>

![step2_1](https://user-images.githubusercontent.com/61631173/132099338-2076d4bc-025b-45af-99ac-c314263f634a.JPG)
</p>
5. логин по умолчанию "user"</p>
7. пароль генерируется при запуске приложения</p>

![step2_2](https://user-images.githubusercontent.com/61631173/132099367-eedb47f4-a2f1-4945-975d-1d15f919bb2c.JPG)

![step2_3](https://user-images.githubusercontent.com/61631173/132099376-efac15bd-5ea1-46f8-842d-29e200cb78f0.JPG)

![step2_4](https://user-images.githubusercontent.com/61631173/132099379-2aac2a90-e637-4e94-9673-91c6125a974c.JPG)

</p>
STEP_3 - на данном шаге приложения используется UserDetailsService (in memory).</p>
Для жизненных ситуаций необходимо разные имена пользователей и паролей</p>
Для этоко необходимо сконфтгурировать Spring Security:</p>
1. создание пакета "config"</p>
2. создание класса SecurityConfig наследника WebSecurityConfigurerAdapter </p>
3. переопределение методов </p>
   - protected void configure(HttpSecurity http) throws Exception </p>
 - и создание Бина из перерпределенного метода protected UserDetailsService userDetailsService() для задания имени пользователя и пароля/</p>
4. После перезапуска можно вводить имя и пароль admin</p>
STEP_4 - авторизация пользователя на основании ролей.</p>
На данном шаге пройдёт реализация доступа по ролям.Т.е. будет доступ для чтения и другая для чтения и записи. </p>
1. В классе-контроллере  public class DeveloperRestControllerV1 появятся методы для добавления нового разработчика в коллекцию public Developer create(@RequestBody Developer developer) и удаления разработчика public void deleteById(@PathVariable Long id). </p>
2. Для представления конкретных ролей, добавляется сама сущность в качестве enum Role с добавлением ролей.
 </p>
3. для разграничения доступа ролей реализуем кастумную реализацию http в методе config класса SecurityConfig будет собственная реализация: </p>
1) http запрос нужно авторизовать с указанием доступа кого угодно <em>[ .authorizeRequests().antMatchers("/").permitAll() ] </em></p>
2) в ресурсах создание страницы index.html </p>
3) следующий паттерн antMatchers, который связан уже с api, т.е. то что связано с api, пойдёт с определёнными ролями <em>[ .antMatchers(HttpMethod.GET, "/api/**").hasAnyRole(Role.ADMIN.name(), Role.USER.name()) ]</em>, по аналогии так же пишется на метод POST и DELETE только с hasRole
<em>[ .antMatchers(HttpMethod.POST, "/api/**").hasRole(Role.ADMIN.name())
  .antMatchers(HttpMethod.DELETE, "/api/**").hasRole(Role.ADMIN.name()) ]</em> </p>
4) Так же нужно сказать что каждый запрос должен быть аутентифицирован <em>[ .anyRequest().authenticated() ] </em></p>
5) и хочу использовать httpBasic <em>[ .and().httpBasic() ]</em> </p>
6) Так же не забыть добавить механизм защиты от csrf угрозы <em>[ .csrf().disable() ]</em> предусмотрен Spring Security по умолчанию..</p>
STEP_5 - авторизация пользователя на основании прав (autorities)</p>

предоставление доступа по ролям удобен, но не достаточно гибок такой способ.</p>
Используется понятие permishen,это когда можно осздавать роли и к каждой роли давать определённые права.</p>
В таком случае получаем более гибкий контроль над секьюрностью приложения.</p>
На данном шаге:</p>
1. Создадим новую сущность Permission...</p>
STEP_6 - использование аннотации @PreAuthorization</p>
Имеется другой способ для разграничения доступа - <em><strong>@PreAuthorization<strong></em>.</p>
Т.е.писать antMatchers-ы не совсемп удобно, может разрастись на многие сотни строк. Для избежания такой проблемы можно обрабатывать на уровне самого контроллера.</p></p>
