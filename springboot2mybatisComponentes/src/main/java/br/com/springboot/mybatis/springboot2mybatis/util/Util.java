package br.com.springboot.mybatis.springboot2mybatis.util;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class Util {

    private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);

    //Xml to Obj
    public static Object unmarshallJAXBfromString(String xml, Object classe) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(classe.getClass());
        Unmarshaller um = context.createUnmarshaller();
        InputStream bAIS = null;

        try {
            bAIS = new ByteArrayInputStream(xml.getBytes("ISO-8859-1"));
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("Error {}", e.getMessage(), e);
            throw new JAXBException(e.getMessage());
        }

        return um.unmarshal(bAIS);
    }

    public static String marshallJAXB(Object classe) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(classe.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "ISO-8859-1");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        marshaller.marshal(classe, baos);
        String retorno = null;
        try {
            retorno = baos.toString("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("Error {}", e.getMessage(), e);
            throw new JAXBException(e.getMessage());
        }
        return retorno;
    }

    public static String objectFromJSon(Object objeto) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        AnnotationIntrospector ai = new JaxbAnnotationIntrospector();
        mapper.getDeserializationConfig().setAnnotationIntrospector(ai);
        mapper.getSerializationConfig().setAnnotationIntrospector(ai);
        return mapper.writeValueAsString(objeto);
    }

    public static Object jSonFromObject(String jSon, Class<? extends Object> classe) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        AnnotationIntrospector ai = new JaxbAnnotationIntrospector();
        mapper.getDeserializationConfig().setAnnotationIntrospector(ai);
        mapper.getSerializationConfig().setAnnotationIntrospector(ai);

        return mapper.readValue(jSon, classe);
    }
}