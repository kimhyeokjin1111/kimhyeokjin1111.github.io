package com.example.hippobookproject.api.mainpage;


import com.example.hippobookproject.service.main.BestSellerServiceApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BestSellerApi {
    private final BestSellerServiceApi bestSellerServiceApi;

    @GetMapping("/rank")
    public String bestSeller(){
        return bestSellerServiceApi.findBestSeller();
    }
}
