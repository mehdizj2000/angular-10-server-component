package au.com.mehdi.hib.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.mehdi.hib.domain.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
	
	Optional<VerificationToken> findByToken(String token);
	
}
