File Upload 

(1) 설정 
    1) pom.xml
		<!-- commons-fileupload -->
		<dependency>
			<groupId>commons-fileupload</groupId>
			<artifactId>commons-fileupload</artifactId>
			<version>1.2.1</version> 
		</dependency>
		<dependency>
			<groupId>commons-io</groupId>
			<artifactId>commons-io</artifactId>
			<version>2.5</version>
		</dependency>
	2) servlet-context.xml
		<!-- 파일 업로드용 resolver -->
		<beans:bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
			<beans:property name="defaultEncoding" value="UTF-8" />
			<beans:property name="maxUploadSize" value="10485760" />
			<beans:property name="maxUploadSizePerFile" value="2097152"/>
			<beans:property name="maxInMemorySize" value="10485756"/>
		</beans:bean>

(2) index.jsp 
(3) form.jsp 
(4) FileController.java
(5) FileUploadService.java
    FileUploadServiceImpl.java 
    Path.java 
(6) list.jsp 
(7) FileDownloadView.java
(8) servlet-context.xml 
    <!-- 파일 다운로드 -->
	<beans:bean id="fileDownloadView" class="soo.md.filesetting.FileDownloadView" />
	<beans:bean id="fileViewResolver" class="org.springframework.web.servlet.view.BeanNameViewResolver">
	    <beans:property name="order" value="0" />
	</beans:bean>
(9) form_mt.jsp 
(10) FileController.java
