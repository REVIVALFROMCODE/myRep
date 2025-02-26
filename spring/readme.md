These bean definitions correspond to the actual objects that make up your application. Typically, you define service layer objects, persistence layer objects such as repositories or data access objects (DAOs), presentation objects such as Web controllers, infrastructure objects such as a JPA EntityManagerFactory, JMS queues, and so forth. Typically, one does not configure fine-grained domain objects in the container, because it is usually the responsibility of repositories and business logic to create and load domain objects.
这些bean定义对应于组成应用程序的实际对象。通常，您要定义服务层对象、持久层对象（如存储库或数据访问对象（DAO））、表示对象（如Web控制器）、基础结构对象（如JPAEntityManagerFactory）、JMS队列等。通常，不会在容器中配置细粒度的域对象，因为创建和加载域对象通常是存储库和业务逻辑的责任。


https://docs.spring.io/spring-framework/reference/core/beans/basics.html


