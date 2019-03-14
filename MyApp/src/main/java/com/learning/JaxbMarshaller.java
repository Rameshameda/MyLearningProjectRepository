package com.learning;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.learning.bean.EmploayeeBean;

public class JaxbMarshaller {
	
	public static void main(String[] args) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(EmploayeeBean.class);
		Marshaller marshaller =  context.createMarshaller();
		StringWriter writer = new StringWriter();

		EmploayeeBean bean =new EmploayeeBean();
		bean.setFirstName("srilakshmi");
		bean.setMiddleName("Nagesh");
		bean.setLastName("bysani");
		bean.setId(1);
		marshaller.marshal(bean, writer);
		System.out.println(writer);
		
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><emploayeeBean><firstName>ramesh</firstName><EmployeeID>1</EmployeeID><lastName>bysani</lastName></emploayeeBean>\r\n";
		Unmarshaller unmarshaller =  context.createUnmarshaller();
		bean = (EmploayeeBean) unmarshaller.unmarshal(new StringReader(xml));
		System.out.println(bean);
	}

}
