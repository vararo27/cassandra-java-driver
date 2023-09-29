/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.datastax.driver.mapping.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.datastax.driver.core.TypeCodec;

/**
 * Provides a name for a parameter of a method in an {@link Accessor} interface that
 * can be used to reference to that parameter in method {@link Query}.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface Param {
    /**
     * The name for the parameter
     *
     * @return the name of the parameter.
     */
    String value() default "";

    /**
     * A custom codec that will be used to serialize the parameter.
     *
     * @return the codec's class. It must have a no-argument constructor (the mapper
     * will create an instance and cache it).
     */
    Class<? extends TypeCodec<?>> codec() default Defaults.NoCodec.class;
}
