package lk.ijse.gdse65.AAD_Course_Work.controller;

import lk.ijse.gdse65.AAD_Course_Work.reqAndresp.response.JwtAuthResponse;
import lk.ijse.gdse65.AAD_Course_Work.reqAndresp.secure.SignIn;
import lk.ijse.gdse65.AAD_Course_Work.reqAndresp.secure.SignUp;
import lk.ijse.gdse65.AAD_Course_Work.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin
@RequiredArgsConstructor
public class User {
    private final AuthenticationService authenticationService;


    //signup
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthResponse> signUp(@RequestBody SignUp signUpReq) {
        System.out.println(signUpReq);
        return ResponseEntity.ok(authenticationService.signUp(signUpReq));
    }

    //signIn
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthResponse> signIn(@RequestBody SignIn signInReq) {
        return ResponseEntity.ok(authenticationService.signIn(signInReq));
    }

    //refresh
    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthResponse> refreshToken(@RequestParam("refreshToken") String refreshToken) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshToken));
    }
}

