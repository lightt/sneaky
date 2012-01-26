package com.ficture.sneaky.test;

import junit.framework.Assert;
import org.junit.*;

import com.ficture.sneaky.thrift.*;

import com.ficture.sneaky.service.SneakyService;

public class ServicePingTest extends BaseEmbeddedServerTest
{
    private SneakyService service;

    @Before
    public void before() {
        service = new SneakyService();
    }

    @After
    public void after() {
        service = null;
    }

    @Test
    public void pingShouldWork() {
        service.ping();
    }

    @Test
    public void putShouldCreateAUser() {
        // create some random user
        User u = new User();
        u.setUser_id(100);
        // push it to the service
        User returnedUser = service.putUser(u);
        // is it the same?
        Assert.assertEquals(u.user_id, returnedUser.user_id);
        // when we retrieve it again, still the same?
    }
}
