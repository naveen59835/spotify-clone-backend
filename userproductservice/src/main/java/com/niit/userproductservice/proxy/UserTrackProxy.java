/*
 * Author : Naveen Kumar
 * Date : 15-02-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.userproductservice.proxy;

import com.niit.userproductservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-auth-service",url = "localhost:8090")
public interface UserTrackProxy {
    @PostMapping("/api/v1/user")
    public ResponseEntity saveUserTrackInAuth(@RequestBody User user);
}
