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

package org.apache.shardingsphere.test.sql.parser.internal.cases.parser.jaxb.segment.impl.dostatement;

import lombok.Getter;
import lombok.Setter;
import org.apache.shardingsphere.test.sql.parser.internal.cases.parser.jaxb.segment.AbstractExpectedSQLSegment;
import org.apache.shardingsphere.test.sql.parser.internal.cases.parser.jaxb.segment.impl.expr.complex.ExpectedCommonExpression;
import org.apache.shardingsphere.test.sql.parser.internal.cases.parser.jaxb.segment.impl.expr.simple.ExpectedLiteralExpression;
import org.apache.shardingsphere.test.sql.parser.internal.cases.parser.jaxb.segment.impl.expr.simple.ExpectedParameterMarkerExpression;

import javax.xml.bind.annotation.XmlElement;

/**
 * Expected do parameter.
 */
@Getter
@Setter
public final class ExpectedDoParameter extends AbstractExpectedSQLSegment {
    
    @XmlElement(name = "parameter-marker-expression")
    private ExpectedParameterMarkerExpression parameterMarkerExpression;
    
    @XmlElement(name = "literal-expression")
    private ExpectedLiteralExpression literalExpression;
    
    @XmlElement(name = "common-expression")
    private ExpectedCommonExpression commonExpression;
}
