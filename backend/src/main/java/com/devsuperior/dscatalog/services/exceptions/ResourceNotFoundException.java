package com.devsuperior.dscatalog.services.exceptions;

import com.sun.xml.bind.v2.schemagen.XmlSchemaGenerator;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String msg){
        super(msg);
    }

}
