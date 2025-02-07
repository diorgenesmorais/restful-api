package com.dms.restful.api.v1.controller;

import com.dms.restful.core.domain.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import static com.dms.restful.core.domain.utils.HandleData.handlerValue;
import static com.dms.restful.core.domain.utils.HandleData.isNumeric;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public BigDecimal sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        var total = BigDecimal.ZERO;
        
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Os paths precisam serem números");
        }

        var one = new BigDecimal(handlerValue(numberOne));
        var two = new BigDecimal(handlerValue(numberTwo));

        return total.add(one).add(two);
    }


}
