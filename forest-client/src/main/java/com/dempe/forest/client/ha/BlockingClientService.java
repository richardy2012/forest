package com.dempe.forest.client.ha;

import com.dempe.forest.common.cluster.HAProxy;
import com.dempe.forest.common.protocol.Request;
import com.dempe.forest.common.protocol.Response;

/**
 * Created with IntelliJ IDEA.
 * User: Dempe
 * Date: 2016/3/9
 * Time: 16:20
 * To change this template use File | Settings | File Templates.
 */
public class BlockingClientService {

    private static FutureClientService futureClientService;

    public BlockingClientService(String name) throws Exception {
        futureClientService = new FutureClientService(name);
    }

    public BlockingClientService(String name, HAProxy.Strategy strategy, long period) throws Exception {
        futureClientService = new FutureClientService(name, strategy, period);
    }


    public Response send(Request request) throws Exception {
        return futureClientService.send(request).await();
    }


}