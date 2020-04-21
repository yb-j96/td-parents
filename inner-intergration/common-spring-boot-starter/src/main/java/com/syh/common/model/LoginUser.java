package com.syh.common.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author jyb
 * @Date 2020/4/16 09:37
 */
@Data
public class LoginUser extends SysUser implements UserDetails {

    private Set<SysRole> sysRoles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new HashSet<>();
        Collection<GrantedAuthority> synchronizedCollection = Collections.synchronizedCollection(collection) ;
		if (!CollectionUtils.isEmpty(sysRoles)) {
			sysRoles.parallelStream().forEach(role -> {
			    if ("0".equals(role.getEnable())) {
                    if (role.getRoleName().startsWith("ROLE_")) {
                        synchronizedCollection.add(new SimpleGrantedAuthority(role.getRoleName()));
                    } else {
                        synchronizedCollection.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
                    }
                }
			});
		}

		/*if (!CollectionUtils.isEmpty(permissions)) {
			permissions.parallelStream().forEach(per -> {
				synchronizedCollection.add(new SimpleGrantedAuthority(per));
			});
		}*/
        return collection;
    }

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
        if (!"0".equals(getRecyclingStatus())) {
            return false;
        }
        return true;
    }
}
