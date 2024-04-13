package com.bryanlanghendries.exceptions;

import org.apache.commons.lang3.StringUtils;

public class BadInputException extends RuntimeException{

    private final Class<?> clazz;
    private final String identifier;

    public BadInputException(Class<?> clazz, String identifier){
        this.clazz = clazz;
        this.identifier = identifier;
    }

    public BadInputException(Class<?> clazz){
        this.clazz = clazz;
        this.identifier = "no identifier";
    }

    @Override
    public String getMessage() {
        final String humanFriendlyName = StringUtils.capitalize(
                StringUtils.join(
                        StringUtils.splitByCharacterTypeCamelCase(
                                StringUtils.remove(clazz.getSimpleName(), "Entity")
                        ), StringUtils.SPACE
                )
        );
        return String.format("Bad input for %s with identifier %s", humanFriendlyName, identifier);
    }
}
