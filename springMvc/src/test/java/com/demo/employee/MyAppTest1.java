package com.demo.employee;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.servlet.ServletContext;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@WebAppConfiguration(value = "src/main/java")
public class MyAppTest1 {
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext wac;
	@Before
	public void initMockMVC() {
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

	}
	@org.junit.Test
	public void test() {
		 ServletContext servletContext = wac.getServletContext();
	     
		    assertNotNull(servletContext);
		    assertTrue(servletContext instanceof MockServletContext);
		    assertNotNull(wac.getBean("ManageEmployee"));
	}



}
