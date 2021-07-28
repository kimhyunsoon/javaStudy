1. DAO( AddressMapper ) ���� 
	(1) DS����  
		1) web.xml 
			<filter>
				<filter-name>encoding</filter-name>
				<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
				<init-param>
					<param-name>encoding</param-name>
					<param-value>UTF-8</param-value>
				</init-param>
			</filter>
			
			<filter-mapping>
				<filter-name>encoding</filter-name>
				<servlet-name>appServlet</servlet-name>
			</filter-mapping>

		2) pom.xml 
			<dependency>
				<groupId>com.oracle.ojdbc</groupId>
				<artifactId>ojdbc8</artifactId>
				<version>19.3.0.0</version>
			</dependency>
			<dependency>
				<groupId>org.springframework</groupId>
				<artifactId>spring-jdbc</artifactId>
				<version>${org.springframework-version}</version>
			</dependency>
			<dependency>
				<groupId>org.springframework</groupId>
				<artifactId>spring-tx</artifactId>
				<version>${org.springframework-version}</version>
			</dependency>
			<dependency>
				<groupId>com.zaxxer</groupId>
				<artifactId>HikariCP</artifactId>
				<version>2.7.8</version>
			</dependency>

		3) root-context.xml
		   <1> ds ���� 
			<bean id="hikariConfig" class="com.zaxxer.hikari.HikariConfig">
				<property name="driverClassName"
					value="net.sf.log4jdbc.sql.jdbcapi.DriverSpy"></property>
				<property name="jdbcUrl"
					value="jdbc:log4jdbc:oracle:thin:@localhost:1521:JAVA"></property>
				<property name="username" value="spring"></property>
				<property name="password" value="java"></property>
			</bean>
			<bean id="dataSource" class="com.zaxxer.hikari.HikariDataSource"
				destroy-method="close">
				<constructor-arg ref="hikariConfig" />
			</bean>

	(2) JDBC �α� ����
		1) pom.xml
			<dependency>
				<groupId>org.bgee.log4jdbc-log4j2</groupId>
				<artifactId>log4jdbc-log4j2-jdbc4</artifactId>
				<version>1.16</version>
			</dependency> 

		2) src/main/resources/log4jdbc.log4j2.properties 
		
	(3) myBatis ���� 
		1) pom.xml
			<dependency>
				<groupId>org.mybatis</groupId>
				<artifactId>mybatis</artifactId>
				<version>3.4.6</version>
			</dependency>
			<dependency>
				<groupId>org.mybatis</groupId>
				<artifactId>mybatis-spring</artifactId>
				<version>1.3.2</version>
			</dependency>

		2) root-context.xml
			<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
				<property name="dataSource" ref="dataSource"></property>
				<property name="configLocation"
					 value="classpath:/mybatis-config.xml"/>
			</bean>
		   
		  
		3) src/main/resources/mybatis-config.xml
			<typeAliases>
				<typeAlias alias="Address" type="soo.md.domain.Address"/>
			</typeAliases>
			<mappers>
				 <mapper resource="soo/md/mapper/AddressMapper.xml"/>
			</mappers>

		4) soo.md.domain.Address.java 
			@Data
			@NoArgsConstructor
			@AllArgsConstructor
			public class Address {
				private long seq;
				private String name;
				private String addr;
				private Date rdate;
			}
		
		5) src/main/resources/soo.md.mapper.AddressMapper.xml 
			<select id="list" resultType="Address">
				select * from ADDRESS order by SEQ desc
			</select>
			<insert id="insert" parameterType="Address">
				insert into ADDRESS values(ADDRESS_SEQ.nextval, #{name}, #{addr}, SYSDATE)
			</insert>
			<delete id="delete" parameterType="long">
				delete from ADDRESS where SEQ=#{seq}
			</delete>

		6) src/main/java/soo.md.mapper.AddressMapper.java 
			public interface AddressMapper {
				List<Address> list();
				void insert(Address address);
				void delete(long seq);
			}

		7) root-context.xml �߰�
		   <mybatis-spring:scan base-package="soo.md.mapper"/>
	       <context:component-scan base-package="soo.md.mapper"/>


	    Tip1) DAO�� Ŭ�������� @Repository ����� Spring��ü�� ��� 
        Tip2) JUnit(����) �׽�Ʈ
		     1> pom.xml 
				 <dependency>
					<groupId>junit</groupId>
					<artifactId>junit</artifactId>
					<version>4.12</version>
				 </dependency>
		     2> src/test/java/soo.md.persistence.DataSourceTests.java
			 3> src/test/java/soo.md.mapper.AddressMapperTests.java
			 4> src/test/java/AddressServiceTests.java
			    

2. Service( AddressService ) ����  
	(1) �������̽�(soo.md.service.AddressService.java) ���� 
	     public interface AddressService {
			List<Address> listS();
			void insertS(Address address);
			void deleteS(long seq);
		 }
	(2) ����Ŭ����(soo.md.service.AddressServiceImpl.java) ���� 
	     @Service
         public class AddressServiceImpl implements AddressService {
	     }

    (3) root-context.xml �߰�  	
	    <context:component-scan base-package="soo.md.service"/>


3. Controller ( AddressController ) ���� 
    1) soo.md.controller.AddressController.java 
	    @Controller
		@RequestMapping("/address/*")
		public class AddressController {
			@Autowired
			private AddressService addressService; //Object Injection 
        } 
	   

     2) servlet-context.xml ���
	    <context:component-scan base-package="soo.md.controller" />  


	   Tip) Injection ��� 
	      - Setter Injection�� �� 
			   AddressController obj = new AddressController();
               obj = this.setAddressService(addressService);

	      - Contructor Injection�� ��  
			   AddressController obj = new AddressController(addressService);

			  
4. View ( *.jsp  )
    1) list.jsp 
	2) write.jsp 
  
      Tip) EL + JSTL
     

	    
		 
	

	    
