package iba.group.diplomAppStore.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@RequiredArgsConstructor
public class User implements UserDetails {
//    Implementations of UserDetails will provide some essential user information
//    to the framework, such as what authorities are granted to the user and whether
//    the user’s account is enabled or not.
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private final String username;
    private final String password;
    private final String fullname;
    private final String street;
    private final String city;
    private final String state;
    private final String zip;
    private final String phoneNumber;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }
//    The getAuthorities() method simply returns a collection indicating that all users will have been granted ROLE_USER authority
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }

//    @NotNull
//    @Size(min=2, message="Name must be at least 2 characters long")
//    private String firstName;
//    @NotNull
//    @Size(min=2, message="Last name must be at least 2 characters long")
//    private String lastName;
//    @NotNull
//    @Size(min=2, message="Street must be at least 2 characters long")
//    private String street;
//    @NotNull
//    @Size(min=2, message="City must be at least 2 characters long")
//    private String city;
//    @NotNull
//    @Size(min=2, message="State must be at least 2 characters long")
//    private String state;
//    @NotNull
//    @Digits(integer = 6, fraction = 0, message="Invalid ZIP")
//    private String zip;

}
