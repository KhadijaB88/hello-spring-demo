package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chris Bay
 */
@Controller
@ResponseBody

public class HelloController {

    public static String createMessage(String name, String language){
        String greeting ="";
        if (language.equals("English")) {
            greeting = "Hello";
        }
        else if (language.equals("French")) {
            greeting = "Bonjour";
        }
        else if (language.equals("Hindi")) {
            greeting = "Namaste";
        }
        else if (language.equals("Spanish")) {
            greeting = "Hola";
        }
        else if (language.equals("Urdu")) {
            greeting = "Salam";
        }

        return greeting + " " + name;
    }


    @RequestMapping(value= "hello", method = {RequestMethod.GET, RequestMethod.POST})

    public String helloGreeting(@RequestParam String name, @RequestParam String language) {

        if(name == null) {
            name = "world";
        }

       return createMessage(name, language);
    }


    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = '/hello' method = 'post'>" + // submit a request to /hello
                "<input type = 'text' name = 'name' >" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "<select name='language' id ='language'>" +
                "<option value = 'English'> English </option>"+
                "<option value = 'French'> French </option>"+
                "<option value = 'Hindi'> Hindi </option>"+
                "<option value = 'Spanish'>Spanish </option>"+
                "<option value = 'Urdu'> Urdu </option>"+
                "</select>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
