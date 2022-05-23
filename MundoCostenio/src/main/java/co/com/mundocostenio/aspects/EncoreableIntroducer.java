package co.com.mundocostenio.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

import co.com.mundocostenio.services.DefaultEncoreable;
import co.com.mundocostenio.services.Encoreable;

@Aspect
public class EncoreableIntroducer {
	@DeclareParents(value ="concert.Performance+", defaultImpl =DefaultEncoreable.class)
	Encoreable encoreable;

}
