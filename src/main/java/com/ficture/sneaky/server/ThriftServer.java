package com.ficture.sneaky.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

import com.ficture.sneaky.config.ServiceDescriptor;
import com.ficture.sneaky.service.SneakyService;
import com.ficture.sneaky.thrift.Sneaky;


public class ThriftServer extends Thread {
    private Logger logger;

    public TServer serverEngine;

    public void startServer() {
        SneakyService sneakyService = new SneakyService();
        Sneaky.Processor processor = new Sneaky.Processor(sneakyService);

        TServerTransport serverTransport;
        try {
            serverTransport = new TServerSocket(ServiceDescriptor.config.rpc_port);
        } catch (TTransportException e) {
            throw new RuntimeException(String.format("Could not bind to port %d", ServiceDescriptor.config.rpc_port));
        }

        serverEngine = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));

        logger.info(String.format("Starting thrift service on %d", ServiceDescriptor.config.rpc_port));

        serverEngine.serve();
    }

    public void stopServer() {
        serverEngine.stop();
    }

    public void run() {
        logger = LoggerFactory.getLogger(ThriftServer.class);
        startServer();
    }
}