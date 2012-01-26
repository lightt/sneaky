package com.ficture.sneaky.test;

import java.io.IOException;

import com.ficture.sneaky.config.ServiceDescriptor;
import me.prettyprint.cassandra.connection.HConnectionManager;
import me.prettyprint.cassandra.service.CassandraHostConfigurator;

import org.apache.cassandra.config.ConfigurationException;
import org.apache.thrift.transport.TTransportException;
import org.cassandraunit.AbstractCassandraUnit4TestCase;
import org.cassandraunit.dataset.DataSet;
import org.cassandraunit.dataset.yaml.ClassPathYamlDataSet;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base class for test cases that need access to EmbeddedServerHelper
 *
 * @author Nate McCall (nate@vervewireless.com)
 *
 */
public abstract class BaseEmbeddedServerTest extends AbstractCassandraUnit4TestCase {
    private static Logger log = LoggerFactory.getLogger(BaseEmbeddedServerTest.class);

    protected HConnectionManager connectionManager;
    protected CassandraHostConfigurator cassandraHostConfigurator;
    protected String clusterName = "TestCluster";

    protected void setupClient() {
        cassandraHostConfigurator = new CassandraHostConfigurator("127.0.0.1:9171");
        connectionManager = new HConnectionManager(clusterName,cassandraHostConfigurator);
        ServiceDescriptor.replaceCassandra(cassandraHostConfigurator);
    }

    @Override
    public DataSet getDataSet() {
        return new ClassPathYamlDataSet("dataset.yaml");
    }
}