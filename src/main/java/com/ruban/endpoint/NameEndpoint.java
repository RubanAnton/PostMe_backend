package com.ruban.endpoint;

import com.ruban.soap.GetNameRequest;
import com.ruban.soap.GetNameResponse;
import com.ruban.utility.NameUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class NameEndpoint {
    private static final String NAMESPACE_URI = "http://ruban.com/soap";
    @Autowired
    private NameUtility nameUtility;
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getNameRequest")
    @ResponsePayload
    public GetNameResponse getNameProject(@RequestPayload GetNameRequest request) {
        GetNameResponse response = new GetNameResponse();
        response.setNameProject(nameUtility.getName());
        return response;
    }
}