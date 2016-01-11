package de.muenchen.service.domain;


import org.hibernate.search.annotations.IndexedEmbedded;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by dennis_huning on 07.01.16.
 */
public class FaqEntityTest {

    Logger log = LoggerFactory.getLogger(FaqEntityTest.class);

    @Test
    public void testProperties() {

        Stream
                .of(FaqEntity.class.getDeclaredFields()).filter(field -> field.isAnnotationPresent(org.hibernate.search.annotations.Field.class))
                .map(Field::getName)
                .forEach(log::debug);

        Stream
                .of(FaqEntity.class.getDeclaredFields()).filter(field -> field.isAnnotationPresent(IndexedEmbedded.class))
                .map(field -> Arrays.asList(field.getType().getDeclaredFields())).flatMap(f -> f.stream()).collect(Collectors.toList()).stream()
                .filter(field -> field.isAnnotationPresent(org.hibernate.search.annotations.Field.class))
                .map(Field::getName)
                .forEach(log::debug);


    }

}
