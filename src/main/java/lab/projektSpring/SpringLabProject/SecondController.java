package lab.projektSpring.SpringLabProject;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecondController {
    @RequestMapping("/template")
    public String preview() {
        return "PageView";
    }

    @RequestMapping("/parameter")
    public String testParamTransmission(Model model) {
        model.addAttribute("dataFromController", "Tekst jest parametrem, nie ma go w widoku");
        return "ParamTransmission";
    }

    @RequestMapping("/calculate/{action}/{number1}/{number2}")
    public String calculateAndSendToView(Model model, @PathVariable String action, @PathVariable Long number1, @PathVariable Long number2) {
        Long result = 0L;
        switch (action){
            case "dodawanie":
                result = number1 + number2;
                model.addAttribute("dodawanie", "Wynikiem dodawania liczb " + number1 + " i " + number2 + " jest " + result);
                return "CalculatorView";
            case "odejmowanie":
                result = number1 - number2;
                model.addAttribute("odejmowanie", "Wynikiem odejmowania liczb " + number1 + " i " + number2 + " jest " + result);
                return "CalculatorView";
            case "mnozenie":
                result = number1 * number2;
                model.addAttribute("mnozenie", "Wynikiem mnozenia liczb " + number1 + " i " + number2 + " jest " + result);
                return "CalculatorView";
            default:
                model.addAttribute("default", "|Defaultowy ComponentView|");
                return "CalculatorView";
        }
    }

    /*@RequestMapping("/object")
    public Object hello3(Model model) {
        Osoba osoba1 = new Osoba(1, "Jan", "Kowalski", "600-123-456", "przykladowy@mail.com");
        model.addAttribute("osoba1", osoba1);
        Osoba osoba2 = new Osoba(2, "Anna", "Nowak", "600-987-654", "anna@mail.com");
        model.addAttribute("osoba1", osoba1);
        model.addAttribute("osoba2", osoba2);
        return "obiektOsoba";
    }*/

}
