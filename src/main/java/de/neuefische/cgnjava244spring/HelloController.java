package de.neuefische.cgnjava244spring;

import org.springframework.web.bind.annotation.*;

@RestController //"Verleiht" die Macht eines Controllers -> unsere Klasse kann Anfragen entgegennehmen!
@RequestMapping("/api/hello") //Wo befindet sich der Controller? Welche Adresse muss in die URL?
public class HelloController {

    @GetMapping()// Lauscht auf GET-Anfrage
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("/{greetform}")
    public String sayCustomGreet(@PathVariable String greetform,//Variab. Pfad in URL -> Name muss übereinstimmen
                                 @RequestParam(required = false, defaultValue = "") String name,
                                 @RequestParam(required = false, defaultValue = "") String q){ // -> ?name=Max
        return greetform + " " + name + " " + q;
    }

    @PostMapping
    public String readData(@RequestBody Student currywurst){
        return currywurst.id();
    }

}
