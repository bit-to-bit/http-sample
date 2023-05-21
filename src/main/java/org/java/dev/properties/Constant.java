package org.java.dev.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Constant {
    FILE_STORAGE("org.java.dev.file.storage"),
    LOG_ENCODING("log4j.logger.encoding"),
    LOG_FILE("log4j.appender.file"),
    LOG_LEVEL("log4j.logger.level"),
    LOG_PATTERN("log4j.conversion.pattern");
    @Getter
    private final String propertyName;

    public String getValue() {
    return PropertyService.getProperty(this);
    }
}
