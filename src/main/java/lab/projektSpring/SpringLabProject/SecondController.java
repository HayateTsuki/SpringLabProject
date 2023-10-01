package lab.projektSpring.SpringLabProject;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecondController {
    @RequestMapping("/szablon")
    public String preview() {
        return "PageView";
    }

    @RequestMapping("/parametr")
    public String testParamTransmission(Model model) {
        model.addAttribute("dataFromController", "Tekst jest parametrem, nie ma go w widoku");
        return "ParamTransmission";
    }
}
