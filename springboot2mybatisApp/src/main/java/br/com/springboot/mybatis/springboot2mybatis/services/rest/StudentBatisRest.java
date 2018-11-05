package br.com.springboot.mybatis.springboot2mybatis.services.rest;

import br.com.springboot.mybatis.springboot2mybatis.controller.IBatisStudentController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restws/student")
public class StudentBatisRest {
    private static final Logger logger = LoggerFactory.getLogger(StudentBatisRest.class);

    @Autowired
    private IBatisStudentController iBatisStudentController;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = "application/json")
    public String findAll() {
        String retorno = "";
        try {
            logger.debug("# Inicio AceiteRest.findAll #");
            retorno = iBatisStudentController.findAll();
            logger.debug("# Fim AceiteRest.findAll #");
        } catch (Exception e) {
            logger.error("Erro no findAll {}", e.getMessage(), e);
        }
        return retorno;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET, produces = "application/json")
    public String insert() {
        String retorno = "OK";
        try {
            logger.debug("# Inicio AceiteRest.insert #");
            iBatisStudentController.insert();
            logger.debug("# Fim AceiteRest.insert #");
        } catch (Exception e) {
            retorno = "NOK";
            logger.error("Erro no insert {}", e.getMessage(), e);
        }
        return retorno;
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET, produces = "application/json")
    public String findById(@PathVariable("id") long id) {
        String retorno = "";
        try {
            logger.debug("# Inicio AceiteRest.findById #");
            retorno = iBatisStudentController.findById(id);
            logger.debug("# Fim AceiteRest.findById #");
        } catch (Exception e) {
            logger.error("Erro no findById {}", e.getMessage(), e);
        }
        return retorno;
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.GET, produces = "application/json")
    public String deleteById(@PathVariable("id") long id) {
        String retorno = "OK";
        try {
            logger.debug("# Inicio AceiteRest.deleteById #");
            iBatisStudentController.deleteById(id);
            logger.debug("# Fim AceiteRest.deleteById #");
        } catch (Exception e) {
            retorno = "NOK";
            logger.error("Erro no deleteById {}", e.getMessage(), e);
        }
        return retorno;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET, produces = "application/json")
    public String update() {
        String retorno = "OK";
        try {
            logger.debug("# Inicio AceiteRest.update #");
            iBatisStudentController.update();
            logger.debug("# Fim AceiteRest.update #");
        } catch (Exception e) {
            retorno = "OK";
            logger.error("Erro no update {}", e.getMessage(), e);
        }
        return retorno;
    }
}
