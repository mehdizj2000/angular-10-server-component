package au.com.mehdi.hib.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.mehdi.hib.domain.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

}
