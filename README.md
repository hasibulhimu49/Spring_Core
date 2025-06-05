# 🌿 Spring Core – Complete Notes & Practice

> **Based on YouTube tutorial:** *Completing My Database Application using Spring ORM* by **Learn With Durgesh** (Hindi)

These notes consolidate every core concept you covered in the video series—Dependency Injection, IoC, Bean Lifecycle, Autowiring, SpEL, Java Config, and more—into a single, polished README ready for your GitHub repository.

---

## 📑 Table of Contents

1. [Module Map](#module-map)
2. [Dependency Injection & IoC](#dependency-injection--ioc)
3. [Spring Core Architecture](#spring-core-architecture)
4. [IoC Container Responsibilities](#ioc-container-responsibilities)
5. [Types of Dependency Injection](#types-of-dependency-injection)
6. [Required Maven Dependencies](#required-maven-dependencies)
7. [Bean Configuration Techniques](#bean-configuration-techniques)
8. [Injecting Collections](#injecting-collections)
9. [Object Reference Injection](#object-reference-injection)
10. [Constructor Injection & Ambiguity](#constructor-injection--ambiguity)
11. [Bean Lifecycle Overview](#bean-lifecycle-overview)
12. [Lifecycle via XML](#lifecycle-via-xml)
13. [Lifecycle via Interfaces](#lifecycle-via-interfaces)
14. [Lifecycle via Annotations](#lifecycle-via-annotations)
15. [Autowiring Overview](#autowiring-overview)
16. [Autowiring via XML](#autowiring-via-xml)
17. [@Autowired & @Qualifier](#autowired--qualifier)
18. [Standalone Collections](#standalone-collections)
19. [Stereotype Annotations](#stereotype-annotations)
20. [@Value with Collections](#value-with-collections)
21. [Bean Scopes](#bean-scopes)
22. [Spring Expression Language (SpEL)](#spring-expression-language-spel)
23. [Static Methods & Object Creation in SpEL](#static-methods--object-creation-in-spel)
24. [Boolean Logic in SpEL](#boolean-logic-in-spel)
25. [Java Config (Zero XML)](#java-config-zero-xml)
26. [Property Source & Profiles](#property-source--profiles)
27. [Project Structure Suggestion](#project-structure-suggestion)
28. [License](#license)

---

## Module Map

```text
0. Spring Core
   ├─ spring-core
   ├─ spring-beans
   ├─ spring-context
   └─ spring-expression (SpEL)

1. Spring Data Integration
   ├─ spring-jdbc
   └─ spring-orm

2. Spring Web
   └─ spring-mvc
```

---

## Dependency Injection & IoC

* **IoC (Inversion of Control):** Object creation & wiring are delegated to the Spring container.
* **DI (Dependency Injection):** Technique the container uses to supply an object’s dependencies.

---

## Spring Core Architecture

| Layer            | Key JARs / Topics                                                    |
| ---------------- | -------------------------------------------------------------------- |
| Core             | `spring-core`, `spring-beans`, `spring-context`, `spring-expression` |
| AOP & Instrument | `spring-aop`, `spring-aspects`, `spring-instrument`                  |
| Messaging        | `spring-messaging`, `spring-jms`                                     |
| Data Access      | `spring-jdbc`, `spring-orm`, `spring-oxm`                            |

---

## IoC Container Responsibilities

1. **Instantiate** beans.
2. **Maintain** bean lifecycles & scopes.
3. **Inject** dependencies (primitives, collections, references).

> *Primary interfaces:* `BeanFactory` (basic) and `ApplicationContext` (enterprise‑ready).

---

## Types of Dependency Injection

| Type           | XML Tag / Annotation Example                    |
| -------------- | ----------------------------------------------- |
| Setter         | `<property name="age" value="25"/>` / `@Setter` |
| Constructor    | `<constructor-arg value="25"/>` / `@Autowired`  |
| Collection     | `<list> … </list>` / `@Value("#{listBean}")`    |
| Reference Bean | `<property ref="addressBean"/>` / `@Autowired`  |

---

## Required Maven Dependencies

```xml
<!-- pom.xml -->
<dependencies>
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>5.3.30</version>
  </dependency>
  <!-- Add JDBC / ORM / Web as needed -->
</dependencies>
```

---

## Bean Configuration Techniques

1. **XML** (`beans.xml`)
2. **Java** (`@Configuration`, `@Bean`, `@ComponentScan`)
3. **p‑namespace** (compact XML attribute style)

---

## Injecting Collections

```xml
<property name="emails">
  <list>
    <value>boss@example.com</value>
    <value>info@example.com</value>
  </list>
</property>
```

```java
@Value("#{${app.supportedLocales}}")
private List<String> locales;
```

---

## Object Reference Injection

`A` (dependent) ← `B` (dependency)

```xml
<bean id="b" class="com.example.B"/>
<bean id="a" class="com.example.A">
  <property name="b" ref="b"/>
</bean>
```

---

## Constructor Injection & Ambiguity

* Ambiguity resolved using `index`, `type`, or `@Qualifier`.

```xml
<constructor-arg index="0" value="42"/>
```

---

## Bean Lifecycle Overview

1. **Instantiation**
2. **Populate properties**
3. **BeanPostProcessors** `postProcessBeforeInitialization`
4. **Custom `init()` / `@PostConstruct`**
5. **Ready for use**
6. **Destroy callbacks** (`@PreDestroy`, `destroy-method`)

---

### Lifecycle via XML

```xml
<bean id="student"
      class="com.example.Student"
      init-method="start"
      destroy-method="end"/>
```

### Lifecycle via Interfaces

```java
public class Student implements InitializingBean, DisposableBean {
  public void afterPropertiesSet() { /* init */ }
  public void destroy()          { /* cleanup */ }
}
```

### Lifecycle via Annotations

```java
@PostConstruct
public void init() {}

@PreDestroy
public void cleanup() {}
```

---

## Autowiring Overview

| XML Value     | Description              |
| ------------- | ------------------------ |
| `no`          | Manual wiring            |
| `byName`      | Match bean ID            |
| `byType`      | Match bean class         |
| `constructor` | Autowire via constructor |

---

## Autowiring via XML

```xml
<bean id="serviceA" class="com.example.ServiceA" autowire="byType"/>
```

---

## @Autowired & @Qualifier

```java
@Autowired
@Qualifier("serviceB")
private Service service;
```

---

## Standalone Collections

Use utility beans (e.g., `<util:list>` in XML) or define in Java config.

---

## Stereotype Annotations

* `@Component` (generic)
* `@Service`, `@Repository`, `@Controller` (specialized)

Enable scanning:

```java
@Configuration
@ComponentScan("com.example")
class AppConfig {}
```

---

## @Value with Collections

```java
@Value("#{'ADMIN,USER,GUEST'.split(',')}")
private List<String> roles;
```

---

## Bean Scopes

| Scope           | Usage Context                        |
| --------------- | ------------------------------------ |
| `singleton`     | One instance per container (default) |
| `prototype`     | New instance per request             |
| `request`       | One per HTTP request                 |
| `session`       | One per HTTP session                 |
| `globalsession` | Portlet global session               |

```java
@Scope("prototype")
```

---

## Spring Expression Language (SpEL)

```java
@Value("#{22 + 11}")       // Arithmetic
@Value("#{T(Math).sqrt(64)}") // Static method
@Value("#{new java.util.Date()}")
```

---

### Static Methods & Object Creation in SpEL

```java
@Value("#{T(java.lang.Math).random()}")
@Value("#{new com.example.MyClass('arg')}")
```

---

### Boolean Logic in SpEL

```java
@Value("#{84 > 50}")
private Boolean isActive;
```

---

## Java Config (Zero XML)

```java
@Configuration
@ComponentScan("com.example")
public class AppConfig {
  @Bean
  public Student student() {
     return new Student();
  }
}
```

---

## Property Source & Profiles

```java
@PropertySource("classpath:application.properties")
@Profile("dev")
class DevConfig {}
```

Access values:

```java
@Autowired
Environment env;
String url = env.getProperty("db.url");
```

---

## Project Structure Suggestion

```text
spring-core-notes/
 ├─ src/
 │   └─ main/java/com/example/…
 ├─ resources/
 │   ├─ beans.xml
 │   └─ application.properties
 ├─ pom.xml
 └─ README.md (you are here)
```

---

## License

This project is licensed under the **MIT License**.

> Feel free to fork, star ⭐, and contribute. Happy Spring learning!
