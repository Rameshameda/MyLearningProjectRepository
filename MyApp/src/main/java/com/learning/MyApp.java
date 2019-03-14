package com.learning;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.learning.bean.EmploayeeBean;
import com.learning.bean.UserBean;
@ApplicationPath("newway")
@Path("/welcome")
public class MyApp extends Application{
	@GET
	@Path("/welcomemsg")
	@Produces(MediaType.TEXT_HTML)
	public String getMsg() {
		return "welcome to matrix";
	}
	@GET
	@Path("/goodbyemsg")
	@Produces(MediaType.TEXT_HTML)
	public String myMSg() {
		return "bye bey from matrix";

	}		
	@Path("/getempxml")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getEmployee() {
		System.out.println("hit here");

		EmploayeeBean bean =new EmploayeeBean();
		bean.setFirstName("srilakshmi");
		bean.setMiddleName("Nagesh");
		bean.setLastName("bysani");
		bean.setId(1);

		ArrayList<String> hobbyList = new ArrayList<String>(); 
		hobbyList.add("tik tok");
		hobbyList.add("face Book"); 
		hobbyList.add("whatsapp");
		bean.setHobbies(hobbyList);
		CacheControl cacheControl = new CacheControl();
		cacheControl.setMaxAge(80000);
		cacheControl.setPrivate(true);
		ResponseBuilder builder = Response.status(200);
		builder.cacheControl(cacheControl);
		builder.entity(bean);
		return builder.build();
		//return bean;

	}
	@Path("/getempjson")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public EmploayeeBean getEmployeeJSON() {
		EmploayeeBean bean =new EmploayeeBean();
		bean.setFirstName("$#");
		bean.setMiddleName("Nagesh");
		bean.setLastName("bysani");
		bean.setId(1);

		ArrayList<String> hobbyList = new ArrayList<String>();
		hobbyList.add("tik tok");
		hobbyList.add("face Book");
		hobbyList.add("whatsapp");
		bean.setHobbies(hobbyList);

		return bean;

	}

	@GET
	@Path("/pathparam/{id}")
	public Response updateEmployee(@PathParam("id") String id) {
		return Response.status(200).entity("path param is :"+id).build();
	}

	@GET
	@Path("/matrixparam")
	public Response getMAtrixparam(@MatrixParam("myparam") String value,@HeaderParam("user-agent") String agent) {
		return Response.status(200).entity("matrix param is :"+value+"\n user agent"+agent).build();
	}
	@GET
	@Path("queryparam")
	public Response queryParam(@QueryParam("param1") String param1,@QueryParam("param2") String param2,@Context HttpServletRequest request ) {

		return Response.status(200).entity("queryparam1 : "+param1+"\nquery :"+request.getQueryString()).build();
	}
	@POST
	@Path("/postreq")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response formParam(@FormParam("username") String Username,@FormParam("password") String password) {
		return Response.status(200).entity("usr name:"+Username+"\npassword:"+password).build();
	}
	@Path("/beanparam")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response beanParam(@BeanParam UserBean userBean ) {
		return Response.status(200).entity("usr name:"+userBean.getUsername()+"\npassword:"+userBean.getPassword()+"\nuseragent:"+userBean.getEmailAddress()).build();
	}
	@GET
	@Path("/getpdf")
	@Produces(MediaType.MULTIPART_FORM_DATA)
	public Response getPDFFile() {
		File file = new File("C:\\Users\\rameshacp12429\\Downloads\\pdf-to-word.docx");
		ResponseBuilder builder = Response.status(200).entity(file);
		builder.header("Content-Disposition", "attachment; filename=mydoc.docx");
		return builder.build();
	}
	@POST
	@Path("/comsumeExample")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_XML)
	public EmploayeeBean comsumeExample(EmploayeeBean bean) {
		return bean;

	}
	@GET
	@Path("/basicauth")
	public Response authizeuser(@HeaderParam("Authorization") String auth) {
		System.out.println(auth);

		byte[] decodedBytes = Base64.getDecoder().decode(auth.replace("Basic ", ""));
		try {
			return Response.status(200).entity("auth : "+new String(decodedBytes, "UTF-8")).build();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
}
