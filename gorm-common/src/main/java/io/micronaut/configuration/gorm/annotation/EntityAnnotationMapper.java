/*
 * Copyright 2017-2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.configuration.gorm.annotation;

import grails.gorm.annotation.Entity;
import io.micronaut.core.annotation.AnnotationValue;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.inject.annotation.TypedAnnotationMapper;
import io.micronaut.inject.visitor.VisitorContext;

import java.util.Collections;
import java.util.List;

/**
 * Ensures all GORM entities are introspected to allow for them to be found
 * via introspection scanning instead of traditional classpath scanning.
 *
 * @author James Kleeh
 * @since 3.0.0
 */
public class EntityAnnotationMapper implements TypedAnnotationMapper<Entity> {

    @Override
    public Class<Entity> annotationType() {
        return Entity.class;
    }

    @Override
    public List<AnnotationValue<?>> map(AnnotationValue<Entity> annotation, VisitorContext visitorContext) {
        return Collections.singletonList(AnnotationValue.builder(Introspected.class).build());
    }
}
