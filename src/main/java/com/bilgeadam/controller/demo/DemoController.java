package com.bilgeadam.controller.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/demo")
public class DemoController {


    @GetMapping("/getname")
     public String getName(){
         return "Mustafa";
     }

    @GetMapping("/getname2")
    public String getName2(String name,String surname){
        return "<style> .myname{color:red }</style> <div class='myname'>"+name+"-"+surname+"</div>  ";
    }

    // getlist diye bir metot yazalım dısarıdan parametre almasın
    //metot içersinde tanımladıgımız  isim listesini bize geri donsun


    @GetMapping("/getlist")
    public List<String> getList(){
        List<String> isimList=new ArrayList<>();
        isimList.add("Doruk");
        isimList.add("Engin");
        isimList.add("Hülya");
        return isimList;
    }

    @GetMapping("/getlist2")
    public String [] getList( String [] isimList ){
        return isimList;
    }
}
