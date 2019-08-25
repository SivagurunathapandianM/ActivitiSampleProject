package com.example.ActivitiDemo;


import org.activiti.engine.RuntimeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Hello world!
 *
 */
@SpringBootApplication
public class ActivitiDemoAppilication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(ActivitiDemoAppilication.class, args);
    }
    @RestController
    public static class MyrestController
    {
    	@Autowired
    	private RuntimeService runtimeService;
    	
    	@RequestMapping(value = "/start-my-process", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
    	public void starmyprocess()
    	{
    		runtimeService.startProcessInstanceByKey("process");
    		System.out.println("We have now "+runtimeService.createProcessInstanceQuery().count()+ "Process instance" );
    	}
    }
}

// Works like this
// HTTP Request --> By using SpringBOOT, Activti BPM (XML) has been hosted via localhost (MICROSERVICE Architecture)
