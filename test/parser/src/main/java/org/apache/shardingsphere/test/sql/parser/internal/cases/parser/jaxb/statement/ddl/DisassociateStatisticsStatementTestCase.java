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

package org.apache.shardingsphere.test.sql.parser.internal.cases.parser.jaxb.statement.ddl;

import lombok.Getter;
import lombok.Setter;
import org.apache.shardingsphere.test.sql.parser.internal.cases.parser.jaxb.segment.impl.column.ExpectedColumn;
import org.apache.shardingsphere.test.sql.parser.internal.cases.parser.jaxb.segment.impl.function.ExpectedFunction;
import org.apache.shardingsphere.test.sql.parser.internal.cases.parser.jaxb.segment.impl.index.ExpectedIndex;
import org.apache.shardingsphere.test.sql.parser.internal.cases.parser.jaxb.segment.impl.index.ExpectedIndexType;
import org.apache.shardingsphere.test.sql.parser.internal.cases.parser.jaxb.segment.impl.packages.ExpectedPackage;
import org.apache.shardingsphere.test.sql.parser.internal.cases.parser.jaxb.segment.impl.table.ExpectedSimpleTable;
import org.apache.shardingsphere.test.sql.parser.internal.cases.parser.jaxb.segment.impl.type.ExpectedType;
import org.apache.shardingsphere.test.sql.parser.internal.cases.parser.jaxb.SQLParserTestCase;

import javax.xml.bind.annotation.XmlElement;
import java.util.LinkedList;
import java.util.List;

/**
 * Disassociate Statistics statement test case.
 */
@Getter
@Setter
public final class DisassociateStatisticsStatementTestCase extends SQLParserTestCase {
    
    @XmlElement(name = "index")
    private final List<ExpectedIndex> indexes = new LinkedList<>();
    
    @XmlElement(name = "table")
    private final List<ExpectedSimpleTable> tables = new LinkedList<>();
    
    @XmlElement(name = "column")
    private final List<ExpectedColumn> columns = new LinkedList<>();
    
    @XmlElement(name = "function")
    private final List<ExpectedFunction> functions = new LinkedList<>();
    
    @XmlElement(name = "package")
    private final List<ExpectedPackage> packages = new LinkedList<>();
    
    @XmlElement(name = "type")
    private final List<ExpectedType> types = new LinkedList<>();
    
    @XmlElement(name = "index-type")
    private final List<ExpectedIndexType> indexTypes = new LinkedList<>();
}
