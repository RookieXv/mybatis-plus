# mybatis-plus
springboot集成mybatis-plus

├─src<br>
│  ├─main<br>
│  │  ├─java<br>
│  │  │  └─com<br>
│  │  │      └─example<br>
│  │  │          └─mybatisplus<br>
│  │  │              │  MybatisPlusApplication.java<br>
│  │  │              │<br>
│  │  │              ├─config<br>
│  │  │              │      SwaggerConfig.java<br>
│  │  │              │<br>
│  │  │              ├─controller<br>
│  │  │              │      StudentController.java<br>
│  │  │              │<br>
│  │  │              ├─entity<br>
│  │  │              │      Student.java<br>
│  │  │              │<br>
│  │  │              ├─mapper<br>
│  │  │              │      StudentMapper.java<br>
│  │  │              │<br>
│  │  │              └─service<br>
│  │  │                  │  IStudentService.java<br>
│  │  │                  │<br>
│  │  │                  └─impl<br>
│  │  │                          StudentServiceImpl.java<br>
│  │  │<br>
│  │  └─resources<br>
│  │      │  application.yml<br>
│  │      │<br>
│  │      ├─mapper<br>
│  │      │  └─mybatisplus<br>
│  │      │          StudentMapper.xml<br>
│  │      │<br>
│  │      ├─static<br>
│  │      └─templates<br>
│  │              controller-mine.java.ftl<br>
│  │              entity-mine.java.ftl<br>
│  │              mapper-mine.java.ftl<br>
│  │              service-mine.java.ftl<br>
│  │              serviceImpl-mine.java.ftl<br>
│  │<br>
│  └─test<br>
│      └─java<br>
│              CodeGenerator.java<br>
│              CodeGeneratorDefault.java<br>
│<br>
└─target<br>
