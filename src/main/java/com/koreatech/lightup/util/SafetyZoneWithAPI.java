package com.koreatech.lightup.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.koreatech.lightup.domain.GeneralSafetyZone;
import com.koreatech.lightup.domain.Location;
import com.koreatech.lightup.domain.SafetyZoneCategory;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class SafetyZoneWithAPI extends SafetyZoneFactory {
    private String url;
    private Map<String, String> params;

    public SafetyZoneWithAPI(String url, Map<String, String> params) {
        this.url = url;
        this.params = params;
    }

    @Override
    public void createJsonString() throws IOException {
        URL url = buildUrl();
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//        urlConnection.setRequestProperty("Content-type", "application/json");
        urlConnection.setRequestMethod("GET");
        System.out.println(url);


        int responseCode = urlConnection.getResponseCode();
        String responseMessage = urlConnection.getResponseMessage();
        String errorMessage = String.format("요청이 잘못되었습니다.\n 에러코드: %d, 에러 메시지 : %s", responseCode, responseMessage);
        if (responseCode != 200) throw new HttpRetryException(errorMessage, responseCode);
        log.info("{}", responseCode);


        BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
        jsonString.append(bf.readLine());

    }
    // 수정필요.
    @Override
    protected List<GeneralSafetyZone> parse(SafetyZoneCategory category) throws JsonProcessingException {
        String json = this.jsonString.toString();
        JsonNode root = mapper.readTree(json);
        JsonNode response = root.get("response");
        JsonNode body = response.get("body");
        ArrayNode items = body.withArray("items");
        List<GeneralSafetyZone> lights = new ArrayList<>();
        for (JsonNode item : items) {
            String xName = item.get("X").asText();
            String yName = item.get("Y").asText();
            lights.add(
                    new GeneralSafetyZone(
                            "방범등",
                            new Location(new BigDecimal(xName), new BigDecimal(yName), null),
                            SafetyZoneCategory.LIGHT
                    )
            );

        }
        return lights;
    }


    private URL buildUrl() throws MalformedURLException, UnsupportedEncodingException {
        StringBuilder urlBuilder = new StringBuilder(url);
        urlBuilder.append("?");
        for (String param : params.keySet()) {
//            urlBuilder.append(URLEncoder.encode(param, "UTF-8")).append("=").append(params.get(param)).append("&");
            urlBuilder.append(param).append("=").append(params.get(param)).append("&");
        }
        urlBuilder.delete(urlBuilder.length() - 1, urlBuilder.length());
        return new URL(urlBuilder.toString());
    }




}
