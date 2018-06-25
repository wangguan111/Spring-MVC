# Spring-MVC
learn and pratice the book &lt;&lt;Spring MVC: A Tutorial (Second Edition)>>

Chapter 1: The Spring Framework

	1.1 xml
	
	1.2 getBean by conctuctor or property


Chapter 2: Model 2 and the MVC Pattern

	2.1-2.2 introduce

	2.3 servlet mvc

		url:http://localhost:8080/appdesign1/input-product

			Action-SaveProductAction
			Controler(Servlet)-ControllerServlet
			View(Form)-ProductForm
			Model(javabean)-Product

	2.4 filter mvc

		url:http://localhost:8080/appdesign2/input-product

			Action-***
			Controler(Filter)-DispatcherFilter
			View(Form)-***
			Model(javabean)-***

	2.5 servlet + validate mvc

		url:http://localhost:8080/appdesign3/input-product

			Action-***
			Controler(Servlet)-ControllerServlet
			View(Form)-***
			Model(javabean)-***
			Validator-ProductValidator

	2.6 inject

		url:http://localhost:8080/appdesign4/form

			Action-PDFAction
			Service-PDFService
			Control(Servlet)-ControllerServlet
			util-PDFUtil


Chapter 3: Introduction to Spring MVC

	3.1 - 3.3 introduce

	3.4 demo

		url:http://localhost:8080/springmvc-intro1/input-product

		1.web.xml                      <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		2.springmvc-servlet.xml         <bean name="/input-product" class="controller.InputProductController"/>
		3.handleRequest
		4.ModelAndView

			Controller-InputProductController 
					  -SaveProductController
			View(Form)-ProductForm
			Model(javabean)-Product		  

	3.5  view resolver

		url:http://localhost:8080/springmvc-intro2/input-product
	
		1.springmvc-config.xml
		<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver"> prefix suffix   
		2.web.xml   <param-name>contextConfigLocation</param-name>

			Controller-*** 
					  -***
			View(Form)-***
			Model(javabean)-***	


Chapter 4: Annotation-Based Controllers

	4.1 Controller and RequestMapping Annotation

	4.2 deal with request

	4.3 demo

		url:http://localhost:8080/annotated1/input-product

		1.component-scan
		2.Controller
		3.RequestMapping value method
		4.Model addAttribute

	4.4 @Autowired and @Service

		url:http://localhost:8080/annotated2/input-product

		1.@Autowired
		2.RedirectAttributes addFlashAttribute
		3.@PathVariable

	4.5 RedirectAttributes

	4.6 @PathVariable @RequestParam

	4.7 @ModeAttribute


Chapter 5: Data Binding and the Form Tag Library

	5.1 Data Binding

	5.2 the Form Tag

	5.3 demo

		url:http://localhost:8080/tags-demo/list-books


Chapter 6: Converters and Formatters

	6.1 Converters demo

		url:http://localhost:8080/converter-demo/add-employee

		1.org.springframework.context.support.ConversionServiceFactoryBean

	6.2 Formatters demo

		url:http://localhost:8080/formatter-demo/add-employee

		1.org.springframework.format.support.FormattingConversionServiceFactoryBean

	6.3 Registrar


Chapter 7: Validators

	7.1 order: formatter->validator

	7.2 -7.7 spring-validator demo

		url:http://localhost:8080/spring-validator/add-product

		1.org.springframework.validation.Validator
		2.org.springframework.context.support.ReloadableResourceBundleMessageSource
		3.org.springframework.validation.ValidationUtils
		4.org.springframework.validation.Errors
		5.message.properties

	7.8 - 7.9 JSR303-validator demo

		url:http://localhost:8080/jsr303-validator/add-product

		1.ConstraintHelper
		2.PastValidatorForTemporal
		3. @Size  @Past @Valid


Chapter 8: The Expression Language


Chapter 9: JSTL


Chapter 10: Internationalization

	10.1 - 10.2 ResourceBundle

		1.ResourceBundle

	10.3 -10.6 AcceptHeaderLocaleResolver demo

		url:http://localhost:8080/il8n/add-product

		1.org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver
		2.accept-language


Chapter 11: File Upload

	10.1 - 11.2 introduce

	10.3 - 10.8 commons fileupload demo

		url:http://localhost:8080/upload1/input-product

		1.MultipartFile
		2.commons-fileupload-1.3.1
		3.org.springframework.web.multipart.commons.CommonsMultipartResolver

	10.9 - 11.10 servlet3 demo

		url:http://localhost:8080/upload2/input-product

		1.multipart-config
		2.org.springframework.web.multipart.support.StandardServletMultipartResolver
		3.@NotNull
		4.Html5FileUploadController


Chapter 12: File Download

	12.1 - 12.3 download demo

		url:http://localhost:8080/download/image.html

		1.@RequestHeader


Chapter 13: Testing Your Application

	13.1 - 13.3 Unit-test demo

		1.junit
		2.@Before  @After @Test
		3.@RunWith @SuiteClasses

	13.4 test doubles

		1.mockito
		2.dummy stub spy fake mock	

	13.5 spring mvc controller unit-test 

		1.MockHttpServletRequest
		2.MockHttpServletResponse
		3.ModelAndViewAssert assertModelAttributeAvailable assertAndReturnModelAttributeOfType assertSortAndCompareListModelAttribute
		4.(a,b)->{}

	13.6 spring mvc integration-test

		1.MockMVC
		2.perform
		3.@RunWith
		4.@WebAppConfiguration
		5.@ContextConfiguration

	13.7 web-root integration-test


Appendix A: Tomcat

	1.context
	2.resource
	3.TLS


Appendix B: Using Spring Tool Suite with Maven
	1.failOnMissingWebXml


Appendix C: The Servlet API


Appendix D: JavaServer Pages


Appendix E: Deployment	