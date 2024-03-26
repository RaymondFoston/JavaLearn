package com.company.springmvc.cortoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FouthController {
    /**
     * rest风格
     * @return
     */

    @RequestMapping(value = "/book/", method = RequestMethod.POST)
    public String addBook(){
        System.out.println("The "+"book"+" is added!");
        return "success";
    }

    @RequestMapping(value = "/book/{bid}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("bid") Integer bid){
        System.out.println("The "+bid+" is deleted!");
        return "success";
    }

    @RequestMapping(value = "/book/{bid}", method = RequestMethod.PUT)
    public String updateBook(@PathVariable("bid") Integer bid){
        System.out.println("The "+bid+" is updated!");
        return "success";
    }

    @RequestMapping(value = "/book/{bid}", method = RequestMethod.GET)
    public String getBook(@PathVariable("bid") Integer bid){
        System.out.println("The "+bid+" is finded!");
        return "success";

    }
}
