package github.sagubr;

import io.micronaut.http.annotation.*;

@Controller("/key-keeper")
public class KeyKeeperController {

    @Get(uri = "/", produces = "text/plain")
    public String index() {
        return "Example Response";
    }
}