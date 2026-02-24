package com.kranthi.novprojectmodule;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String Hello(){
        return "Hello, I am Kranthi";
    }
    @RequestMapping(value="/hello1/{id}", method= RequestMethod.GET)
    public String Hellowithvariable(@PathVariable("id") String id){
        return "my id is"+ id;
    }

}
