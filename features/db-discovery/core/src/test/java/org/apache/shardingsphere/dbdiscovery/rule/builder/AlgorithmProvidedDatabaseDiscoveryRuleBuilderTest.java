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

package org.apache.shardingsphere.dbdiscovery.rule.builder;

import org.apache.shardingsphere.dbdiscovery.algorithm.config.AlgorithmProvidedDatabaseDiscoveryRuleConfiguration;
import org.apache.shardingsphere.dbdiscovery.api.config.rule.DatabaseDiscoveryDataSourceRuleConfiguration;
import org.apache.shardingsphere.dbdiscovery.api.config.rule.DatabaseDiscoveryHeartBeatConfiguration;
import org.apache.shardingsphere.dbdiscovery.fixture.CoreDatabaseDiscoveryProviderAlgorithmFixture;
import org.apache.shardingsphere.dbdiscovery.rule.DatabaseDiscoveryRule;
import org.apache.shardingsphere.infra.config.mode.ModeConfiguration;
import org.apache.shardingsphere.infra.config.mode.PersistRepositoryConfiguration;
import org.apache.shardingsphere.infra.instance.InstanceContext;
import org.apache.shardingsphere.infra.rule.builder.database.DatabaseRuleBuilder;
import org.apache.shardingsphere.infra.rule.builder.database.DatabaseRuleBuilderFactory;
import org.apache.shardingsphere.schedule.core.ScheduleContextFactory;
import org.apache.shardingsphere.test.fixture.jdbc.MockedDataSource;
import org.junit.Test;

import java.util.Collections;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public final class AlgorithmProvidedDatabaseDiscoveryRuleBuilderTest {
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Test
    public void assertBuild() {
        ScheduleContextFactory.newInstance(new ModeConfiguration("Cluster", mock(PersistRepositoryConfiguration.class)));
        AlgorithmProvidedDatabaseDiscoveryRuleConfiguration algorithmProvidedRuleConfig = new AlgorithmProvidedDatabaseDiscoveryRuleConfiguration(
                Collections.singletonList(new DatabaseDiscoveryDataSourceRuleConfiguration("name", Collections.singletonList("name"), "", "discoveryTypeName")),
                Collections.singletonMap("ha_heartbeat", new DatabaseDiscoveryHeartBeatConfiguration(new Properties())),
                Collections.singletonMap("discoveryTypeName", new CoreDatabaseDiscoveryProviderAlgorithmFixture()));
        DatabaseRuleBuilder builder = DatabaseRuleBuilderFactory.getInstanceMap(Collections.singletonList(algorithmProvidedRuleConfig)).get(algorithmProvidedRuleConfig);
        InstanceContext instanceContext = mock(InstanceContext.class, RETURNS_DEEP_STUBS);
        when(instanceContext.getInstance().getCurrentInstanceId()).thenReturn("foo_id");
        assertThat(builder.build(algorithmProvidedRuleConfig, "",
                Collections.singletonMap("name", new MockedDataSource()), Collections.emptyList(), instanceContext), instanceOf(DatabaseDiscoveryRule.class));
    }
}
