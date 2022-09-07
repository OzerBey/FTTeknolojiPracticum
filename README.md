# Spring Boot Practicum using MongoDB

![](https://img.shields.io/badge/java-v17-green)
![](https://img.shields.io/badge/spring--boot-v2.7.2-green)
![](https://img.shields.io/badge/swagger-v3.0.0-red)

## _Spring Boot Project_

- _Java 17_
- _MongoDB_
- _Spring_ - _Boot_ - _MVC_ - _Data_ - _Rest_
<hr>

1.  [Controllers](https://github.com/OzerBey/FTTeknolojiPracticum/tree/main/src/main/java/com/ozer/ftspringpracticum/api/controllers)
2.  Business
    - [Abstracts](https://github.com/OzerBey/FTTeknolojiPracticum/tree/main/src/main/java/com/ozer/ftspringpracticum/business/abstracts)
    - [Concretes](https://github.com/OzerBey/FTTeknolojiPracticum/tree/main/src/main/java/com/ozer/ftspringpracticum/business/concretes)
3.  DataAccess
    - [Abstracts](https://github.com/OzerBey/FTTeknolojiPracticum/tree/main/src/main/java/com/ozer/ftspringpracticum/dataAccess)
4.  Entities
    - [Concretes](https://github.com/OzerBey/FTTeknolojiPracticum/tree/main/src/main/java/com/ozer/ftspringpracticum/entities/concretes)
5.  Core 
    - [Abstracts](https://github.com/OzerBey/FTTeknolojiPracticum/tree/main/src/main/java/com/ozer/ftspringpracticum/core/abstracts)

    - *Utilities*
       * [Exceptions](https://github.com/OzerBey/FTTeknolojiPracticum/tree/main/src/main/java/com/ozer/ftspringpracticum/core/utilities/exceptions)
       * [Results](https://github.com/OzerBey/FTTeknolojiPracticum/tree/main/src/main/java/com/ozer/ftspringpracticum/core/utilities/results)

     <br><hr>
     <details>
     <summary>Click for details of backend </summary><br>

         📦ftspringpracticum
         ┣ 📂api
         ┃ ┗ 📂controllers
         ┃ ┃ ┣ 📜CommentsController.java
         ┃ ┃ ┣ 📜ProductsController.java
         ┃ ┃ ┗ 📜UsersController.java
         ┣ 📂business
         ┃ ┣ 📂abstracts
         ┃ ┃ ┣ 📜CommentService.java
         ┃ ┃ ┣ 📜ProductService.java
         ┃ ┃ ┣ 📜SequenceGeneratorService.java
         ┃ ┃ ┗ 📜UserService.java
         ┃ ┗ 📂concretes
         ┃ ┃ ┣ 📜CommentManager.java
         ┃ ┃ ┣ 📜ProductManager.java
         ┃ ┃ ┗ 📜UserManager.java
         ┣ 📂core
         ┃ ┣ 📂abstracts
         ┃ ┃ ┗ 📜IEntity.java
         ┃ ┗ 📂utilities
         ┃ ┃ ┣ 📂exceptions
         ┃ ┃ ┃ ┣ 📜CommentNotFoundException.java
         ┃ ┃ ┃ ┣ 📜CustomException.java
         ┃ ┃ ┃ ┣ 📜ProductNotFoundException.java
         ┃ ┃ ┃ ┗ 📜UserNotFoundException.java
         ┃ ┃ ┗ 📂results
         ┃ ┃ ┃ ┣ 📜DataResult.java
         ┃ ┃ ┃ ┣ 📜ErrorDataResult.java
         ┃ ┃ ┃ ┣ 📜ErrorResult.java
         ┃ ┃ ┃ ┣ 📜Result.java
         ┃ ┃ ┃ ┣ 📜SuccessDataResult.java
         ┃ ┃ ┃ ┗ 📜SuccessResult.java
         ┣ 📂dataAccess
         ┃ ┣ 📜CommentDao.java
         ┃ ┣ 📜ProductDao.java
         ┃ ┗ 📜UserDao.java
         ┣ 📂entities
         ┃ ┣ 📂abstracts
         ┃ ┗ 📂concretes
         ┃ ┃ ┣ 📜Comment.java
         ┃ ┃ ┣ 📜DbSequence.java
         ┃ ┃ ┣ 📜Product.java
         ┃ ┃ ┗ 📜User.java
         ┗ 📜FtSpringPracticumApplication.java

</details>
