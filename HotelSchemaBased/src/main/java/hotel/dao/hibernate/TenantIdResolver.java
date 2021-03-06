package hotel.dao.hibernate;

import hotel.Login;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

public class TenantIdResolver implements CurrentTenantIdentifierResolver {
	
	@Override
	public String resolveCurrentTenantIdentifier() {
		System.out.println("*****tenantId*********"+Login.getTenantId());
		return Login.getTenantId();
	}

	@Override
	public boolean validateExistingCurrentSessions() {
		return true;
	}

}
