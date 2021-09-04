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
  проверка вывода в браузере занесённых данных</p>
  ![step1_1](https://user-images.githubusercontent.com/61631173/132098142-c079f0fe-9329-45a9-930d-7476b7a7fe1f.JPG)</p>
![step1_2](https://user-images.githubusercontent.com/61631173/132098145-3538d2b7-c588-4ed6-a749-47870f83bfca.JPG)</p>

</p>
STEP_2 - интеграция Spring Security. Базовая аутентификация.</p>
STEP_3 - на данном шаге приложения используется UserDetailsService (in memory).</p>
STEP_4 - авторизация пользователя на основании ролей.</p>
На данном шаге предоставим доступ user для чтения и admin для чтения и записи.</p>
STEP_5 - авторизация пользователя на основании прав (autorities)</p>
STEP_6 - использование аннотации @PreAuthorization</p></p></p></p>
