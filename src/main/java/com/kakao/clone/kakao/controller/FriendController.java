package com.kakao.clone.kakao.controller;


import com.kakao.clone.kakao.Exception.CustomException;
import com.kakao.clone.kakao.dto.FriendNewRequertDto;
import com.kakao.clone.kakao.dto.FriendResponseDto;
import com.kakao.clone.kakao.security.UserDetailsImpl;
import com.kakao.clone.kakao.service.FriendService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class FriendController {

    private final FriendService FriendService;

    public FriendController(FriendService FriendService) {
        this.FriendService = FriendService;
    }

    @GetMapping("/api/friend/list") //메인 투척.
    public ResponseEntity<FriendResponseDto> showFriendList(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok().body(FriendService.showFriendList(userDetails));
    }


    @PostMapping("/api/friend/new")
    public CustomException friendNew(@RequestBody FriendNewRequertDto friendNewRequertDto,
                                     @AuthenticationPrincipal UserDetailsImpl userDetails)
    {
        return FriendService.friendNew(friendNewRequertDto,userDetails);
    }

    @GetMapping("/")
    public String gooja(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return userDetails.getUser().getNickname();
    }
}
