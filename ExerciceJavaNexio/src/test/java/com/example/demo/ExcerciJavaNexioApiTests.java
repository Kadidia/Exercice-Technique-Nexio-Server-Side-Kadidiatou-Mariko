package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.model.Product;
import com.example.demo.model.UserAuthentification;

public class ExcerciJavaNexioApiTests extends ExerciceJavaNexioApplicationTests{
	@Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	
	/*testing get product list API : 
	 * 	-- response status should be 200
	 *  -- API should return an array of products*/
	@Test
	public void whenGetRequest_ThenReturnProductsList() throws Exception {
		//when
	   String uri = "/products";
	   
	   //Given
	   MvcResult mvcResult = dataMvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();	   
	   int status = mvcResult.getResponse().getStatus();
	   
	   //Then
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   Product[] productlist = super.ConvertFromJson(content, Product[].class);
	   assertTrue(productlist.length > 0);
	}
	
	/*testing get product Detail API : 
	 * 	-- response status should be 200
	 *  -- API should return a product */
	@Test
	public void WhenIdExist_ThenReturnProduct() throws Exception {
	
	   //When
	   String uri = "/productdetail/1";
	   
	   //Given
	   MvcResult mvcResult = dataMvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   
	   //Then
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   Product product = super.ConvertFromJson(content, Product.class);
	   assertTrue(product.getId() == 1);
	}
	
	/*testing get product Detail API : 
	 * 	-- response status should be 200
	 *  -- API should return true  */
	@Test
	public void WhenIdExist_ThenAddProductToCart() throws Exception {
		
	   //When
	   String uri = "/products/addtocart/3";
	   
	   //Given
	   MvcResult mvcResult = dataMvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   
	   //Then
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   assertTrue(content.equals("true"));
	}
	
	/*testing get product Detail API : 
	 * 	-- response status should be 200
	 *  -- API should return a false because product with id 102 does not exist */
	@Test
	public void WhenIdNotExist_ThenReturnFalse() throws Exception {
		//When
	   String uri = "/products/addtocart/102";
	   
	   //Given
	   MvcResult mvcResult = dataMvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();	   
	   int status = mvcResult.getResponse().getStatus();
	   
	   //Then
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   assertTrue(content.equals("false"));
	}
	
	/*testing get product Detail API : 
	 * 	-- response status should be 200
	 *  -- API should return true  */
	@Test
	public void WhenIdExist_ThenDeleteProductFromCart() throws Exception {
	   String uri = "/products/deletefromcart/1";
	   MvcResult mvcResult = dataMvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   assertTrue(content.equals("true"));
	}
	
	/*testing userAuthentification API : 
	 * 	-- response status should be 200
	 *  -- API should return true : user nexio exist */
	@Test
	public void WhenLoginPasswordExist_ThenReturnTrue_Post_Request() throws Exception {
		
		//When
	   String uri = "/user/authentification";
	   UserAuthentification userAuth = new UserAuthentification();
	   userAuth.setLogin("nexio");
	   userAuth.setPassword("nexio");
	   String formatJson = super.convertToJson(userAuth);
	   
	   //Given	   
	   MvcResult mvcResult = dataMvc.perform(MockMvcRequestBuilders.post(uri)
			      .contentType(MediaType.APPLICATION_JSON_VALUE).content(formatJson)).andReturn();			   
	   int status = mvcResult.getResponse().getStatus();
	   
	   //Then
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   assertTrue(content.equals("true"));
	}
	
	/*testing userAuthentification API : 
	 * 	-- response status should be 200
	 *  -- API should return false : user SprinBoot does not exist */
	@Test
	public void WhenLoginPasswordNotExist_ThenReturnTrue_Post_Request() throws Exception {
		//When
	   String uri = "/user/authentification";
	   UserAuthentification userAuth = new UserAuthentification();
	   userAuth.setLogin("SprinBoot");
	   userAuth.setPassword("SprinBoot");
	   String formatJson = super.convertToJson(userAuth);
	   
	   //Given
	   MvcResult mvcResult = dataMvc.perform(MockMvcRequestBuilders.post(uri)
			      .contentType(MediaType.APPLICATION_JSON_VALUE).content(formatJson)).andReturn();			   
	   int status = mvcResult.getResponse().getStatus();
	   
	   //Then
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   assertTrue(content.equals("false"));
	}

}
