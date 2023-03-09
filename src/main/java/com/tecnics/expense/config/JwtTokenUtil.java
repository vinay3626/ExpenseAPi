/* package com.tecnics.expense.config;

import java.io.Serializable;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.tecnics.expense.models.UserProfileModel;
import com.tecnics.expense.repositories.UserProfileRepository;


@Component
public class JwtTokenUtil implements Serializable {

 

  private static final Logger log = LoggerFactory.getLogger(JwtTokenUtil.class);

  private static final long serialVersionUID = -2550185165626007488L;


  @Value("${jwt.secret}")
  private String SECRET;

  @Value("${jwt.tokenExpireTime}")
  private Long JWT_TOKEN_VALIDITY;

  @Value("${jwt.tokenRefreshTime}")
  private Long JWT_TOKEN_REFRESH;

  @Value("${jwt.authorities.key}")
  public String AUTHORITIES_KEY;

  @Autowired
  UserProfileRepository userProfileRepo;



   // retrieve username from jwt token
   public String getUsernameFromToken(String token) {
    return getClaimFromToken(token, Claims::getSubject);
  }

  // retrieve expiration date from jwt token
  public Date getExpirationDateFromToken(String token) {
    return getClaimFromToken(token, Claims::getExpiration);
  }

  public <T> T getClaimFromToken(
    String token,
    Function<Claims, T> claimsResolver
  ) {
    final Claims claims = getAllClaimsFromToken(token);
    return claimsResolver.apply(claims);
  }

  // for retrieveing any information from token we will need the secret key
  private Claims getAllClaimsFromToken(String token) {
    return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
  }

  // check if the token has expired
  private Boolean isTokenExpired(String token) {
    final Date expiration = getExpirationDateFromToken(token);
    return expiration.before(new Date());
  }

  // generate token for user
  public String generateToken(UserDetails userDetails) {
    log.info("<<< generating token >>>");
    Map<String, Object> claims = new HashMap<>();
    UserProfileModel user = userProfileRepo.findByEmail(
      userDetails.getUsername()
    );
    //  when there is multiple roles assigned to a user. currently one user = one role
    // Set<String> Userroles = new HashSet<>();
    // for (Role role : user.getRoles()) {
    //   Userroles.add(role.getName());
    // }
    // claims.put("roles", Userroles.toArray());

    claims.put("role", user.getRole());
    return doGenerateToken(claims, userDetails.getUsername());
  }

  // while creating the token -
  // 1. Define claims of the token, like Issuer, Expiration, Subject, and the ID
  // 2. Sign the JWT using the HS512 algorithm and secret key.
  // 3. According to JWS Compact
  // Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
  // compaction of the JWT to a URL-safe string
  private String doGenerateToken(Map<String, Object> claims, String subject) {
    return Jwts
      .builder()
      .setClaims(claims)
      .setSubject(subject)
      .setIssuedAt(new Date(System.currentTimeMillis()))
      .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
      .signWith(SignatureAlgorithm.HS512, SECRET)
      .compact();
  }

  // validate token
  public Boolean validateToken(String token, UserDetails userDetails) {
    final String username = getUsernameFromToken(token);
    return (
      username.equals(userDetails.getUsername()) && !isTokenExpired(token)
    );
  }
}
 */