package com.api.apisigi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class HomeController {
    //# METODO OBTENCION PLANTILLA HTML5 DEL INDEX
    public static final String INDEX_VIEW = "index";
    //AGREGANDO LOGS A NUESRA RUTA
    public static final Log logger = LogFactory.getLog(HomeController.class);
    //# METODO-REST TIPO GET:OBTENER
    @GetMapping("/")
    public ModelAndView getIndex() {
        ModelAndView maw = new ModelAndView(INDEX_VIEW);
        logger.info("[Request_Type: GET] -- FROM: '/' -- View: Index.html ");
        return maw;
    }


}
