package com.yang.girl.controller;

import com.yang.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableConfigurationProperties(GirlProperties.class)
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

/*    @RequestMapping(value = "/hello/{id}",method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer id) {
        return "id: "+id;
//        return girlProperties.getCupSize();
    }*/

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    //@GetMapping  @PostMapping
    public String say() {
        //say(@RequestParam("id") Integer id)
       // return "id: "+id;
        return girlProperties.getCupSize();
    }
}
