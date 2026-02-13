package com.chom.teluskospringsecurity6withspringbootjwttutorial.Services;

//import com.chom.teluskospringsecurity6withspringbootjwttutorial.Models.UserDetailsImpl;

//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserRep usersRep;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user =  usersRep.findByUsername(username);
//        if (user == null)
//            throw new RuntimeException("username didn't exist");
//        UserDetailsImpl userDetails = new UserDetailsImpl(user);
//        return userDetails;
//    }
//}
