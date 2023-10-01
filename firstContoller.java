package lab.projektSpring.SpringLabProject;

import org.springframework.web.bind.annotation.*;

@RestController
public class firstContoller {

    @RequestMapping("/")
    public String index() {
        return "Nasz pierwszy projekt i już działający serwer :-)";
    }

    @GetMapping(value = "/{text}/{value}")
    public String GetMethodToViewStringAndValue(@PathVariable String text, @PathVariable Long value) throws Exception {
        return "Z adresu pozyskałem następujące dane: =" + text + " przekazana liczba to:" + value;
    }

    @PostMapping(value = "/{text1}/{value1}/{text2}/{value2}")
    public String GetMethodToViewStringAndValuePlusStringAndValue(@PathVariable String text1, @PathVariable Long value1, @PathVariable String text2, @PathVariable Long value2) throws Exception {
        return "Z adresu pozyskałem następujące dane: string = " + text1 + " przekazana liczba to: " + value1 + " oraz string = " + text2 + " przekazana liczba to: " + value2;
    }
}
