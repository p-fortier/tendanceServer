package insa.tc.tendance.rest;

import insa.tc.tendance.Style;
import insa.tc.tendance.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Patrik on 06/06/2016.
 */
@RestController
@RequestMapping("/styles")
public class StyleRestController {
    private final StyleRepository styleRepository;

    @Autowired
    public StyleRestController(StyleRepository styleRepository) {this.styleRepository = styleRepository; }


    @RequestMapping(method = RequestMethod.GET)
    List<Style> getStyles(){
        return styleRepository.findAll();
    }
}
