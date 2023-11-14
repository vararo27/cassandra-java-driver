<!--
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
-->

# Object Mapper

Version 2.1 of the driver introduces a simple object mapper, which
avoids most of the boilerplate when converting your domain classes to
and from query results. It handles basic CRUD operations in Cassandra tables
containing UDTs, collections and all native CQL types.

The mapper is published as a separate Maven artifact:

```xml
<dependency>
  <groupId>com.datastax.cassandra</groupId>
  <artifactId>cassandra-driver-mapping</artifactId>
  <version>2.2.0-rc3</version>
</dependency>
```

This documentation is organized in subsections describing mapper features.