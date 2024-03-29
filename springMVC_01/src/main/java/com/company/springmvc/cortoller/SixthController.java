package com.company.springmvc.cortoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@SessionAttributes(value={"msg","hah"},types ={String.class})//存放到一个数据中
@Controller
public class SixthController {
    /**
     * springMVC除过在原生的request和session外,
     * 还能使用如下方法:
     * 1. 可以在方法出传入Map, Model, ModelMap
     *     给这些参数里面的数据都会放在请求域中
     *     Map, Model, ModelMap最终都是BindingAwareModelMap在工作
     * 2. 方法的返回值可以变为ModelAndView
     *      既包含视图信息,也包含模型数据
     *      而且数据是放在请求域中
     * 3.  临时给session保存数据的方式
     *          使用一个注解:    @SessionAttributes()只能标注在类上
     *          @SessionAttributes(value="msg")
     *         给BindingAwareModelMap中保存的数据,或者ModelAndView
     *         的数据.同时给session放一份 ,"value"指定保定保存数据时要给session
     *         存放数据的key
     *         (value={"msg","hah"}只要保存的是这种key的数据,
     *         types ={String.class}只要保存的时这种类型的数据.,
     *         给session传一份
     *      不推荐此方式,要给session传数据腿甲使用原生API
     * 4.  @ModelAttribute
     *
     */


    @RequestMapping("/handler01")
    public String handler01 (Map<String, Object> map){
        map.put("msg","hello");
        System.out.println("map's type of data:"+ map.getClass());
        return "getData";
    }


    @RequestMapping("/handler02")
    public String handler02(Model model){
        model.addAttribute("msg","hello handler02");
        System.out.println("model's type of data:"+ model.getClass());
        return "getData";
    }


    @RequestMapping("/handler03")
    public String handler03(ModelMap modelMap){
        modelMap.addAttribute("msg","hello handler03");
        System.out.println("modelMapl's type of data:"+ modelMap.getClass());
        return "getData";
    }

    @RequestMapping("/handler04")
    public ModelAndView handler04(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("getData");
        mv.addObject("msg","hello handler04");
        System.out.println("modelAndView's type of data:"+ mv.getClass());
        return mv;
    }

}
