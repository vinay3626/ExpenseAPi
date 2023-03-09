/* package com.tecnics.expense.contollers;




import java.util.HashMap;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tecnics.expense.config.JwtTokenUtil;
import com.tecnics.expense.dtos.AuthDto;
import com.tecnics.expense.dtos.UserProfileDto;
import com.tecnics.expense.models.AuthModel;
import com.tecnics.expense.services.AuthServices;
import com.tecnics.expense.utils.ResponseMessage;
import static com.tecnics.expense.utils.Constants.JSON_PROCESSING_FAILED;
import static com.tecnics.expense.utils.Constants.NO_RECORD_FOUND;
// import static com.tecnics.expense.utils.Constants.RECORD_IS_ALREADY_EXIST;
import static com.tecnics.expense.utils.Constants.DATA_ERROR;
import static com.tecnics.expense.utils.ResponseUtility.processResponse;

@RestController
@RequestMapping("/user")
public class AuthController {
    
     // logger
  private static final Logger log = LoggerFactory.getLogger(
    AuthController.class
  );

  @Autowired
  public AuthServices authService;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  
  ModelMapper modelMapper = new ModelMapper();

  String errorMessage = null;
  String exceptionMsg = null;

  @PostMapping("/save")
  public ResponseEntity<ResponseMessage> saveUser(

    @RequestBody AuthDto authDto
  ) {
    AuthModel response = null;
    try {
      response = authService.saveUser(authDto);
      if (response == null) {
        errorMessage = NO_RECORD_FOUND;
      }
    } catch (Exception e) {
      errorMessage = JSON_PROCESSING_FAILED;
      exceptionMsg = e.getMessage();
    }

    return processResponse(errorMessage, exceptionMsg, response);
  }


  
  @PostMapping(value = "/authenticate")
  public ResponseEntity<ResponseMessage> createAuthenticationToken(
    @RequestBody AuthDto authDto
  ) {
    log.info("<<< authenticate >>>>");
    HashMap<String, Object> response = new HashMap<String, Object>();

    try {
      authenticate(authDto.getUsername(), authDto.getPassword());

      final UserDetails userDetails = authService.loadUserByUsername(
        authDto.getUsername()
      );

      final String token = jwtTokenUtil.generateToken(userDetails);

      // check if user has changed its default password or not
      AuthModel currentUser = authService.getUserByUsername(
        authDto.getUsername()
      );

      response.put("token", token);

      response.put("username", currentUser.getUsername());

      // put user profile
      response.put(
        "profile",
        modelMapper.map(currentUser.getUserProfile(), UserProfileDto.class)
      );
    } catch (Exception e) {
      response = null;
      errorMessage = e.getMessage();
      exceptionMsg = e.toString();
    }

    return processResponse(errorMessage, exceptionMsg, response);
  }


  @GetMapping("/fetch/all")
  public ResponseEntity<ResponseMessage> fetchUsers() {
    List<UserProfileDto> response = null;
    try {
      response = authService.fetchAllUsers();
      if (response == null || response.isEmpty()) {
        errorMessage = NO_RECORD_FOUND;
        response = null;
      }
    } catch (Exception e) {
      errorMessage = JSON_PROCESSING_FAILED;
      exceptionMsg = e.getMessage();
    }

    return processResponse(errorMessage, exceptionMsg, response);
  }



  // @PostMapping("/update/password")
  // public ResponseEntity<ResponseMessage> updatePassword(
  //   @RequestBody UpdatePasswordDto updatePasswordDto
  // ) {
  //   String response = null;
  //   try {
  //     response = authService.updatePassword(updatePasswordDto);
  //     if (response == null) {
  //       errorMessage = DATA_ERROR;
  //     }
  //   } catch (Exception e) {
  //     errorMessage = JSON_PROCESSING_FAILED;
  //     exceptionMsg = e.getMessage();
  //   }

  //   return processResponse(errorMessage, exceptionMsg, response);
  // }

  @PostMapping("/update/profile")
  public ResponseEntity<ResponseMessage> updateProfile(
    @RequestBody UserProfileDto userProfileDto
  ) {
    UserProfileDto response = null;
    try {
      response = authService.updateProfile(userProfileDto);
      if (response == null) {
        errorMessage = DATA_ERROR;
      }
    } catch (Exception e) {
      errorMessage = JSON_PROCESSING_FAILED;
      exceptionMsg = e.getMessage();
    }

    return processResponse(errorMessage, exceptionMsg, response);
  }

  private void authenticate(String username, String password) throws Exception {
    try {
      authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(username, password)
      );
    } catch (DisabledException e) {
      throw new Exception("USER_DISABLED", e);
    } catch (BadCredentialsException e) {
      throw new Exception("INVALID_CREDENTIALS", e);
    }
  }
}
 */