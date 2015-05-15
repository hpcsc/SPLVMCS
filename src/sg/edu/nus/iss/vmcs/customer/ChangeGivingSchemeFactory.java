package sg.edu.nus.iss.vmcs.customer;

import sg.edu.nus.iss.vmcs.system.Environment;

public class ChangeGivingSchemeFactory {
	public static ChangeGivingScheme getChangeGivingScheme() {
		if(Environment.getChangeGivingScheme().toLowerCase().equals("balanced")) {
			return new BalancedNoOfDenominationScheme();
		}
		else {
			return new LargerDenominationFirstScheme();
		}
	}
}
