package com.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

@Slf4j
@Service
public class RouteAgentImpl{
    public ResponseEntity<String> forward(HttpServletRequest request, HttpServletResponse response, String routeUrl,
                                           String prefix, String replacement) {
        try {
            // build up the redirect URL
            String redirectUrl = createRedictUrl(request,routeUrl, prefix, replacement);
            System.out.println("redirectUrl: " + redirectUrl);
            //content-type
            String contentType = request.getHeader("content-type");
            System.out.println("content-type:" + contentType);
            if(contentType.contains("application/json")){
                RequestEntity requestEntity = createRequestEntity(request, redirectUrl);
                return route(requestEntity);
            }
            if(contentType.contains("multipart/form-data")){
                return route4formData(request, redirectUrl);
            }
        } catch (Exception e) {
            return new ResponseEntity("REDIRECT ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return null;
    }

    private String createRedictUrl(HttpServletRequest request, String routeUrl, String prefix, String replacement) {
        String queryString = request.getQueryString();
        log.info("request uri:{}", request.getRequestURI());
        return routeUrl + request.getRequestURI().replace(prefix, replacement) +
                (queryString != null ? "?" + queryString : "");
    }


    private RequestEntity createRequestEntity(HttpServletRequest request, String url) throws URISyntaxException, IOException {
        String method = request.getMethod();
        HttpMethod httpMethod = HttpMethod.resolve(method);
        MultiValueMap<String, String> headers = parseRequestHeader(request);

        byte[] body = parseRequestBody(request);
        return new RequestEntity<>(body, headers, httpMethod, new URI(url));
    }

    private ResponseEntity<String> route(RequestEntity requestEntity) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(requestEntity, String.class);
    }

    private ResponseEntity<String> route4formData(HttpServletRequest request, String url) {
        MultipartHttpServletRequest params=((MultipartHttpServletRequest) request);

        Enumeration<String> enumeration = params.getParameterNames();

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = params.getRequestHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap map = new LinkedMultiValueMap();
        params.getParameterNames().nextElement();
        while (enumeration.hasMoreElements()){
            String element = (String) enumeration.nextElement();
            map.add(element, params.getParameter(element));
        }
        HttpEntity requestBody = new HttpEntity(map, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestBody, String.class);
        return responseEntity;
    }

    private byte[] parseRequestBody(HttpServletRequest request) throws IOException {
        InputStream inputStream = request.getInputStream();
        return StreamUtils.copyToByteArray(inputStream);
    }

    private MultiValueMap<String, String> parseRequestHeader(HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();
        List<String> headerNames = Collections.list(request.getHeaderNames());
        for (String headerName : headerNames) {
            List<String> headerValues = Collections.list(request.getHeaders(headerName));
            for (String headerValue : headerValues) {
                headers.add(headerName, headerValue);
            }
        }
        return headers;
    }
}
