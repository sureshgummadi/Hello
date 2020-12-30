package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application-test.properties")
class Junit111ApplicationTests {
	@Autowired
	private MockMvc mockmvc;
	@Test
	public void testProductSave()throws Exception {
		MvcResult result= mockmvc.perform(post("/product/register")
				.contentType(MediaType.APPLICATION_JSON).content("{\"prodCode\":\"ABCD\",\"prodCost\":88.55,\"vendorCode\": \"V11\"}")).andReturn();
		MockHttpServletResponse resp=result.getResponse();
		assertEquals(HttpStatus.OK.value(), resp.getStatus());
		 System.out.println(resp.getContentAsString());
		 assertNotNull(resp.getContentAsString());
	}
	@Test
	public void testProductSave_Faliure()throws Exception {
		MvcResult result= mockmvc.perform(post("/product/register")
				.contentType(MediaType.APPLICATION_JSON).content("{}")).andReturn();
		MockHttpServletResponse resp=result.getResponse();
		assertEquals(HttpStatus.CONFLICT.value(), resp.getStatus());
		 System.out.println(resp.getContentAsString());
		 assertNotNull(resp.getContentAsString());
	}
	@Test
	public void testProductPut()throws Exception {
		MvcResult result= mockmvc.perform(put("/product/edit")
				.contentType(MediaType.APPLICATION_JSON).content("{\"prodId\":1,\"prodCode\":\"ABCD\",\"prodCost\":35.55,\"vendorCode\": \"V11\"}")).andReturn();
		MockHttpServletResponse resp=result.getResponse();
		assertEquals(HttpStatus.OK.value(), resp.getStatus());
		 System.out.println(resp.getContentAsString());
		 assertNotNull(resp.getContentAsString());
	}
	
	@Test
	public void testProductGet()throws Exception {
		MvcResult result= mockmvc.perform(get("/product/get/3")).andReturn();
		MockHttpServletResponse resp=result.getResponse();
		assertEquals(HttpStatus.OK.value(), resp.getStatus());
		System.out.println(resp.getContentAsString());
		assertNotNull(resp.getContentAsString());
	}
	
	@Test
	public void testProductDelete()throws Exception {
		MvcResult result= mockmvc.perform(delete("/product/delete/4")).andReturn();
		MockHttpServletResponse resp=result.getResponse();
		assertEquals(HttpStatus.OK.value(), resp.getStatus());
		System.out.println(resp.getContentAsString());
		assertNotNull(resp.getContentAsString());
	}
	
	@Test
	public void testProductgetAll()throws Exception {
		MvcResult result= mockmvc.perform(get("/product/all")).andReturn();
		MockHttpServletResponse resp=result.getResponse();
		assertEquals(HttpStatus.OK.value(), resp.getStatus());
		System.out.print(resp.getContentAsString()+"/n");
		assertNotNull(resp.getContentAsString());
	}
}
