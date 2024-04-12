package com.bryanlanghendries.exceptions;

import org.apache.commons.lang3.StringUtils;

public class EntityNotFoundException extends RuntimeException{
    private final Class<?> clazz;
    private final String identifier;

    public EntityNotFoundException(Class<?> clazz, String identifier){
        this.clazz = clazz;
        this.identifier = identifier;
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
        return String.format("Could not find %s with identifier %s", humanFriendlyName, identifier);
    }
}
