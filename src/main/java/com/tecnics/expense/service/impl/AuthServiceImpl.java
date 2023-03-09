/* package com.tecnics.expense.service.impl;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
// import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import com.tecnics.expense.config.GlobalInfo;
import com.tecnics.expense.dtos.AuthDto;
import com.tecnics.expense.dtos.UserProfileDto;
import com.tecnics.expense.models.AuthModel;
import com.tecnics.expense.models.UserProfileModel;
import com.tecnics.expense.repositories.AuthRepository;
import com.tecnics.expense.repositories.UserProfileRepository;
import com.tecnics.expense.services.AuthServices;
import com.tecnics.expense.utils.userRoleEnum;


@Service
public class AuthServiceImpl implements AuthServices {

 
    @Autowired
    private AuthRepository authRepo;
  
    @Autowired
    private UserProfileRepository userProfileRepo;
  
    @Autowired
    private PasswordEncoder bcryptEncoder;
  
    @Autowired
    GlobalInfo globalInfo;
  
    ModelMapper modelMapper = new ModelMapper();
  
    @Override
    public AuthModel saveUser(AuthDto userDto) throws Exception {
      // create new jwt user
      AuthModel jwtUser = new AuthModel(
       userDto.getUsername(),
        bcryptEncoder.encode(userDto.getPassword()
        )
      );
  
      // create user profile
      UserProfileModel userProfile = new UserProfileModel(
       userDto.getUserProfile().getFirstName(),
        userDto.getUserProfile().getLastName(),
        // setting email = username as username will be email, so both must be same. Overriding email provided in user-profile
        // userDto.getUserProfile().getEmail(),
        userDto.getUsername(),
        // setting default role to USER
        userRoleEnum.USER
      );
  
      // Set child reference(userProfile) in parent entity(user)
      jwtUser.setUserProfile(userProfile);
  
      // Set parent reference(user) in child entity(userProfile)
      userProfile.setUserAuth(jwtUser);
  
      // Save Parent Reference (which will save the child as well)
      return authRepo.save(jwtUser);
      // userModel.setPassword(bcryptEncoder.encode(userDto.getPassword()));
      // return authRepo.save(userModel);
  
    }
  
    @Override
    public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {
      AuthModel authModel = authRepo.findByUsername(username);
      if (authModel == null) {
        throw new UsernameNotFoundException(
          "User not found with username: " + username
        );
      }
      return new org.springframework.security.core.userdetails.User(
        authModel.getUsername(),
        authModel.getPassword(),
        new ArrayList<>()
      );
    }
  
    @Override
    public List<UserProfileDto> fetchAllUsers() {
      Type listType = new TypeToken<List<UserProfileDto>>() {}.getType();
      List<UserProfileDto> userProfileList = modelMapper.map(
        userProfileRepo.findAll(),
        listType
      );
      return userProfileList;
    }
  
    @Override
    public AuthModel getUserByUsername(String username) {
      return authRepo.findByUsername(username);
    }
  
    // @Override
    // public String updatePassword(UpdatePasswordDto updatePasswordDto) {
    //   // find user in db by username
    //   AuthModel user = authRepo.findByUsername(globalInfo.getCurrentUserName());
  
    //   Boolean res = bcryptEncoder.matches(
    //     updatePasswordDto.getOldPassword(),
    //     user.getPassword()
    //   );
  
    //   if (res) {
    //     // change password
    //     user.setPassword(
    //       bcryptEncoder.encode(updatePasswordDto.getNewPassword())
    //     );
  
    //     // updating user info in db and then casting back to userDto
    //     authRepo.save(user);
    //     return "Password Updated";
    //   } else {
    //     return "Invalid Password";
    //   }
    // }
  
    @Override
    public UserProfileDto updateProfile(UserProfileDto userProfileDto) {
      // find user in db by username
      UserProfileModel user = userProfileRepo.findByEmail(
        globalInfo.getCurrentUserName()
      );
  
      user.setFirstName(userProfileDto.getFirstName());
      user.setLastName(userProfileDto.getLastName());
  
      return modelMapper.map(userProfileRepo.save(user), UserProfileDto.class);
    }
    
}
 */