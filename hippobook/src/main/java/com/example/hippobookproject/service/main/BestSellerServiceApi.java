
package com.example.hippobookproject.service.main;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Slf4j
@Service
public class BestSellerServiceApi {
    @Value("${api.key.aladin}")
    private String apiKey;

    public String findBestSeller(){
        String baseUrl = "http://www.aladin.co.kr/ttb/api/ItemList.aspx";
        String queryType = "Bestseller";
        String searchTarget = "Book";
        String output = "js";
        String version = "20131101";
        int start = 1;
        int maxResults = 9;

        String url = baseUrl + "?ttbkey=" + apiKey +
                "&QueryType=" + queryType +
                "&SearchTarget=" + searchTarget +
                "&output=" + output +
                "&version=" + version +
                "&Start=" + start +
                "&MaxResults=" + maxResults;
        log.info("url : {}", url);

        WebClient webClient = WebClient.builder().build();
        String result = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();


        return result;
    }

}

