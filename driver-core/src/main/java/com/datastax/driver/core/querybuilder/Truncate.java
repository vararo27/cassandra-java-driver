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
package com.datastax.driver.core.querybuilder;

import java.util.List;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.CodecRegistry;
import com.datastax.driver.core.ProtocolVersion;
import com.datastax.driver.core.TableMetadata;

/**
 * A built TRUNCATE statement.
 */
public class Truncate extends BuiltStatement {

    private final String table;

    Truncate(ProtocolVersion protocolVersion, CodecRegistry codecRegistry, String keyspace, String table) {
        super(keyspace, protocolVersion, codecRegistry);
        this.table = table;
    }

    Truncate(ProtocolVersion protocolVersion, CodecRegistry codecRegistry, TableMetadata table) {
        super(table, protocolVersion, codecRegistry);
        this.table = escapeId(table.getName());
    }

    @Override
    protected StringBuilder buildQueryString(List<Object> variables) {
        StringBuilder builder = new StringBuilder();

        builder.append("TRUNCATE ");
        if (keyspace != null)
            Utils.appendName(keyspace, builder).append('.');
        Utils.appendName(table, builder);

        return builder;
    }
}
