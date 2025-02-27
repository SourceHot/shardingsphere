/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.proxy.backend.communication.jdbc.executor.callback.impl;

import org.apache.shardingsphere.infra.database.type.DatabaseType;
import org.apache.shardingsphere.proxy.backend.communication.jdbc.JDBCDatabaseCommunicationEngine;
import org.apache.shardingsphere.proxy.backend.communication.jdbc.executor.callback.ProxyJDBCExecutorCallback;
import org.apache.shardingsphere.sql.parser.sql.common.statement.SQLStatement;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

/**
 * Statement executor callback for proxy.
 */
public final class ProxyStatementExecutorCallback extends ProxyJDBCExecutorCallback {
    
    public ProxyStatementExecutorCallback(final DatabaseType protocolType, final Map<String, DatabaseType> storageTypes, final SQLStatement sqlStatement,
                                          final JDBCDatabaseCommunicationEngine databaseCommunicationEngine, final boolean isReturnGeneratedKeys,
                                          final boolean isExceptionThrown, final boolean fetchMetaData) {
        super(protocolType, storageTypes, sqlStatement, databaseCommunicationEngine, isReturnGeneratedKeys, isExceptionThrown, fetchMetaData);
    }
    
    @Override
    protected boolean execute(final String sql, final Statement statement, final boolean isReturnGeneratedKeys) throws SQLException {
        return statement.execute(sql, isReturnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
    }
}
