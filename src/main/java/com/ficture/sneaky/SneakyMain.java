package com.ficture.sneaky;

import com.ficture.sneaky.config.ServiceDescriptor;
import com.ficture.sneaky.server.ThriftServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by IntelliJ IDEA.
 * User: sam
 * Date: 1/3/12
 * Time: 4:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class SneakyMain
{
    private static final Logger logger = LoggerFactory.getLogger(SneakyMain.class);

    public static void main(String[] args)
    {
        logger.info("Booting service");
        logger.info("Configured cassandra cluster " + ServiceDescriptor.config.cassandra_cluster.toString());
        try {
            new ThriftServer().run();
        } catch (Exception e) {
            throw new RuntimeException("Caught exception " + e.toString());
        }
    }
}
