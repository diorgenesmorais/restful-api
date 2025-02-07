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

    private static final String ERROR_MESSAGE = "Os paths precisam serem números";

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public BigDecimal sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        var total = BigDecimal.ZERO;
        
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException(ERROR_MESSAGE);
        }

        var one = new BigDecimal(handlerValue(numberOne));
        var two = new BigDecimal(handlerValue(numberTwo));

        return total.add(one).add(two);
    }

    @GetMapping("/subtract/{numberOne}/{numberTwo}")
    public BigDecimal subtract(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException(ERROR_MESSAGE);
        }

        var one = new BigDecimal(handlerValue(numberOne));
        var two = new BigDecimal(handlerValue(numberTwo));

        return one.subtract(two);
    }

    @GetMapping("/multiply/{numberOne}/{numberTwo}")
    public BigDecimal multiply(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException(ERROR_MESSAGE);
        }

        var one = new BigDecimal(handlerValue(numberOne));
        var two = new BigDecimal(handlerValue(numberTwo));

        return one.multiply(two);
    }

}
