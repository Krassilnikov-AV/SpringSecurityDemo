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
STEP_4 - авторизация пользователя на основании ролей.</p>
На данном шаге предоставим доступ user для чтения и admin для чтения и записи.</p>
STEP_5 - авторизация пользователя на основании прав (autorities)</p>
STEP_6 - использование аннотации @PreAuthorization</p></p></p></p>
