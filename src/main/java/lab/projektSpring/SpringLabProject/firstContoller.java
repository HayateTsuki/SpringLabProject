package lab.projektSpring.SpringLabProject;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

@RestController
public class firstContoller {

    @RequestMapping("/")
    public String index() {
        return "Nasz pierwszy projekt i już działający serwer :-)";
    }

    @GetMapping(value = "/{text}/{value}")
    public String GetMethodToViewStringAndValue(@PathVariable String text, @PathVariable Long value) throws Exception {
        return "GET:Z adresu pozyskałem następujące dane: " + text + " przekazana liczba to:" + value;
    }

    @GetMapping(value = "/{text1}/{value1}/{text2}/{value2}")
    public String GetMethodToViewStringAndValuePlusStringAndValue(@PathVariable String text1, @PathVariable Long value1, @PathVariable String text2, @PathVariable Long value2) throws Exception {
        return "GET2:Z adresu pozyskałem następujące dane: string = " + text1 + " przekazana liczba to: " + value1 + " oraz string = " + text2 + " przekazana liczba to: " + value2;
    }
    @PostMapping("/post")
    @ResponseBody
    public String postValue(@RequestParam String value) {
        return "POST:W adresie URL otrzymałem wartość. Przekazana liczba to:" + value;
    }

    @GetMapping(value = "/{action}/{value1}/{value2}")
    public String CalculateWithAppropriateAction(@PathVariable String action, @PathVariable Long value1, @PathVariable Long value2) throws Exception {
        long result = 0;
        switch (action) {
            case "dodawanie":
                result = value1 + value2;
                break;
            case "odejmowanie":
                result = value1 - value2;
                break;
            case "mnozenie":
                result = value1 * value2;
                break;
       }
        return "Wybrano akcje: " + action + ". Wynik przeprowadzonej akcji na liczbach: " + value1 + " oraz " + value2 + " to: " + result;
    }

    @RequestMapping(value = "/request2header", produces = MediaType.TEXT_HTML_VALUE)
    public String Example2RequestHeader(
            @RequestHeader("User-Agent") String user,
            @RequestHeader("Accept-Language") String acceptLanguage,
            @RequestHeader("Host") String host
    ) throws Exception {
        return " <b>Przeglądarka/klient HTTP:</b><br> " + user
                + "<br><br><b>Język:</b><br> " + acceptLanguage
                + "<br><br><b>Host:</b><br> " + host;
    }

}