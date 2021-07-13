package com.devsuperior.dscatalog.services.exceptions;

import com.sun.xml.bind.v2.schemagen.XmlSchemaGenerator;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String msg){
        super(msg);
    }

}
