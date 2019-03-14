package com.test;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style=Style.RPC)
public interface SayPapaya {
	String sayPapaya(String fName);
	String sayPotato(String fName);
}
